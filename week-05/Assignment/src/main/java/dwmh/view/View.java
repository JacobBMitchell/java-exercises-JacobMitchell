package dwmh.view;

import dwmh.models.Guest;
import dwmh.models.Host;
import dwmh.models.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class View {
    private final Scanner scn = new Scanner(System.in);

    public void println(String msg){
        System.out.println(msg);
    }

    public void header(String msg) {
        println(msg);
        for (int i = 0; i <msg.length(); i ++){
            print("=");
        }
        println("");
    }

    public void print(String msg) {
        System.out.print(msg);
    }

    public void mainMenu(MenuOption[] values) {
        for (MenuOption option: values){
            println(option.getMessage());
        }
    }

    public int getInt(String msg, int lower, int upper) {
        int number = getInt(msg);
        //int number = Integer.parseInt(scn.nextLine());
        if (number > upper || number <lower){
            println("Number is out of range " + lower +", " + upper + ".");
            number = getInt(msg,lower,upper);
        }

        return number;
    }

    private int getInt(String msg) {
        int number;
        try {
            number = Integer.parseInt(getString(msg));
        }catch (NumberFormatException e){
            println("Not a number");
            number = getInt(msg);
        }
        return number;
    }

    private String getString(String msg) {
        print(msg);
        String choice = scn.nextLine();
        if (choice == null  || choice.isEmpty()){
            println("Please input field");
            choice = getString(msg);
        }
        return choice;
    }

    public Host findHost(List<Host> all) {
        Host host = new Host();
        header("Select Host");
        String lastName = getString("What is the last name? (starts with?) ");
        List<Host> hosts = all.stream().filter(a -> a.getLastName().startsWith(lastName)).toList();
        if (hosts.isEmpty()){
            println("There is no one by that name");
            if (getBoolean("Try a new last name?[y/n] ")){
                host = findHost(all);
            }
            else{
                return null;
            }
            if (host == null){
                return null;
            }
        }
        for (int i = 1;i <= hosts.size(); i ++){
            Host h = hosts.get(i-1);
            println(i + ". " +h.getLastName() + " "
            + h.getEmail() +" "+ h.getPhone());
        }
        if (host.getLastName() == null) {
            int choice = getInt("Choose Host above: ", 1, hosts.size()) -1;
            host = hosts.get(choice);
        }
        return host;
    }

    public boolean getBoolean(String msg) {
        return getString(msg).equalsIgnoreCase("y");
    }

    public void displayReservations(List<Reservation> all, Host host, List<Guest> guests) {
        header("Reservations for "+ host.getLastName());
        all = all.stream().sorted(Comparator.comparing(Reservation::getStart)).toList(); //sorted by start date
        for (Reservation r: all){
            Guest guest = guests.stream().filter(a -> a.getId() == r.getGuestId()).toList().get(0);
            println("Guest: "+ guest.getFirstName() +" "+ guest.getLastName() +
                    ", Start date: " + r.getStart().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) +
                    ", End date: " + r.getEnd().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) +
                    ", Total: $" + r.getTotal());
        }
    }

    public Reservation getReservation(List<Host> hosts, List<Guest> guests) {
        Reservation reserve = new Reservation();//hostId,start, end,guestId,Total

        Host host = findHost(hosts);
        if (host == null) {
            return null;
        }
        reserve.setHostId(host.getId());

        Guest guest = getGuest(guests);
        if (guest == null) {
            return null;
        }
        reserve.setGuestId(guest.getId());

        //display all reservations for host
        return reserve;
    }
    public Reservation getTimes(Reservation reserve){
        LocalDate start;
        LocalDate end;

        while (true) {
            start = getTime("When do you start?(mm-dd-yyyy) ");
            end = getTime("When do you leave?(mm-dd-yyyy) ");
            if (start.isBefore(end)){
                break;
            }
            println("Start must be before end");
        }
        reserve.setStart(start);
        reserve.setEnd(end);

        return reserve;
    }

    private LocalDate getTime(String msg) {
        String input = getString(msg);
        LocalDate time;
        try {
            time = LocalDate.parse(input, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        }catch (DateTimeParseException e){
            println("Not a valid time input");
            time = getTime(msg);
        }
        return time;
    }

    private Guest getGuest(List<Guest> guests) {
        Guest guest = new Guest();
        header("Select Guest");
        String lastName = getString("What is the last name? (starts with?) ");
        List<Guest> all = guests.stream().filter(a -> a.getLastName().startsWith(lastName)).toList();
        if (all.isEmpty()){
            println("There is no one by that name");
            if (getBoolean("Try a new last name?[y/n]: ")){
                guest = getGuest(guests);
            }
            else{
                return null;
            }
            if (guest == null){
                return null;
            }
        }
        for (int i = 1;i <= all.size(); i ++){
            Guest g = all.get(i-1);
            println(i + ". " +g.getLastName() + " "
                    + g.getEmail() +" "+ g.getPhone());
        }
        if (guest.getLastName() == null) {
            int choice = getInt("Choose guest above: ", 1, all.size()) -1;
            guest = all.get(choice);
        }
        return guest;

    }

    public void displayErrors(List<String> errors) {
        header("Problems to fix");
        errors.forEach(System.out::println);
    }

    public int chooseReservation(List<Reservation> all, Host host, List<Guest> guests, String action) {
        int i =1;


        all = all.stream().filter(a -> a.getStart().isAfter(LocalDate.now()) || a.getStart().isEqual(LocalDate.now()))
                .toList();

        if (all.isEmpty()){
            println("They have no future reservations to "+ action);
            return -1;
        }
        for (Reservation r: all){
            Guest guest = guests.stream().filter(a -> a.getId() == r.getGuestId()).toList().get(0);
            print(i + ". " + guest.getFirstName() +" " + guest.getLastName() + " start: "+ r.getStart().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) + " end: " + r.getEnd().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
            println(" total: $"+ r.getTotal());
            i++;
        }
        int choice = getInt("Choose reservation above to "+ action+": ",1,all.size())-1;
        return all.get(choice).getId();
    }

    public Reservation getTimesDefault(Reservation reservation) {
        LocalDate start;
        LocalDate end;

        while (true) {
            start = getTime("When do you start?(mm-dd-yyyy)(" + reservation.getStart().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) +")");
            end = getTime("When do you leave?(mm-dd-yyyy) (" + reservation.getEnd().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) +")");
            if (start.isBefore(end)){
                break;
            }
            println("Start must be before end");
        }
        reservation.setStart(start);
        reservation.setEnd(end);

        return reservation;
    }
}
