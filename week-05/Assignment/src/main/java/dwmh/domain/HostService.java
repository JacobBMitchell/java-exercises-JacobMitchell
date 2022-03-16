package dwmh.domain;

import dwmh.data.DataException;
import dwmh.data.HostRepository;
import dwmh.models.Host;
import dwmh.models.Location;


import java.math.BigDecimal;
import java.util.List;

public class HostService {
    HostRepository repo;


    public HostService(HostRepository repo) {
        this.repo = repo;
    }
    public List<Host> findAll() throws DataException {
        return repo.findAll();
    } //I think this is all I need

    public Result<Host> add(Host host) throws DataException {
        Result<Host> result = new Result<>();
        if (host == null){
            result.addError("Cannot have null host");
            return result;
        }
        result = validate(host);

        //prevents repeats as well as protects against null values passing
        if (result.isSuccess() && repo.findAll().stream().anyMatch(a ->
                a.getLocation().equals(host.getLocation()) ||
                        (a.getLastName().equals(host.getLastName()) && a.getPhone().equals(host.getPhone()) && a.getEmail().equals(host.getEmail()))
        )){
            result.addError("Host already exists");
        }

        if (result.isSuccess()){
            result.setPayload(repo.add(host));
        }

        return result;
    }

    private Result<Host> validate(Host host) {
        Result<Host> result = new Result<>();
        if (host.getLastName() == null || host.getLastName().isEmpty()){
            result.addError("Need a last name");
        }
        if (host.getEmail() == null || host.getEmail().isEmpty()){
            result.addError("Need a email");
        }
        if (host.getPhone() == null || host.getPhone().isEmpty()){
            result.addError("Need a phone number");
        }
        if (host.getLocation() == null){
            result.addError("Location required");
            return result;
        }
        Location loco = host.getLocation();
        if (loco.getState() == null || loco.getState().isEmpty()){
            result.addError("Need a state");
        }
        if (result.isSuccess()) {
            if (loco.getState().length() != 2) {
                result.addError("Needs to be 2 letter representation of state");
            }
        }
        if (loco.getAddress() == null || loco.getAddress().isEmpty()){
            result.addError("Need an address line");
        }
        if (loco.getCity() == null || loco.getCity().isEmpty()){
            result.addError("Need a phone number");
        }
        if (loco.getZipCode() > 99999 || loco.getZipCode() < 10000){
            result.addError("Zip code is out of range");
        }
        if (loco.getRate().compareTo(BigDecimal.ZERO) <0){
            result.addError("Rates on weekdays cannot be negative");
        }
        if (loco.getWeekendRate().compareTo(BigDecimal.ZERO) <0){
            result.addError("Rates on weekends cannot be negative");
        }

        return result;
    }

//    public Result<Host> updateById(String id ,Host host) throws DataException {
//        Result<Host> result = new Result<>();
//        if (host == null) {
//            result.addError("Cannot have null host");
//            return result;
//        }
//        result = validate(host);
//        if (repo.findAll().stream().noneMatch(a -> a.getId().equals(id))){
//            result.addError("There is no ID to match or host does not exist");
//        }
//
//        if (result.isSuccess() && repo.findAll().stream().anyMatch(a ->
//                a.getLocation().equals(host.getLocation()) &&
//                !a.getId().equals(id)
//        )){
//            result.addError("Host exists under different Id");
//        }
//
//        if (result.isSuccess() && repo.findAll().stream().anyMatch(a ->
//                a.getLastName().equalsIgnoreCase(host.getLastName()) &&
//                a.getLocation().equals(host.getLocation()) &&
//                a.getPhone().equalsIgnoreCase(host.getPhone()) &&
//                a.getEmail().equals(host.getEmail())
//        )){
//            result.addError("Host already exists");
//        }
//
//        if (result.isSuccess() && repo.updateById(id,host)){
//            result.setPayload(host);
//        }
//        return result;
//    }
//
//    public Result<String> deleteById(String id)throws DataException{
//        Result<String> result = new Result<>();
//        if (repo.findAll().stream().noneMatch(a -> a.getId().equals(id))){
//            result.addError("There is no ID to match or host does not exist");
//        }
//        if (result.isSuccess() && repo.deleteById(id)){
//            result.setPayload(id);
//        }
//        return result;
//    }
}
