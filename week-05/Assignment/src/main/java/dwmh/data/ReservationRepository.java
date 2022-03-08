package dwmh.data;



import dwmh.models.Host;
import dwmh.models.Reservation;

import java.util.List;

public interface ReservationRepository {
    List<Reservation> findByHost(Host host) throws DataException;

    Reservation add(Reservation res) throws DataException;

    boolean deleteById(int id,Host host) throws DataException;

    boolean updateById(int id, Host host) throws DataException;


}
