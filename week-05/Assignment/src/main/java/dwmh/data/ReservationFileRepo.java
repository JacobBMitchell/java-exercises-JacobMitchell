package dwmh.data;

import dwmh.models.Host;
import dwmh.models.Reservation;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ReservationFileRepo implements ReservationRepository{
    private final String directory;
    private final HostRepository repo;

    public ReservationFileRepo(String directory, HostRepository hr) {
        this.directory = directory;
        this.repo = hr;
    }

    @Override
    public List<Reservation> findByHost(Host host) throws DataException {
        List<Reservation> all = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath(host.getId())))) {

            reader.readLine(); // read header

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                String[] fields = line.split(",");

                all.add(decode(fields, host.getId()));

            }
        } catch (IOException ex) {
            // don't throw on read
        }
        return all;
        //for each file in a file path
        //make a reservation where you get the file name -.csv
        //Introduce the fields from file
        //per reservation and append them to a list
    }

    private Reservation decode(String[] fields, String id) throws DataException {
        Reservation res = new Reservation();
        res.setHostId(id);
        res.setId(Integer.parseInt(fields[0]));
        res.setStart(LocalDate.parse(fields[1]));
        res.setEnd(LocalDate.parse(fields[2]));
        res.setGuestId(Integer.parseInt(fields[3]));
        res.setTotal(new BigDecimal(fields[4]));
        res.setHost(repo.findAll().stream().filter(a -> Objects.equals(a.getId(), id)).toList().get(0));
        return res;
    }

    private String getFilePath(String id) {
        return Paths.get(directory,id+".csv").toString();
    }

    @Override
    public Reservation add(Reservation res) throws DataException {
        List<Reservation> all = findByHost(res.getHost());
        int nextId;
        if (all.stream().max(Comparator.comparingInt(Reservation::getId)).isPresent()){
            nextId = all.stream().max(Comparator.comparingInt(Reservation::getId)).get().getId() +1;
        } else{
            nextId =1;
        }
        res.setId(nextId);
        all.add(res);
        writeAll(all,res.getHostId());
        return res;
    }

    private void writeAll(List<Reservation> all, String hostId) throws DataException {
        try (PrintWriter writer = new PrintWriter(getFilePath(hostId))) {

            writer.println("id,start_date,end_date,guest_id,total");

            for (Reservation res : all) {
                writer.println(encode(res));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String encode(Reservation res) {
        String line = "";
        line = res.getId() + "," +
                res.getStart() + "," +
                res.getEnd() + "," +
                res.getGuestId() + "," +
                res.getTotal();
        return line;
    }

        @Override
    public boolean deleteById(int id, Host host) throws DataException {
        List<Reservation> reservations = findByHost(host);
        Reservation reservation = reservations.stream().filter(a -> a.getId() == id).toList().get(0);
        reservations.remove(reservation);
        writeAll(reservations,host.getId());
        return findByHost(host).size() == reservations.size();
    }

    @Override
    public boolean updateById(int id, Host host) throws DataException {
        return false;
    }
}


