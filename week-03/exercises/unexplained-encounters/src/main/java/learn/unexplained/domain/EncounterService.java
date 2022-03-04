package learn.unexplained.domain;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.data.EncounterRepository;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EncounterService {

    private final EncounterRepository repository;

    public EncounterService(EncounterRepository repository) {
        this.repository = repository;
    }

    public List<Encounter> findAll() throws DataAccessException {
        return repository.findAll();
    }

    public EncounterResult add(Encounter encounter) throws DataAccessException {
        EncounterResult result = validate(encounter);
        if (!result.isSuccess()) {
            return result;
        }

        // check for duplicate
        List<Encounter> encounters = repository.findAll();
        for (Encounter e : encounters) {
            if (Objects.equals(encounter.getWhen(), e.getWhen())
                    && Objects.equals(encounter.getType(), e.getType())
                    && Objects.equals(encounter.getDescription(), e.getDescription())) {
                result.addErrorMessage("duplicate encounter is not allowed");
                return result;
            }
        }

        encounter = repository.add(encounter);
        result.setPayload(encounter);
        return result;
    }

    private EncounterResult validate(Encounter encounter) {

        EncounterResult result = new EncounterResult();
        if (encounter == null) {
            result.addErrorMessage("encounter cannot be null");
            return result;
        }

        if (encounter.getWhen() == null || encounter.getWhen().trim().length() == 0) {
            result.addErrorMessage("when is required");
        }

        if (encounter.getDescription() == null || encounter.getDescription().trim().length() == 0) {
            result.addErrorMessage("description is required");
        }

        if (encounter.getOccurrences() <= 0) {
            result.addErrorMessage("occurrences must be greater than 0");
        }

        return result;
    }

    public List<Encounter> findByType(EncounterType encType) throws DataAccessException {
        if (encType != null) {
            return repository.findByType(encType);
        }
        return new ArrayList<>(); //pass through method
    }

    public EncounterResult deleteById(int memoryId) throws DataAccessException{
        EncounterResult result = new EncounterResult();
        if (!repository.deleteById(memoryId)){
            String message = String.format("Encounter id %s was not found: ", memoryId);
            result.addErrorMessage(message);
        }
        return result; //qualifies that deleteById works
    }

    public EncounterResult update(Encounter enc) throws DataAccessException{
        EncounterResult result = new EncounterResult();
        result = validate(enc);
        if (isDuplicate(enc)){
            result.addErrorMessage("This encounter has already been created");
        }
        if (result.isSuccess()){
            if (repository.update(enc)) {
                result.setPayload(enc);
            }else {
                result.addErrorMessage("Encounter not found.");
            }
        }
        return result;
    }

    private boolean isDuplicate(Encounter enc) throws DataAccessException {
        List<Encounter> all = repository.findAll();
        for (Encounter encounter: all){
            if(enc.getType() == encounter.getType() && enc.getDescription().equals(encounter.getDescription()) &&
                    enc.getWhen().equals(encounter.getWhen())){
                return true;
            }
        }
        return false;
    }

}
