import java.util.Arrays;

public class Hero {
    private String name;
    Power[] powers;

    Hero(String name, Power[] powers) {
        this.name = name;
        this.powers = powers;
    }

    public String toLine() {
        String line = getName()+":";
        for (Power power: getPowers()){
            line += " " + power.getName();
        }
        return line;
    }

    public String getName() {
        return name;
    }

    public Power[] getPowers(){
        return powers;
    }
}
