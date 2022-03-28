package memories.data;

import memories.models.Memory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemoryDB implements MemoryRepository{

    private final JdbcTemplate jdbcTemplate;

    public MemoryDB (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        final String sql = "select id, `from`, content, sharable from `memory`;";
        return jdbcTemplate.query(sql, (resultSet,rowNum) ->{
            Memory mem = new Memory();
            mem.setId(resultSet.getInt("id"));
            mem.setFrom(resultSet.getString("from"));
            mem.setContent(resultSet.getString("content"));
            mem.setShareable(resultSet.getBoolean("sharable"));
            return mem;
        });
    }

    @Override
    public Memory findById(int memoryId) throws DataAccessException {
        return null;
    }

    @Override
    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
        List<Memory> all = findAll();
        return all.stream().filter(a -> a.isShareable() == shareable).collect(Collectors.toList());
    }

    @Override
    public Memory add(Memory memory) throws DataAccessException {
        final String sql = "insert into `memory` (`from`,content,sharable)" +
                " values (?,?,?);";
        KeyHolder holder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,memory.getFrom());
            ps.setString(2,memory.getContent());
            ps.setBoolean(3, memory.isShareable());
            return ps;
        }, holder);
        if (rowsAffected <= 0){
            return  null;
        }
        memory.setId(holder.getKey().intValue());
        return memory;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {
        final String sql = "update `memory` set " +
                "`from` = ?, " +
                "content = ?, " +
                "sharable = ?, " +
                "where id = ?;";

        int rowsUpdated = jdbcTemplate.update(sql,
                memory.getFrom(),
                memory.getContent(),
                memory.isShareable(),
                memory.getId());
        return rowsUpdated > 0;
    }

    @Override
    public boolean deleteById(int memoryId) throws DataAccessException {
        final String sql = "delete from `memory` where id = ?;";
        return jdbcTemplate.update(sql,memoryId)>0;
    }
}
