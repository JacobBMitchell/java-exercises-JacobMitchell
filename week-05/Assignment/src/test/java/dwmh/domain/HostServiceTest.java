package dwmh.domain;

import dwmh.data.*;
import dwmh.models.Host;
import dwmh.models.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HostServiceTest {

    String Test_Path = "./test_data/hosts/test.csv";
    String Seed_Path = "./test_data/hosts/seed.csv";
    HostRepository repo = new HostFileRepo(Test_Path);
    HostService service = new HostService(repo);


    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(Seed_Path);
        Path testPath = Paths.get(Test_Path);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataException {
        List<Host> all = service.findAll();
        assertEquals("Rhodes",all.get(1).getLastName());
        assertEquals(11, all.size());
    }

    @Test
    void shouldAdd() throws DataException {
        Location loc = new Location();
        loc.setState("TN");
        loc.setWeekendRate(new BigDecimal("300"));
        loc.setRate(new BigDecimal("250"));
        loc.setCity("Clarksville");
        loc.setAddress("161 Center Pointe");
        loc.setZipCode(37040);
        Host host = new Host("Mitchell","JMitchell","(931) 6240117", loc);
        Result<Host> result = service.add(host);
        assertTrue(result.isSuccess());
        assertEquals(host.getLastName(),service.findAll().get(11).getLastName());

    }

    @Test
    void shouldNotAddNull() throws DataException{
        Result<Host> result = service.add(null);
        assertFalse(result.isSuccess());
        assertEquals("Cannot have null host",result.getErrors().get(0));
    }

    @Test
    void shouldNotAddNullLocation() throws DataException{
        Host host = new Host("Mitchell","JMitchell","9316240117",null);
        Result<Host> result = service.add(host);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddDuplicateHost() throws DataException{
        Host host = service.findAll().get(2);
        Result<Host> result = service.add(host);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddWithoutBasicInfo() throws DataException{
        Location loc = new Location();
        loc.setState("");
        loc.setWeekendRate(new BigDecimal("300"));
        loc.setRate(new BigDecimal("250"));
        loc.setCity("Clarksville");
        loc.setAddress("161 Center Pointe");
        loc.setZipCode(37040);
        Host host = new Host();
        host.setLocation(loc);
        Result<Host> result = service.add(host);
        assertFalse(result.isSuccess());
        assertEquals(4, result.getErrors().size());
    }

    @Test
    void shouldNotAddWithoutProperLocation() throws DataException{
        Location loc = new Location();
        loc.setState("TNe");
        loc.setWeekendRate(new BigDecimal("-300"));
        loc.setRate(new BigDecimal("-250"));
        loc.setCity("");
        loc.setAddress("");
        loc.setZipCode(137040);
        Host host = new Host("Mitchell","JMitchell","9316240117",loc);
        Result<Host> result = service.add(host);
        assertFalse(result.isSuccess());
        assertEquals(6, result.getErrors().size());
    }

//    @Test
//    void updateById() throws DataException {
//        List<Host> all = service.findAll();
//        Host toUpdate = all.get(4);
//        String id = toUpdate.getId();
//        toUpdate.setEmail("mFader3@amazon.co.jp");
//        Result<Host> result = service.updateById(id,toUpdate);
//        assertTrue(result.isSuccess());
//
//    }
//
//    @Test
//    void shouldNotUpdateNull() throws DataException {
//        Host toUpdate = service.findAll().get(4);
//        Result<Host> result = service.updateById(toUpdate.getId(),null);
//        assertFalse(result.isSuccess());
//        assertEquals(1,result.getErrors().size());
//    }
//
//    @Test
//    void deleteById() {
//    }
}