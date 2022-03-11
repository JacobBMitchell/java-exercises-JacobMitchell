package dwmh.domain;

import dwmh.data.*;
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

class ReservationServiceTest {
    GuestRepository gr = new GuestFileRepo("./test_data/guests/test.csv");
    HostRepository hr = new HostFileRepo("./test_data/hosts/test.csv");
    ReservationRepository rr = new ReservationFileRepo("./test_data/reservations");

    ReservationService service = new ReservationService(gr,hr,rr);

    @BeforeEach
    void setup() throws IOException {

        String Test_Path = "./test_data/hosts/test.csv";
        String Seed_Path = "./test_data/hosts/seed.csv";
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
        List<Reservation> all = service.findByHost("2e72f86c-b8fe-4265-b4f1-304dea8762db");
        assertEquals(new BigDecimal("1300"),all.get(7).getTotal());
    }

    @Test
    void preventBadHost() throws DataException{
        List<Reservation> all = service.findByHost("f");
        assertEquals(0, all.size());

        List<Reservation> all2 = service.findByHost((String) null);
        assertEquals(0, all2.size());

        List<Reservation> all3 = service.findByHost((Host) null);
        assertEquals(0, all3.size());


    }

    @Test
    void testFindByHost() throws DataException {
        Host host = hr.findAll().get(7);
        List<Reservation> all = service.findByHost(host);
        assertEquals(new BigDecimal("1300"),all.get(7).getTotal()); // and there is 0 for 3edd
    }

    @Test
    void addReservation() throws DataException {
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,3,11);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation(host.getId(),start,end,1,new BigDecimal("300"));
        Result<Reservation> result = service.addReservation(r);
        assertTrue(result.isSuccess());
    }

    @Test
    void doNotAddEndBeforeBeginning() throws DataException {
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,3,13);
        LocalDate end = LocalDate.of(2022,3,11);
        Reservation r = new Reservation(host.getId(),start,end,1,new BigDecimal("300"));
        Result<Reservation> result = service.addReservation(r);
        assertFalse(result.isSuccess());


        Reservation r1 = new Reservation(host.getId(),null,null,1,new BigDecimal("300"));
        Result<Reservation> result1 = service.addReservation(r1);
        assertFalse(result1.isSuccess());

    }

    @Test
    void doNotAddNegativeTotal() throws DataException{
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,3,11);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation(host.getId(),start,end,1,new BigDecimal("-300"));
        Result<Reservation> result = service.addReservation(r);
        assertFalse(result.isSuccess());


        LocalDate start1 = LocalDate.of(2022,4,11);
        LocalDate end1 = LocalDate.of(2022,4,13);
        Reservation r1 = new Reservation(host.getId(),start1,end1,1,null);
        Result<Reservation> result1 = service.addReservation(r1);
        assertFalse(result1.isSuccess());
    }

    @Test
    void doNotAddBadHostId() throws DataException{
        LocalDate start = LocalDate.of(2022,3,11);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation("F",start,end,1,new BigDecimal("300"));
        Result<Reservation> result = service.addReservation(r);
        assertFalse(result.isSuccess());
    }

    @Test
    void doNotAddNull() throws DataException {
        Result<Reservation> result = service.addReservation(null);
        assertFalse(result.isSuccess());
    }

    @Test
    void doNotAddNullHostId() throws DataException {
        LocalDate start = LocalDate.of(2022,3,11);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation(null,start,end,1,new BigDecimal("300"));
        Result<Reservation> result = service.addReservation(r);
        assertFalse(result.isSuccess());
    }

    @Test
    void doNotAddBadGuest() throws DataException {
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,3,11);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation(host.getId(),start,end,-5,new BigDecimal("300"));
        Result<Reservation> result = service.addReservation(r);
        assertFalse(result.isSuccess());
    }

    @Test
    void doNotAddTimeBeforeNow() throws DataException {
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,3,9);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation(host.getId(),start,end,1,new BigDecimal("300"));
        Result<Reservation> result = service.addReservation(r);
        assertFalse(result.isSuccess());
    }

    @Test
    void DoNotAddOverlap() throws DataException {
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,3,11);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation(host.getId(),start,end,1,new BigDecimal("300"));
        Result<Reservation> result = service.addReservation(r);
        assertTrue(result.isSuccess());

        LocalDate start1 = LocalDate.of(2022,3,12);
        LocalDate end1 = LocalDate.of(2022,3,14);
        Reservation r1 = new Reservation(host.getId(),start1,end1,2,new BigDecimal("300"));
        Result<Reservation> result1 = service.addReservation(r1);
        assertFalse(result1.isSuccess());
    }

    @Test
    void updateByHostId() throws DataException {
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,3,12);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation(host.getId(),start,end,1,new BigDecimal("300"));
        Result<Reservation> update = service.updateById(13,r);
        assertTrue(update.isSuccess());

    }

    @Test
    void doNotUpdateNull() throws DataException{
        Result<Reservation> update = service.updateById(13,null);
        assertFalse(update.isSuccess());
    }


    @Test
    void shouldQualifyHost() throws DataException {
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,3,11);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation("F",start,end,1,new BigDecimal("300"));
        Result<Reservation> update = service.updateById(13,r);
        assertFalse(update.isSuccess());
    }

    @Test
    void shouldNotAllowBadHost() throws DataException{
        Host host = hr.findAll().get(8);
        LocalDate start = LocalDate.of(2022,3,11);
        LocalDate end = LocalDate.of(2022,3,13);
        Reservation r = new Reservation(host.getId(),start,end,1,new BigDecimal("300"));
        Result<Reservation> update = service.updateById(13,r);
        assertFalse(update.isSuccess());
    }

    @Test
    void shouldNotUpdateIntoPast() throws DataException{
        Host host = hr.findAll().get(7);
        LocalDate start = LocalDate.of(2022,2,11);
        LocalDate end = LocalDate.of(2022,2,13);
        Reservation r = new Reservation(host.getId(),start,end,1,new BigDecimal("300"));
        Result<Reservation> update = service.updateById(13,r);
        assertFalse(update.isSuccess());
    }

    @Test
    void deleteByHostAndId() throws DataException {
        Host host = hr.findAll().get(7);
        Result<Boolean> update = service.deleteByHostAndId(host,13);
        assertTrue(update.isSuccess());
        assertEquals(12,service.findByHost(host).size());
    }

    @Test
    void cannotDeleteNullHost() throws DataException{
        Result<Boolean> update = service.deleteByHostAndId((Host) null,13);
        assertFalse(update.isSuccess());
        Result<Boolean> updatea = service.deleteByHostAndId((String) null,13);
        assertFalse(updatea.isSuccess());
    }

    @Test
    void shouldNotDeleteGuestNotInHost() throws DataException{
        Host host = hr.findAll().get(7);
        Result<Boolean> update = service.deleteByHostAndId(host,14);
        assertFalse(update.isSuccess());
    }

    @Test
    void shouldNotDeleteInPast() throws DataException{
        Host host = hr.findAll().get(7);
        Result<Boolean> update = service.deleteByHostAndId(host,1);
        assertFalse(update.isSuccess());

    }

}