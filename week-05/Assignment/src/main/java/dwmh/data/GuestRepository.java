package dwmh.data;

import dwmh.models.Guest;

import java.util.List;

public interface GuestRepository {
    //CRUD
    List<Guest> findAll() throws DataException;

    Guest add(Guest guest) throws DataException;

    boolean updateById(int Id, Guest guest) throws DataException;

    boolean deleteById(int id) throws DataException;

}
