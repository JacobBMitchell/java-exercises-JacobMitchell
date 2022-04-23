package memories.domain;

import memories.data.DataAccessException;
import memories.data.MemoryRepository;
import memories.models.Memory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

//@Service
public class MemoryService implements MemoryServiceTemplate {

    private final MemoryRepository repository;

    public MemoryService(MemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Memory> findPublicMemories() throws DataAccessException{
        return repository.findShareable(true);
    }

    @Override
    public List<Memory> findPrivateMemories() throws DataAccessException{
        return repository.findShareable(false);
    }

    @Override
    public MemoryResult add(Memory memory)throws DataAccessException{
        MemoryResult result = new MemoryResult();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Memory>> violations = validator.validate(memory);
        if (!violations.isEmpty()) {
            violations.forEach(a -> result.addErrorMessage(a.getMessage()));
        }
        if(memory.getId() > 0){
            result.addErrorMessage("Memory 'id' should not be set.");
        }
        if(result.isSuccess()){
            memory = repository.add(memory); //a bit more checking around adding
            result.setMemory(memory);
        }
        return result;
    }

    @Override
    public MemoryResult update(Memory memory)throws DataAccessException{
        MemoryResult result = new MemoryResult();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Memory>> violations = validator.validate(memory);
        if (!violations.isEmpty()) {
            violations.forEach(a -> result.addErrorMessage(a.getMessage()));
        }

        if (memory.getId() <= 0){
            result.addErrorMessage("Memory 'id' is required.");
        }

        if (result.isSuccess()) {
            if (repository.update(memory)) { // making sure our repository is updated
                result.setMemory(memory);
            } else{
                String message = String.format("Memory id %s was not found.", memory.getId());
                result.addErrorMessage(message);
            }
        }
        return result;
    }

    @Override
    public MemoryResult deleteById(int memoryId) throws DataAccessException{
        MemoryResult result = new MemoryResult();
        if (!repository.deleteById(memoryId)){
            String message = String.format("Memory id %s was not found.", memoryId);
            result.addErrorMessage(message);
        }
        return result;
    }

//    private MemoryResult validate(Memory memory) {
//        MemoryResult result = new MemoryResult();
//
//        if (memory == null) {
//            result.addErrorMessage("Memory cannot be null.");
//            return result;
//        }
//
//        if (memory.getFrom() == null || memory.getFrom().isBlank()) {
//            result.addErrorMessage("Memory `from` is required.");
//        }
//
//        if (memory.getContent() == null || memory.getContent().isBlank()) {
//            result.addErrorMessage("Memory `content` is required.");
//        }
//
//        return result;
//    }
}
