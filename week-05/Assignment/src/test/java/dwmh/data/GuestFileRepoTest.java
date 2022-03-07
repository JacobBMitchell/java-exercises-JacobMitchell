package dwmh.data;

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

class GuestFileRepoTest {
    String Test_Path = "./test_data/guests/test.csv";
    String Seed_Path = "./test_data/guests/seed.csv";
    GuestFileRepo repo = new GuestFileRepo(Test_Path);

    @BeforeEach
    void setUp() throws IOException {
        Path seedPath = Paths.get(Seed_Path);
        Path testPath = Paths.get(Test_Path);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataException {
        List<Guest> all = repo.findAll();
        assertEquals(1, all.get(0).getId());
        assertEquals(12 , all.size());
        assertNotEquals(1, all.get(5).getId());
        assertEquals("jhulson8@auda.org.au",all.get(8).getEmail());
    }

    @Test
    void add() throws DataException {

        Guest guest1 = new Guest("Jacob","Mitchell","JMitchell@Dev-10.com","(931) 6240117","TN");
        Guest gueste = repo.add(guest1);
        List<Guest> all = repo.findAll();
        assertEquals(guest1,gueste);
        assertEquals(13,all.get(12).getId());
        assertEquals("Jacob",all.get(12).getFirstName());
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteById() {
    }
}