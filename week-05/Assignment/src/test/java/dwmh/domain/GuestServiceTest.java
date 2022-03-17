package dwmh.domain;

import dwmh.data.DataException;
import dwmh.data.GuestFileRepo;
import dwmh.data.GuestRepository;
import dwmh.models.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestServiceTest {
    String Test_Path = "./test_data/guests/test.csv";
    String Seed_Path = "./test_data/guests/seed.csv";
    GuestRepository repo = new GuestFileRepo(Test_Path);
    GuestService service = new GuestService(repo);


    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(Seed_Path);
        Path testPath = Paths.get(Test_Path);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataException {
        List<Guest> all = service.findAll();
        assertEquals("Olympie",all.get(1).getFirstName());
    }

    @Test
    void shouldAddCorrect() throws DataException {
        Guest guest = new Guest("Jacob","Mitchell","JMitchell","(931) 6240117","TN");
        Result<Guest> result = service.add(guest);
        assertTrue(result.isSuccess());
        assertEquals("Jacob",service.findAll().get(12).getFirstName());
    }

    @Test
    void shouldNotAddNull() throws DataException {
        Guest guest = null;
        Result<Guest> result = service.add(guest);
        assertFalse(result.isSuccess());
        assertEquals("Cannot have null guest",result.getErrors().get(0));
    }

    @Test
    void shouldNotAddNoLastName() throws DataException {
        Guest guest = new Guest();
        guest.setFirstName("Jacob");
        //guest.setLastName("Mitchell");
        guest.setState("TN");
        guest.setEmail("JMitchell");
        guest.setPhone("(931) 6240117");
        Result<Guest> result = service.add(guest);
        assertFalse(result.isSuccess());
        assertEquals("Need a last name",result.getErrors().get(0));

    }

    @Test
    void shouldNotAddNoFirstName() throws DataException {
        Guest guest = new Guest();
        //guest.setFirstName("Jacob");
        guest.setLastName("Mitchell");
        guest.setState("TN");
        guest.setEmail("JMitchell");
        guest.setPhone("(931) 6240117");
        Result<Guest> result = service.add(guest);
        assertFalse(result.isSuccess());
        assertEquals("Need a first name",result.getErrors().get(0));
    }
    @Test
    void shouldNotAddNoStateAndEmail() throws DataException {
        Guest guest = new Guest();
        guest.setFirstName("Jacob");
        guest.setLastName("Mitchell");
        //guest.setState("TN");
        //guest.setEmail("JMitchell");
        guest.setPhone("(931) 6240117");
        Result<Guest> result = service.add(guest);
        assertFalse(result.isSuccess());
        assertEquals("Need a state",result.getErrors().get(1));
        assertEquals("Need a email",result.getErrors().get(0));
    }

    @Test
    void shouldNotAddNoPhone() throws DataException {
        Guest guest = new Guest();
        guest.setFirstName("Jacob");
        guest.setLastName("Mitchell");
        guest.setState("TN");
        guest.setEmail("JMitchell");
        //guest.setPhone("(931) 6240117");
        Result<Guest> result = service.add(guest);
        assertFalse(result.isSuccess());
        assertEquals("Need a phone number",result.getErrors().get(0));
    }
    @Test
    void shouldNotAddNonTwoLetterState() throws DataException {
        Guest guest = new Guest();
        guest.setFirstName("Jacob");
        guest.setLastName("Mitchell");
        guest.setState("TNe");
        guest.setEmail("JMitchell");
        guest.setPhone("(931) 6240117");
        Result<Guest> result = service.add(guest);
        assertFalse(result.isSuccess());
        assertEquals("Needs to be 2 letter representation of state",result.getErrors().get(0));
    }
    @Test
    void shouldNotDuplicate() throws DataException {
        Guest guest = new Guest();
        guest.setFirstName("Jacob");
        guest.setLastName("Mitchell");
        guest.setState("TN");
        guest.setEmail("JMitchell");
        guest.setPhone("(931) 6240117");
        Result<Guest> result = service.add(guest);
        assertTrue(result.isSuccess());
        Result<Guest> result1 = service.add(guest);
        assertEquals("Guest already exists",result1.getErrors().get(0));
    }
    @Test
    void updateById() throws DataException {
        Guest guest = new Guest("Jacob","Mitchell","JMitchell","(931) 6240117","TN");
        Result<Guest> result = service.updateById(7,guest);
        assertTrue(result.isSuccess());
        assertNotEquals("Gilli",service.findAll().get(6).getFirstName());
        assertEquals("Jacob",service.findAll().get(11).getFirstName());
        assertFalse(service.findAll().stream().anyMatch(a ->a.getFirstName().equalsIgnoreCase("Gilli")));
    }

    @Test
    void shouldNotUpdateToNullGuest() throws DataException{
        Result<Guest> result = service.updateById(0,null);
        assertFalse(result.isSuccess());
        assertEquals("Gilli",service.findAll().get(6).getFirstName());
        assertEquals("Cannot have null guest",result.getErrors().get(0));
    }

    @Test
    void shouldBeNonDuplicateGuestToUpdate() throws DataException{
        //11,Devina,Pepon,dpepona@europa.eu,(239) 9752596,FL
        Guest guest = new Guest("Devina","Pepon","dpepona@europa.eu","(239) 9752596","FL");
        Result<Guest> result = service.updateById(3,guest);
        assertFalse(result.isSuccess());
        assertEquals("Guest exists under different Id",result.getErrors().get(0));

        Result<Guest> result2= service.updateById(11,guest);
        assertFalse(result2.isSuccess());
        assertEquals("Guest already exists",result2.getErrors().get(0));
    }

    @Test
    void shouldBeValidId() throws DataException{
        Guest guest = new Guest("Devina","Pepon","dpepona@europa.eu","(239) 9752596","FL");
        Result<Guest> result = service.updateById(33,guest);
        assertFalse(result.isSuccess());
        assertEquals("There is no ID to match or guest does not exist",result.getErrors().get(0));

    }

    @Test
    void deleteById() throws DataException {
        Result<Integer> r = service.deleteById(3);
        assertTrue(r.isSuccess());
        assertEquals(11, service.findAll().size());
        assertEquals(3,r.getPayload());
    }

    @Test
    void cannotDeleteIdThatDoesntExist() throws DataException {
        Result<Integer> r = service.deleteById(13);
        assertFalse(r.isSuccess());
        assertEquals(12, service.findAll().size());
    }
}