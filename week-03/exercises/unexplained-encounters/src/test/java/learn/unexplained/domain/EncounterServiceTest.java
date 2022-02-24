package learn.unexplained.domain;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.data.EncounterRepositoryDouble;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterServiceTest {

    EncounterService service = new EncounterService(new EncounterRepositoryDouble());

    @Test
    void shouldFindAll() throws DataAccessException {
        Encounter enc = new Encounter(2, EncounterType.CREATURE, "1/1/2015", "test description", 1);
        List<Encounter> encs= new ArrayList<>();
        encs.add(enc);
        assertEquals(encs,service.findAll());
    }

    @Test
    void shouldNotAddNull() throws DataAccessException {
        EncounterResult expected = makeResult("encounter cannot be null");
        EncounterResult actual = service.add(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddEmptyWhen() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, " ", "test desc", 1);
        EncounterResult expected = makeResult("when is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }


    @Test
    void shouldNotAddEmptyDescription() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "  ", 1);
        EncounterResult expected = makeResult("description is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddNullDescription() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", null, 1);
        EncounterResult expected = makeResult("description is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddZeroOccurrences() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "test description", 0);
        EncounterResult expected = makeResult("occurrences must be greater than 0");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddDuplicate() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "1/1/2015", "test description", 1);
        EncounterResult expected = makeResult("duplicate encounter is not allowed");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "test description", 1);
        EncounterResult expected = new EncounterResult();
        expected.setPayload(encounter);

        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    private EncounterResult makeResult(String message) {
        EncounterResult result = new EncounterResult();
        result.addErrorMessage(message);
        return result;
    }

    @Test
    void findByType() throws DataAccessException{
        List<Encounter> ufoSightings = service.findByType(EncounterType.CREATURE);
        assertEquals(1,ufoSightings.size());
        List<Encounter> nullSightings = service.findByType(null);
        assertEquals(0,nullSightings.size());
    }

    @Test
    void deleteById() throws DataAccessException {
        EncounterResult result = service.deleteById(3);
        assertFalse(result.isSuccess());
        EncounterResult result1 = service.deleteById(2);
        assertTrue(result1.isSuccess());
    }

    @Test
    void update() throws DataAccessException {
        Encounter enc = new Encounter(2,EncounterType.CREATURE,"Today","OMG IT WAS SO SCARY",2);
        EncounterResult result = service.update(enc);
        assertTrue(result.isSuccess());

        Encounter enc2 = new Encounter(3,EncounterType.CREATURE,"Today","OMG IT WAS SO SCARY",2);
        EncounterResult result1 = service.update(enc2);
        assertFalse(result1.isSuccess());
        assertEquals("Encounter not found.",result1.getMessages().get(0));

        Encounter enc3 = new Encounter(2, EncounterType.CREATURE, "1/1/2015", "test description", 1);
        EncounterResult result2 = service.update(enc3);
        assertFalse(result2.isSuccess());
        assertEquals("This encounter has already been created",result2.getMessages().get(0));

    }
}