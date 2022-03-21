package data;

import model.Pet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Pet pet = new Pet();
        pet.setPetId(resultSet.getInt("pet_id"));
        pet.setName(resultSet.getString("name"));
        pet.setType(resultSet.getString("type"));
        return pet;
    }
}
