package dwmh.data;

import dwmh.models.Guest;
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

class HostFileRepoTest {
    String Test_Path = "./test_data/hosts/test.csv";
    String Seed_Path = "./test_data/hosts/seed.csv";
    HostFileRepo repo = new HostFileRepo(Test_Path);

    @BeforeEach
    void setUp() throws IOException {
        Path seedPath = Paths.get(Seed_Path);
        Path testPath = Paths.get(Test_Path);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataException {
        List<Host> all = repo.findAll();
        assertEquals("3edda6bc-ab95-49a8-8962-d50b53f84b15",all.get(0).getId());
        assertEquals(11, all.size());
        assertNotEquals("3edda6bc-ab95-49a8-8962-d50b53f84b15", all.get(5).getId());
        assertEquals(new BigDecimal("159"), all.get(6).getLocation().getRate());
    }

    @Test
    void add() throws DataException {
        Location l = new Location("161 Center Pointe","Clarksville", "TN", 37040,new BigDecimal("300"),new BigDecimal("500"));
        Host h = new Host("Mitchell","J-Mitchell@Dev-10.com","(931) 6240117",l);
        Host hadded = repo.add(h);
        assertEquals(h,hadded);
        List <Host> all = repo.findAll();
        assertEquals(12,all.size());
        assertEquals("Mitchell",all.get(11).getLastName());
    }

    @Test
    void updateById() throws DataException { //a0d911e7-4fde-4e4a-bdb7-f047f15615e8,Rhodes,krhodes1@posterous.com,(478) 7475991,7262 Morning Avenue,Macon,GA,31296,295,368.75

        Host oldH = repo.findAll().get(2);
        Location l = new Location("161 Center Pointe","Clarksville", "TN", 37040,new BigDecimal("300"),new BigDecimal("500"));
        Host h = new Host("Mitchell","J-Mitchell@Dev-10.com","(931) 6240117",l);
        assertTrue(repo.updateById(oldH.getId(),h));
        assertEquals(11,repo.findAll().size());
        assertFalse(repo.findAll().contains(oldH));
    }

    @Test
    void deleteById() throws DataException {
        List<Host> all = repo.findAll();
        assertTrue(repo.deleteById("d63304e3-de36-4ecc-8f8f-847431ffff64"));
        assertFalse(repo.findAll().contains(all.get(8)));

        //assertEquals(3,all.get(2).getId());
        //assertTrue(repo.deleteById(all.get(3).getId()));
        //all = repo.findAll();
        //assertNotEquals(3,all.get(2).getId());
    }
}