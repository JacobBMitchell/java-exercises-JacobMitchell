package dwmh.data;

import dwmh.models.Host;
import dwmh.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationFileRepoTest {
    String Test_Path = "./test_data/hosts/test.csv";
    String Seed_Path = "./test_data/hosts/seed.csv";
    HostFileRepo hosts = new HostFileRepo(Test_Path);
    ReservationFileRepo repo = new ReservationFileRepo("./test_data/reservations",hosts);

    @BeforeEach
    void setUp() throws IOException {
        Path seedPath = Paths.get(Seed_Path);
        Path testPath = Paths.get(Test_Path);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);

        Path seedRepo1 = Paths.get("./test_data/reservations/2e72f86c-b8fe-4265-b4f1-304dea8762db-seed.csv");
        Path testRepo1 = Paths.get("./test_data/reservations/2e72f86c-b8fe-4265-b4f1-304dea8762db.csv");

        Files.copy(seedRepo1, testRepo1, StandardCopyOption.REPLACE_EXISTING);

        Path seedRepo2 = Paths.get("./test_data/reservations/3edda6bc-ab95-49a8-8962-d50b53f84b15-seed.csv");
        Path testRepo2 = Paths.get("./test_data/reservations/3edda6bc-ab95-49a8-8962-d50b53f84b15.csv");

        Files.copy(seedRepo2, testRepo2, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findByHost() throws DataException {
        Host host1 = hosts.findAll().get(0);//3edda6bc
        List<Reservation> resos = repo.findByHost(host1);
        assertEquals(host1.getLastName(),resos.get(3).getHost().getLastName());
    }

    @Test
    void add() throws DataException {
        Host host = hosts.findAll().get(7); // 2e72f86c
        List<Reservation> resos = repo.findByHost(host);
        LocalDate start = LocalDate.of(2022,5,12);
        Reservation reso1 = new Reservation(host.getId(), start
                , LocalDate.of(2022, 5, 15),4,new BigDecimal("300"));
        reso1.setHost(host);
        Reservation r = repo.add(reso1);
        assertEquals(r.getEnd(), repo.findByHost(host).get(12).getEnd());

    }

    @Test
    void deleteById() throws DataException {
        Host host1 = hosts.findAll().get(0);
        assertTrue(repo.deleteById(4,host1));
        assertEquals(5,repo.findByHost(host1).get(3).getId());
    }

    @Test
    void updateById() {
    }
}