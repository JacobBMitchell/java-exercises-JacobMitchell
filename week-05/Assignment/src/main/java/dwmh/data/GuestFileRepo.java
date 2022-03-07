package dwmh.data;

import dwmh.models.Guest;

import java.io.*;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GuestFileRepo implements GuestRepository{
    String fileName; // ./dont-wreck-my-house-data/guests.csv

    public GuestFileRepo(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Guest> findAll() throws DataException{
        List<Guest> guests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // reads header ie skip top line

            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] terms = line.split(",");
                guests.add(decode(terms));
            }

        } catch (IOException e) {
            //e.printStackTrace();
        }
        return guests;
    }

    private Guest decode(String[] terms) {
        Guest guest = new Guest();
        guest.setId(Integer.parseInt(terms[0]));
        guest.setFirstName(terms[1]);
        guest.setLastName(terms[2]);
        guest.setEmail(terms[3]);
        guest.setPhone(terms[4]);
        guest.setState(terms[5]);

        return guest;
    }

    @Override
    public Guest add(Guest guest) throws DataException {
        List<Guest> all = findAll();
        guest.setId(nextInt(all));
        //write it?
        all.add(guest);
        writeToFile(all);

        return guest;
    }

    private String encode(Guest g) {
        String result = "";
        result = g.getId() + "," +
                g.getFirstName() + "," +
                g.getLastName() + "," +
                g.getEmail() + "," +
                g.getPhone() + "," +
                g.getState();

        return result;
    }

    private int nextInt(List<Guest> all) {
        Guest max = all.stream()
                .max(Comparator.comparingInt(Guest::getId)).orElse(new Guest());
        return max.getId()+1;
    }

    @Override
    public boolean updateById(int id, Guest guest) throws DataException {
        boolean deleted = deleteById(id);
        if (deleted){
            add(guest);
        }
        return deleted;
    }

    @Override
    public boolean deleteById(int id) throws DataException{
        List<Guest> all = findAll();
        List<Guest> collect = all.stream().filter(a -> a.getId() != id).toList();
        writeToFile(collect);
        return all.size()-1 == collect.size() ;
    }

    private void writeToFile(List<Guest> collect) {
        try (PrintWriter writer = new PrintWriter(fileName)){
            writer.println("guest_id,first_name,last_name,email,phone,state");
            for (Guest g : collect){
                writer.println(encode(g));
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
