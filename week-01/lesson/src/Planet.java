public class Planet {
    public final double G = 6.67*Math.pow(10,-11);
    public final double mass;
    private double[] pos;
    private double[] vel;

    public Planet(double mass, double[] pos, double[] vel) {
        this.mass = mass;
        this.setPos(pos);
        this.setVel(vel);
    }

    public double forceOfGravity (Planet p2){
        return G*this.mass*p2.mass/Math.pow(distBetween(this, p2),2);
    }

    public double distBetween(Planet planet, Planet p2) {
        double x2 = planet.pos[0]*planet.pos[0] + p2.pos[0]*p2.pos[0];
        double y2 = planet.pos[1]*planet.pos[1] + p2.pos[1]*p2.pos[1];
        return Math.sqrt(x2 + y2);
    }

    public double[] getPos() {
        return pos;
    }

    public void setPos(double[] pos) {
        this.pos = pos;
    }

    public double[] getVel() {
        return vel;
    }

    public void setVel(double[] vel) {
        this.vel = vel;
    }
}
