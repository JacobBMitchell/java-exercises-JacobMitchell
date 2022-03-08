package dwmh.data;

import dwmh.models.Host;
import dwmh.models.Location;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HostFileRepo implements HostRepository{
    private final String fileName; // ./dont-wreck-my-house-data-/hosts.csv

    public HostFileRepo(String fileName){
        this.fileName = fileName;
    }

    @Override
    public List<Host> findAll() throws DataException {
        List<Host> hosts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // reads header ie skip top line

            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] terms = line.split(",");
                hosts.add(decode(terms));
            }

        } catch (IOException e) {
            //e.printStackTrace();
        }

        return hosts;
    }

    private Host decode(String[] terms) { //java.util.UUID.randomUUID().toString()
        Host host = new Host();
        Location loco = new Location();
        host.setId(terms[0]);
        host.setLastName(terms[1]);
        host.setEmail(terms[2]);
        host.setPhone(terms[3]);
        loco.setAddress(terms[4]);
        loco.setCity(terms[5]);
        loco.setState(terms[6]);
        loco.setZipCode(Integer.parseInt(terms[7]));
        loco.setRate(new BigDecimal(terms[8]));
        loco.setWeekendRate(new BigDecimal(terms[9]));

        host.setLocation(loco);
        return host;
    }

    //id,last_name,email,phone,address,city,state,postal_code,standard_rate,weekend_rate
    @Override
    public Host add(Host host) throws DataException {
        List<Host> all = findAll();
        if(host.getId() == null || host.getId().isBlank() ) {
            host.setId(java.util.UUID.randomUUID().toString());
        }
        all.add(host);
        writeToFile(all);

        return host;
    }

    private void writeToFile(List<Host> collect) {
        try (PrintWriter writer = new PrintWriter(fileName)){
            writer.println("id,last_name,email,phone,address,city,state,postal_code,standard_rate,weekend_rate");
            for (Host h : collect){
                writer.println(encode(h));
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String encode(Host h) {
        String result = "";
        Location l = h.getLocation();
        result = h.getId() + "," +
                h.getLastName() + "," +
                h.getEmail() + "," +
                h.getPhone() + "," +
                l.getAddress() + "," +
                l.getCity() + "," +
                l.getState() + "," +
                l.getZipCode() + "," +
                l.getRate() + "," +
                l.getWeekendRate();
        return  result;
    }

    @Override
    public boolean updateById(String Id, Host host) throws DataException {
        host.setId(Id);
        boolean deleted = deleteById(Id);
        if (deleted){
            add(host);
        }
        return deleted;
    }

    @Override
    public boolean deleteById(String id) throws DataException {
        List<Host> all = findAll();
        List<Host> collect = all.stream().filter(a -> !a.getId().equals(id)).toList();
        writeToFile(collect);
        return all.size()-1 == collect.size();
    }
}
