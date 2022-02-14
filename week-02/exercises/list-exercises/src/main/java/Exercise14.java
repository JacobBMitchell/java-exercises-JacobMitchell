import java.util.ArrayList;

public class Exercise14 {
    public static void main(String[] args) {
        ArrayList<Planets> planets = new ArrayList<>();
        Planets earth = new Planets("Earth",6.02*Math.pow(10,24),1);
        Planets venus = new Planets("Venus",4.8*Math.pow(10,24),.723);
        Planets mercury = new Planets("Mercury",3.28*Math.pow(10,23),.4);
        Planets mars = new Planets("Mars",6.39*Math.pow(10,23),1.33);
        planets.add(earth);
        planets.add(venus);
        planets.add(mercury);
        planets.add(mars);
        System.out.println(planets);
    }

}
