package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForagerRepositoryDouble;
import learn.foraging.models.Forager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForagerServiceTest {
    ForagerRepositoryDouble repo = new ForagerRepositoryDouble();
    ForagerService service = new ForagerService(repo);

    @Test
    void shouldAddForager() throws DataException {
        Forager forager = new Forager();
        forager.setFirstName("Jacob");
        forager.setLastName("Mitchell");
        forager.setState("TN");
        Result<Forager> result = service.addForager(forager);
        assertEquals(forager, result.getPayload());
    }

    @Test
    void shouldForbidNull() throws DataException{
        Forager forager = null;
        Result<Forager> result = service.addForager(forager);
        assertEquals("Cannot be null",result.getErrorMessages().get(0));
        assertEquals(1, result.getErrorMessages().size());
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAllowBlank() throws DataException{
        Forager forager = new Forager();
        Result<Forager> result = service.addForager(forager);
        assertEquals("Needs First Name.",result.getErrorMessages().get(0));
        assertEquals(3, result.getErrorMessages().size());
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldHaveUniquePeople() throws DataException{
        Forager forager = new Forager();
        forager.setFirstName("Jacob");
        forager.setLastName("Mitchell");
        forager.setState("TN");
        Result<Forager> result = service.addForager(forager);
        Forager forager1 = new Forager();
        forager1.setFirstName("Jacob");
        forager1.setLastName("Mitchell");
        forager1.setState("TN");
        Result<Forager> result1 = service.addForager(forager1);
        assertEquals("That person already exists",result1.getErrorMessages().get(0));
        assertEquals(1, result1.getErrorMessages().size());
        assertFalse(result1.isSuccess());
        assertTrue(result.isSuccess());
    }
}