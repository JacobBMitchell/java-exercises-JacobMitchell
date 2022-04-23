package learn.pokedex.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class PokeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pokeTypeId;
    @NotBlank
    private String name;

    public int getPokeTypeId() {
        return pokeTypeId;
    }

    public void setPokeTypeId(int pokeTypeId) {
        this.pokeTypeId = pokeTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokeType pokeType = (PokeType) o;
        return pokeTypeId == pokeType.pokeTypeId && Objects.equals(name, pokeType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokeTypeId, name);
    }
}
