package data;

import model.Pet;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PetJdbcTemplateRepository implements PetRepository{

    private final JdbcTemplate jdbcTemplate;
    

    // 1. Create a single mapper for all find methods.
    private final RowMapper<Pet> mapper = (resultSet, rowNum) -> {
        Pet pet = new Pet();
        pet.setPetId(resultSet.getInt("pet_id"));
        pet.setName(resultSet.getString("name"));
        pet.setType(resultSet.getString("type"));
        return pet;
    };

    public PetJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> findAll() {
        final String sql = "select pet_id, `name`, `type` from pet;";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Pet findById(int petId) {
        final String sql = "select pet_id, `name`, `type` from pet where pet_id = ?;";
        try {
            // 2. Parameters always follow SQL and mappers.
            // Any number of parameters is allowed.
            return jdbcTemplate.queryForObject(sql, mapper, petId);
        } catch (EmptyResultDataAccessException ex) {
            // 3. queryForObject can throw an unchecked exception
            // If the ResultSet is empty, it just means the pet with the id wasn't found.
            // So returning null is valid.
            return null;
        }
    }

    @Override
    public Pet add(Pet pet) {
        return null;
    }

    @Override
    public boolean update(Pet pet) {
        return false;
    }

    @Override
    public boolean deleteById(int petId) {
        return false;
    }
}
