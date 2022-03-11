package dwmh.controller;

import dwmh.data.DataException;
import dwmh.domain.GuestService;
import dwmh.domain.HostService;
import dwmh.domain.ReservationService;
import dwmh.domain.Result;
import dwmh.models.Guest;
import dwmh.models.Host;
import dwmh.models.Reservation;
import dwmh.view.MenuOption;
import dwmh.view.View;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Controller {
    final private HostService hs;
    final private GuestService gs;
    final private ReservationService rs;
    final private View view;

    public Controller(HostService hs, GuestService gs, ReservationService rs, View view) {
        this.hs = hs;
        this.gs = gs;
        this.rs = rs;
        this.view = view;
    }

    public void run(){
        view.header("Welcome to Don't Wreck My House");
        try{
            running();
        }catch (DataException e){
            System.out.println(e.getMessage());
        }

    }

    private void running() throws DataException{
        MenuOption option;
        do{
            view.header("Main Menu");
            view.mainMenu(MenuOption.values());
            option = MenuOption.choice(view.getInt("Pick 0-4: ",0,4));
            switch(option){
                case VIEWRESERVATIONSBYHOST:
                    reservationByHost();
                    break;
                case CREATERESERVATION:
                    createReservation();
                    break;
                case EDITEXISTING:
                    editExisting();
                    break;
                case CANCELRESERVATION:
                    deleteReservation();
                    break;
            }
        }while (option != MenuOption.QUIT);
        view.println("Thank-you for using Don't Wreck My House");
    }

    private void deleteReservation() throws DataException {
        view.header("Choose the host of the reservation");
        Host host = view.findHost(hs.findAll());
        if (host == null) {
            return;
        }
        List<Guest> guests = gs.findAll();
        List<Reservation> all = rs.findByHost(host);
        if (all.size() == 0){
            view.println("They have no reservations currently");
            return;
        }
        int id = view.chooseReservation(all, host,guests,"delete");
        if (id == -1){
            return;
        }
        if (!view.getBoolean("Are you sure you want to delete?[y/n] ")){
            return;
        }
        Result<Boolean> result = rs.deleteByHostAndId(host, id);
        if (!result.isSuccess()){
            view.displayErrors(result.getErrors());
        }
        else{
            view.println("Reservation id: "+id+" deleted for host " + host.getLastName()+".");
        }
    }

    private void editExisting() throws DataException {
        view.header("Choose the host of the reservation");
        Host host = view.findHost(hs.findAll());
        if (host == null) {
            return;
        }
        List<Guest> guests = gs.findAll();
        List<Reservation> all = rs.findByHost(host);
        if (all.size() == 0){
            view.println("They have no reservations currently");
            return;
        }
        int id = view.chooseReservation(all, host,guests,"update");
        if (id == -1){
            return;
        }
        Reservation reservation = rs.findByHost(host.getId()).stream()
                .filter(a -> a.getId() == id).toList().get(0);

        reservation = view.getTimesDefault(reservation);

        BigDecimal total = findTotal(reservation.getStart(), reservation.getEnd(),host.getLocation().getRate(),host.getLocation().getWeekendRate());
//        total = total.setScale(2, RoundingMode.HALF_UP);
        Result<Reservation> result;
        if (view.getBoolean("Is $" + total +" acceptable?[y/n] ")){
            reservation.setTotal(total);
        }
        else{
            return;
        }
        result = rs.updateById(id,reservation);
        if (result.isSuccess()){
            Reservation finalReserve1 = reservation;
            Guest g = guests.stream().filter(a -> a.getId() == finalReserve1.getGuestId()).toList().get(0);
            view.println("Reservation for " + g.getFirstName() + " " + g.getLastName() + "\n" +
                    "At: "+ host.getLocation().getAddress() +", " + host.getLocation().getCity() + ", " +
                    host.getLocation().getState() + " " + host.getLocation().getZipCode() + "\n" +
                    "For: $" +reservation.getTotal() +" to "+host.getLastName() + ".");
            return;
        }
        view.displayErrors(result.getErrors());


       // Result<Reservation> result = rs.updateById(id,reservation);
    }

    private void createReservation() throws DataException {
        List<Host> hosts = hs.findAll();
        List<Guest> guests = gs.findAll();
        Reservation reserve = view.getReservation(hosts,guests);
        if (reserve == null){
            return;
        }
        Reservation finalReserve = reserve;
        Host host = hosts.stream().filter(a -> a.getId().equals(finalReserve.getHostId())).toList().get(0);
        view.displayReservations(rs.findByHost(reserve.getHostId()),host,guests);

        reserve = view.getTimes(reserve);

        BigDecimal total = findTotal(reserve.getStart(), reserve.getEnd(),host.getLocation().getRate(),host.getLocation().getWeekendRate());
//        total = total.setScale(2, RoundingMode.HALF_UP);
        Result<Reservation> result;
        if (view.getBoolean("Is $" + total +" acceptable?[y/n] ")){
            reserve.setTotal(total);
        }
        else{
            return;
        }
        result = rs.addReservation(reserve);
        if (result.isSuccess()){
            Reservation finalReserve1 = reserve;
            Guest g = guests.stream().filter(a -> a.getId() == finalReserve1.getGuestId()).toList().get(0);
            view.println("Reservation for " + g.getFirstName() + " " + g.getLastName() + "\n" +
                    "At: "+ host.getLocation().getAddress() +", " + host.getLocation().getCity() + ", " +
                    host.getLocation().getState() + " " + host.getLocation().getZipCode() + "\n" +
                    "For: $" +reserve.getTotal() +" to "+host.getLastName() + ".");
            return;
        }
        view.displayErrors(result.getErrors());
    }

    private BigDecimal findTotal(LocalDate start, LocalDate end, BigDecimal rate, BigDecimal weekendRate) {
        BigDecimal total = BigDecimal.ZERO;
        while (start.isBefore(end) || start.isEqual(end)){
            DayOfWeek day = start.getDayOfWeek();
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.FRIDAY){
                total = total.add(weekendRate);
            }
            else{
                total = total.add(rate);
            }
            start = start.plusDays(1);
        }
        return total;
    }

    private void reservationByHost() throws DataException {
        Host host = view.findHost(hs.findAll());
        if (host == null) {
            return;
        }
        List<Guest> guests = gs.findAll();
        List<Reservation> all = rs.findByHost(host);
        if (all.size() == 0){
            view.println("They have no reservations currently");
            return;
        }
        view.displayReservations(all, host, guests);
    }
}
