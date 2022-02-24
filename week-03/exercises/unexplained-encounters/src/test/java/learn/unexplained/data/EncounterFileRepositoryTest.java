package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {

    static final String TEST_PATH = "./unexplained-encounters/data/encounters-test.csv";
    final Encounter[] testEncounters = new Encounter[]{
            new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 1),
            new Encounter(2, EncounterType.CREATURE, "2020-02-01", "short test #2", 1),
            new Encounter(3, EncounterType.SOUND, "2020-03-01", "short test #3", 1)
    };

    EncounterRepository repository = new EncounterFileRepository(TEST_PATH);//

    @BeforeEach
    void setup() throws DataAccessException {
        for (Encounter e : repository.findAll()) {
            repository.deleteById(e.getEncounterId());
        }

        for (Encounter e : testEncounters) { //rebuilds document from testEncounters above
            repository.add(e);
        }
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<Encounter> encounters = repository.findAll();
        Encounter[] actual = encounters.toArray(new Encounter[encounters.size()]);
        assertArrayEquals(testEncounters, actual);
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter();
        encounter.setType(EncounterType.UFO);
        encounter.setWhen("Jan 15, 2005");
        encounter.setDescription("moving pinpoint of light." +
                "seemed to move with me along the highway. " +
                "then suddenly reversed direction without slowing down. it just reversed.");
        encounter.setOccurrences(1);

        Encounter actual = repository.add(encounter);

        assertNotNull(actual);
        assertEquals(4, actual.getEncounterId());
    }

    @Test
    void shouldDeleteById() throws DataAccessException {
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(4));
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void shouldFindByType() throws DataAccessException {
        assertEquals(EncounterType.UFO, repository.findByType(EncounterType.UFO).get(0).getType());
        assertNotEquals(EncounterType.UFO,repository.findByType(EncounterType.CREATURE).get(0).getType());
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        List<Encounter> all = repository.findAll();
        Encounter myEncounter = all.get(1);
        myEncounter.setOccurrences(2);
//        myEncounter.setDescription("It was so spooky I saw a ghost! ");
//        myEncounter.setType(EncounterType.VISION);
//        myEncounter.setWhen("3 minutes ago! ");
//        myEncounter.setOccurrences(2);
        assertTrue(repository.update(myEncounter));
    }
}