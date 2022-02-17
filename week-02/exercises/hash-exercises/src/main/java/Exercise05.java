import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise05 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();
        HashMap<String, Vehicle> myVehicleMap = new HashMap<>();
        Vehicle car1 = new Vehicle();
        Vehicle car2 = new Vehicle();
        car1.setVin("bbc111");
        car2.setVin("1a2b3c");
        car1.setModel("Challenger");
        car2.setModel("Aventador");
        myVehicleMap.put(car1.getVin(),car1);
        myVehicleMap.put(car2.getVin(),car2);
        vehicleMap.putAll(myVehicleMap);
        Exercise03.printAllVehicles(vehicleMap);
        System.out.println(vehicleMap.get(car1.getVin()));
        System.out.println(vehicleMap.get(car2.getVin()));


        // 1. Instantiate a new HashMap<String, Vehicle>.
        // 2. Add two vehicles to the new map.
        // 3. Add items from the new map to `vehicleMap` using the `putAll` method.
        // 4. Confirm the vehicles were added by retrieving on with its VIN and printing it to the console.
    }
}
