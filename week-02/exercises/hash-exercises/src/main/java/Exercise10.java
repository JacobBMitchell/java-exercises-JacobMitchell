import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise10 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        Vehicle bus = new Vehicle();
        bus.setMake("Chrysler");
        bus.setModel("School Bus");
        bus.setVin("2G4WD582061270646");
        bus.setYear(1994);
        bus.setColor("Orange");
        System.out.println(vehicleMap.get(bus.getVin()));
        vehicleMap.replace(bus.getVin(),bus);
        System.out.println(vehicleMap.get(bus.getVin()));

        // 1. Replace the vehicle with VIN 2G4WD582061270646 with a new Orange 1994 Chrysler School Bus.
        // 2. Retrieve the new vehicle from `vehicleMap` and print it to confirm it was updated.
    }
}
