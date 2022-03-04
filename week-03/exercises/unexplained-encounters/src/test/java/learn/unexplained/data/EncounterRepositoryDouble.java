package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.ArrayList;
import java.util.List;

public class EncounterRepositoryDouble implements EncounterRepository {


    @Override
    public List<Encounter> findAll() throws DataAccessException {
        return List.of(new Encounter(2, EncounterType.CREATURE, "1/1/2015", "test description", 1));
    }

    @Override
    public Encounter add(Encounter encounter) throws DataAccessException {
        return encounter;
    }

    @Override
    public boolean deleteById(int encounterId) throws DataAccessException {
        List<Encounter> encs = new ArrayList<>(findAll()); // was removing as it was looking needed new one to loop through
        for (Encounter enc: encs){
            if (encounterId == enc.getEncounterId()){
                encs.remove(enc);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Encounter enc) throws DataAccessException {
        List<Encounter> all = new ArrayList<>(findAll());
        for (Encounter each: all){
            if (each.getEncounterId() == enc.getEncounterId()){
                all.set(all.indexOf(each),enc);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Encounter> findByType(EncounterType encounterType) throws DataAccessException {
        return List.of(new Encounter(2, EncounterType.CREATURE, "1/1/2015", "test description", 1));
    }
}
