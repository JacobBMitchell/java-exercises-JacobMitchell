package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForagerRepository;
import learn.foraging.models.Forager;

import java.util.List;
import java.util.Objects;
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

        List<Forager> all = repository.findAll();
        if (all.stream().anyMatch(f-> f.getState().equals(forager.getState())&&
                f.getFirstName().equalsIgnoreCase(forager.getFirstName()) && f.getLastName().equalsIgnoreCase(forager.getLastName()))){
            result.addErrorMessage("That person already exists");
        }
            //return repository.addForager(forager);
        if(result.isSuccess()) {
            result.setPayload(forager);
            repository.addForager(forager);
        }

       return result;
    }

    private Result<Forager> validate(Forager forager) {
        Result<Forager> result = new Result<>();
        if(forager.getFirstName() == null ||forager.getFirstName().isBlank()){
            result.addErrorMessage("Needs First Name.");
        }
        if(forager.getLastName() == null || forager.getLastName().isBlank()){
            result.addErrorMessage("Needs Last Name");
        }
        if(forager.getState() == null || forager.getState().isBlank() ){
            result.addErrorMessage("Need State");
        }
        return result;
    }
}
