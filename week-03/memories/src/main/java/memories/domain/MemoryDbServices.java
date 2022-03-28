package memories.domain;

import memories.data.DataAccessException;
import memories.data.MemoryRepository;
import memories.models.Memory;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO: make this the @service class
@Service
public class MemoryDbServices implements MemoryServiceTemplate {


        private final MemoryRepository repository;

        public MemoryDbServices(MemoryRepository repository) {
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
    public MemoryResult add(Memory memory) throws DataAccessException {
        MemoryResult result = new MemoryResult();
        //TODO: Validate inputs
        result.setMemory(repository.add(memory));
        return result;
    }

    @Override
    public MemoryResult update(Memory memory) throws DataAccessException {
        MemoryResult result = new MemoryResult();
        boolean updated = repository.update(memory);
        if (!updated){
            result.addErrorMessage("No good");
            return result;
        }
        return result;
    }

    @Override
    public MemoryResult deleteById(int memoryId) throws DataAccessException {
        MemoryResult result = new MemoryResult();
        boolean b = repository.deleteById(memoryId);
        if (!b){
            result.addErrorMessage("No good");
            return result;
        }
        return result;
    }
}
