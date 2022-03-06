package learn.foraging.data;

import learn.foraging.models.Forager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class ForagerFileRepositoryTest {

    private static final String SEED_FILE_PATH = "./data/foragers-reset.csv";
    private static final String Test_FILE_PATH = "./data/foragers.csv";
    ForagerFileRepository repo = new ForagerFileRepository("./data/foragers.csv");


    @AfterEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(Test_FILE_PATH);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindAll() {
        List<Forager> all = repo.findAll();
        assertEquals(1000, all.size());
        assertEquals("0e4707f4-407e-4ec9-9665-baca0aabe88c",all.get(0).getId());
        assertNotEquals("0e4707f4-407e-4ec9-9665-baca0aabe88c",all.get(1).getId());
    }

    @Test
    void shouldAdd() throws DataException {
        //List<Forager> all = repo.findAll();
        Forager forager1 = new Forager();
        forager1.setFirstName("Jacob");
        forager1.setLastName("Mitchell");
        forager1.setState("TN");
        repo.addForager(forager1);
        assertEquals(1001,repo.findAll().size());
    }
}