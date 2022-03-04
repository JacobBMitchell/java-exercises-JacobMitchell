package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForagerRepository;
import learn.foraging.models.Forager;

import java.util.List;
import java.util.stream.Collectors;

public class ForagerService {

    private final ForagerRepository repository;

    public ForagerService(ForagerRepository repository) {
        this.repository = repository;
    }

    public List<Forager> findByState(String stateAbbr) {
        return repository.findByState(stateAbbr);
    }

    public List<Forager> findByLastName(String prefix) {
        return repository.findAll().stream()
                .filter(i -> i.getLastName().startsWith(prefix))
                .collect(Collectors.toList());
    }

    public Result<Forager> addForager(Forager forager) throws DataException {
        Result<Forager> result = new Result<>();
        if (forager == null) {
            result.addErrorMessage("Cannot be null");
            return result;
        }
        result = validate(forager);
        if(result.isSuccess()){
            //return repository.addForager(forager);
        }
       return result;
    }

    private Result<Forager> validate(Forager forager) {
        Result<Forager> result = new Result<>();
        if(forager.getFirstName().isEmpty() || forager.getFirstName() == null){
            result.addErrorMessage("Needs First Name.");
        }
        if(forager.getLastName().isEmpty() || forager.getLastName() == null){
            result.addErrorMessage("Needs Last Name");
        }
        return result;
    }
}
