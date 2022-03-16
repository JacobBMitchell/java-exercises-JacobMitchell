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
    ReservationFileRepo repo = new ReservationFileRepo("./test_data/reservations");

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
        List<Reservation> resos = repo.findByHost(host1.getId());
        //check something else
        assertEquals(new BigDecimal("2125"),resos.get(6).getTotal());
        //assertEquals(host1.getLastName(),resos.get(3).getHost().getLastName());

        Host host2 = hosts.findAll().get(5);
        List<Reservation> resos2 = repo.findByHost(host2.getId());
        assertEquals(0,resos2.size());

    }

    @Test
    void add() throws DataException {
        Host host = hosts.findAll().get(7); // 2e72f86c
        List<Reservation> resos = repo.findByHost(host.getId());
        LocalDate start = LocalDate.of(2022,5,12);
        Reservation reso1 = new Reservation(host.getId(), start
                , LocalDate.of(2022, 5, 15),4,new BigDecimal("300"));
        Reservation r = repo.add(reso1);
        assertEquals(r.getEnd(), repo.findByHost(host.getId()).get(13).getEnd());

    }

    @Test
    void deleteById() throws DataException {
        Host host1 = hosts.findAll().get(0);
        assertTrue(repo.deleteById(4,host1));
        assertEquals(5,repo.findByHost(host1.getId()).get(3).getId());
    }

    @Test
    void updateById() throws DataException { //7,2021-05-02,2021-05-08,699,2125
        Host host = hosts.findAll().get(0);
        Reservation r = new Reservation(host.getId(),LocalDate.of(2020,2,2), LocalDate.of(2020,3,3),12,new BigDecimal(30));
        assertTrue(repo.updateById(7,host,r));
        assertEquals(repo.findByHost(host.getId()).get(repo.findByHost(host.getId()).size()-1).getTotal(),new BigDecimal(30));
    }
}