package learn.pokedex.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Pokemon {
    @Id
    private int dexNumber;
    @NotBlank
    private String name;

    @NotNull
    @OneToOne
    @JoinColumn(name = "primary_poke_type_id")
    private PokeType primary;

    @NotNull
    @OneToOne
    @JoinColumn(name = "secondary_poke_type_id")
    private PokeType secondary;

    public int getDexNumber() {
        return dexNumber;
    }

    public void setDexNumber(int dexNumber) {
        this.dexNumber = dexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokeType getPrimary() {
        return primary;
    }

    public void setPrimary(PokeType primary) {
        this.primary = primary;
    }

    public PokeType getSecondary() {
        return secondary;
    }

    public void setSecondary(PokeType secondary) {
        this.secondary = secondary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return dexNumber == pokemon.dexNumber && Objects.equals(name, pokemon.name) && Objects.equals(primary, pokemon.primary) && Objects.equals(secondary, pokemon.secondary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dexNumber, name, primary, secondary);
    }
}
