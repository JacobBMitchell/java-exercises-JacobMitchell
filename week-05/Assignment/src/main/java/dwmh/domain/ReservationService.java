package dwmh.domain;

import dwmh.data.DataException;
import dwmh.data.GuestRepository;
import dwmh.data.HostRepository;
import dwmh.data.ReservationRepository;
import dwmh.models.Host;
import dwmh.models.Reservation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    GuestRepository gRepo;
    HostRepository hRepo;
    ReservationRepository repo;

    public ReservationService(GuestRepository gRepo, HostRepository hRepo, ReservationRepository repo) {
        this.gRepo = gRepo;
        this.hRepo = hRepo;
        this.repo = repo;
    }

    public List<Reservation> findByHost(Host host) throws DataException {
        if (host == null || host.getId() == null || host.getId().isEmpty()) {
            return new ArrayList<Reservation>();
        }
        return repo.findByHost(host.getId());
    }
    public List<Reservation> findByHost(String hostId) throws DataException {
        if ( hostId == null || hostId.isEmpty()) {
            return new ArrayList<Reservation>();
        }
        return repo.findByHost(hostId);
    }

    //add reservation with guest and host
    public Result<Reservation> addReservation(Reservation reservation) throws DataException {
        Result<Reservation> result = new Result<>();
        if (reservation == null){
            result.addError("Cannot have null Reservation");
            return result;
        }
        result = validate(reservation);
        if (result.isSuccess() && concurrent(reservation.getStart(),reservation.getEnd(),reservation.getHostId())){
            result.addError("That time slot is taken");
        }

        if (result.isSuccess()){
            result.setPayload(repo.add(reservation));
        }
        return result;
    }

    private Result<Reservation> validate(Reservation reservation) throws DataException {
        Result<Reservation> result = new Result<>();
        if (reservation.getHostId() == null || reservation.getHostId().isEmpty()){
            result.addError("Needs host id");
            return result;
        }
        if (hRepo.findAll().stream().noneMatch(a -> a.getId().equals(reservation.getHostId()))){
            result.addError("No such host exists");
        }
        if (reservation.getGuestId() == 0 || gRepo.findAll().stream().noneMatch(a -> a.getId() == reservation.getGuestId() )){
            result.addError("No such guest exists");
        }
        if (reservation.getTotal() == null){
            result.addError("Need Total");
            return result;
        }
        if (reservation.getTotal().compareTo(BigDecimal.ZERO) < 0){
            result.addError("Total cannot be negative");
        }
        if (reservation.getStart() == null || reservation.getEnd() == null){
            result.addError("Need both start and end time");
            return result;
        }
        if (reservation.getStart().isAfter(reservation.getEnd()) || reservation.getStart().isEqual(reservation.getEnd())){
            result.addError("Invalid time frame");
        }
        if (reservation.getStart().isBefore(LocalDate.now())){
            result.addError("Cannot have start date before today");
        }
        return result;
    }

    private boolean concurrent(LocalDate start, LocalDate end, String hostId) throws DataException {
        boolean overlap;
        List<Reservation> all =repo.findByHost(hostId);
        overlap = all.stream().anyMatch(a -> (start.isAfter(a.getStart()) && end.isBefore(a.getEnd())) ||
                (end.isAfter(a.getStart()) && end.isBefore(a.getEnd())) ||
                (start.isBefore(a.getEnd()) && start.isAfter(a.getStart())) ||
                (start.isBefore(a.getStart()) && end.isAfter(a.getEnd())) ||
                (start.isEqual(a.getStart()) && end.isEqual(a.getEnd()))
        );
        return overlap;
    }

    //edit an existing reservation
    public Result<Reservation> updateById(int id, Reservation reso) throws DataException {
        Result<Reservation> result = new Result<>();

        if (reso == null){
            result.addError("The reservation cannot be null");
            return result;
        }

        String hostId = reso.getHostId();
        Host host = new Host();
        if (hostId != null) {
            host = hRepo.findAll().stream().filter(a -> a.getId().equals(hostId)).findFirst().orElse(null);
        }

        if (host == null){
            result.addError("Host by that Id doesn't exist");
            return result;
        }

        result = validate(reso);
        boolean overlap = false;
        List<Reservation> all = repo.findByHost(hostId);
        if (result.isSuccess()) {
            for (Reservation r : all) {
                if (r.getId() != id) {
                    overlap = overlapping(reso.getStart(),reso.getEnd(), r.getStart(),r.getEnd());
                }

            }

        }
        if (overlap){
            result.addError("That time slot is taken");
        }

        if (repo.findByHost(hostId).stream().noneMatch(a -> a.getId() == id)){
            result.addError("No reservation by that id");
        }


        if (result.isSuccess()){
            if(repo.updateById(id,host,reso)){
                result.setPayload(reso);
            }
            else {
                result.addError("Unable to update");
            }
        }
        return result;
    }

    private boolean overlapping(LocalDate start, LocalDate end, LocalDate start1, LocalDate end1) {
        return (start.isAfter(start1) && end.isBefore(end1)) ||
        (end.isAfter(start1) && end.isBefore(end1)) ||
                (start.isBefore(end1) && start.isAfter(start1)) ||
                (start.isBefore(start1) && end.isAfter(end1)) ||
                (start.isEqual(start1) && end.isEqual(end1));
    }


    //delete a FUTURE reservation
    public Result<Boolean> deleteByHostAndId(Host host, int id) throws DataException {
        Result<Boolean> deleted = new Result<>();
        deleted.setPayload(false);
        if (host == null) {
            deleted.addError("Host cannot be null");
            return deleted;
        }
        if (repo.findByHost(host.getId()).stream().noneMatch(a -> a.getId() == id)){
            deleted.addError("That Id does not exist in this host");
        }
        if (deleted.isSuccess()) {
            Reservation r = repo.findByHost(host.getId()).stream().filter(a -> a.getId() == id).toList().get(0);
            if (r.getStart().isBefore(LocalDate.now()) || r.getEnd().isBefore(LocalDate.now())) {
                deleted.addError("Cannot delete past reservations"); //allows for the deletion day of.
            }
        }
        if(deleted.isSuccess()){
            deleted.setPayload(repo.deleteById(id,host));
        }
        return deleted;
    }

    public Result<Boolean> deleteByHostAndId(String hostId, int id) throws DataException {
        Result<Boolean> deleted = new Result<>();
        deleted.setPayload(false);
        Host host = new Host();
        if (hostId != null) {
            host = hRepo.findAll().stream().filter(a -> a.getId().equals(hostId)).findFirst().orElse(null);
        }

        if (hostId == null){
            deleted.addError("Host by that Id doesn't exist");
            return deleted;
        }
        if (repo.findByHost(hostId).stream().noneMatch(a -> a.getId() == id)){
            deleted.addError("That Id does not exist in this host");
        }
        if (deleted.isSuccess()) {
            Reservation r = repo.findByHost(host.getId()).stream().filter(a -> a.getId() == id).toList().get(0);
            if (r.getStart().isBefore(LocalDate.now()) || r.getEnd().isBefore(LocalDate.now())) {
                deleted.addError("Cannot delete past reservations"); //allows for the deletion day of.
            }
        }

        if(deleted.isSuccess()){
            deleted.setPayload(repo.deleteById(id,host));
        }
        return deleted;
    }
}
