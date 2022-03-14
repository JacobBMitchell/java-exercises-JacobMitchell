package learn.foraging.data;

import learn.foraging.models.Forager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForagerFileRepository implements ForagerRepository {

    private final String filePath;

    public ForagerFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Forager> findAll() {
        ArrayList<Forager> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine(); // read header

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                String[] fields = line.split(",", -1);
                if (fields.length == 4) {
                    result.add(deserialize(fields));
                }
            }
        } catch (IOException ex) {
            // don't throw on read
        }
        return result;
    }

    @Override
    public Forager findById(String id) {
        return findAll().stream()
                .filter(i -> i.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Forager> findByState(String stateAbbr) {
        return findAll().stream()
                .filter(i -> i.getState().equalsIgnoreCase(stateAbbr))
                .collect(Collectors.toList());
    }

    @Override
    public Forager addForager(Forager forager) throws DataException {
        List<Forager> foragers = findAll();
        forager.setId(java.util.UUID.randomUUID().toString());
        foragers.add(forager);
        try (PrintWriter writer = new PrintWriter(filePath)){
            writer.println("id,first_name,last_name,state");
            for (Forager foragerI: foragers){
                writer.println(serialize(foragerI));
            }
            writer.close();
            return forager;
        } catch (IOException ex) {
//            return forager;
            throw new DataException("Could not add Forager",ex);

        }
    }

    private String serialize(Forager forager){
        String result = "";
        result = forager.getId() +","+forager.getFirstName()+","
                +forager.getLastName()+","+forager.getState();
        return result;
    }
    
    private Forager deserialize(String[] fields) {
        Forager result = new Forager();
        result.setId(fields[0]);
        result.setFirstName(fields[1]);
        result.setLastName(fields[2]);
        result.setState(fields[3]);
        return result;
    }
}
