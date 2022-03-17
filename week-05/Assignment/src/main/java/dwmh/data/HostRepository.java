package dwmh.data;

import dwmh.models.Host;

import java.util.List;

public interface HostRepository {

    List<Host> findAll() throws DataException;

    Host add(Host host) throws DataException;

    boolean updateById(String id, Host host) throws DataException;

    boolean deleteById(String id) throws DataException;
}
