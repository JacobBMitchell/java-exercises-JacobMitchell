package dwmh.domain;

import dwmh.data.DataException;
import dwmh.data.GuestRepository;
import dwmh.models.Guest;

import java.util.List;

public class GuestService {
    GuestRepository repo;

    public GuestService(GuestRepository repo) {
        this.repo = repo;
    }

    public List<Guest> findAll() throws DataException {
        return repo.findAll();
    }

    public Result<Guest> add(Guest guest) throws DataException {
        Result<Guest> result = new Result<>();
        if (guest == null){
            result.addError("Cannot have null guest");
            return result;
        }
        result = validate(guest);

        //prevents repeats as well as protects against null values passing
        if (result.isSuccess() && repo.findAll().stream().anyMatch(a -> a.getFirstName().equalsIgnoreCase(guest.getFirstName()) &&
                a.getLastName().equalsIgnoreCase(guest.getLastName()) &&
                a.getState().equalsIgnoreCase(guest.getState())
                )){
            result.addError("Guest already exists");
        }

        if (result.isSuccess()){
            result.setPayload(repo.add(guest));
        }

        return result;
    }

    private Result<Guest> validate(Guest guest) {
        Result<Guest> result = new Result<>();
        if (guest.getFirstName() == null || guest.getFirstName().isEmpty()){
            result.addError("Need a first name");
        }
        if (guest.getLastName() == null || guest.getLastName().isEmpty()){
            result.addError("Need a last name");
        }
        if (guest.getEmail() == null || guest.getEmail().isEmpty()){
            result.addError("Need a email");
        }
        if (guest.getPhone() == null || guest.getPhone().isEmpty()){
            result.addError("Need a phone number");
        }
        if (guest.getState() == null || guest.getState().isEmpty()){
            result.addError("Need a state");
        }
        if (result.isSuccess()) {
            if (guest.getState().length() != 2) {
                result.addError("Needs to be 2 letter representation of state");
            }
        }
        return result;
    }

    public Result<Guest> updateById(int id ,Guest guest) throws DataException {
        Result<Guest> result = new Result<>();
        if (guest == null) {
            result.addError("Cannot have null guest");
            return result;
        }
        result = validate(guest);
        if (repo.findAll().stream().noneMatch(a -> a.getId()==id)){
            result.addError("There is no ID to match or guest does not exist");
        }

        if (result.isSuccess() && repo.findAll().stream().anyMatch(a -> a.getFirstName().equalsIgnoreCase(guest.getFirstName()) &&
                a.getLastName().equalsIgnoreCase(guest.getLastName()) &&
                a.getState().equalsIgnoreCase(guest.getState()) &&
                a.getId() != id
        )){
            result.addError("Guest exists under different Id");
        }

        if (result.isSuccess() && repo.findAll().stream().anyMatch(a -> a.getFirstName().equalsIgnoreCase(guest.getFirstName()) &&
                a.getLastName().equalsIgnoreCase(guest.getLastName()) &&
                a.getState().equalsIgnoreCase(guest.getState()) &&
                a.getPhone().equalsIgnoreCase(guest.getPhone()) &&
                a.getEmail().equals(guest.getEmail())
        )){
            result.addError("Guest already exists");
        }

        if (result.isSuccess() && repo.updateById(id,guest)){
            result.setPayload(guest);
        }
        return result;
    }

    public Result<Integer> deleteById(int id)throws DataException{
       Result<Integer> result = new Result<>();
        if (repo.findAll().stream().noneMatch(a -> a.getId()==id)){
            result.addError("There is no ID to match or guest does not exist");
        }
        if (result.isSuccess() && repo.deleteById(id)){
            result.setPayload(id);
        }
        return result;
    }
}
