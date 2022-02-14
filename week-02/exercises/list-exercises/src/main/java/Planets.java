public class Planets {
    public final String name;

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getDistFromSun() {
        return distFromSun;
    }

    public void setDistFromSun(double distFromSun) {
        this.distFromSun = distFromSun;
    }

    public double mass;
    public double distFromSun;

    public Planets(String name, double mass, double distFromSun) {
        this.name = name;
        this.mass = mass;
        this.distFromSun = distFromSun;
    }
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", minPlayers=" + mass +
                ", maxPlayers=" + distFromSun + '\'' +
                '}';
    }
}
