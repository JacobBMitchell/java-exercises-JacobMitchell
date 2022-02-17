import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise03 {

    // 1. Create a method to print all Vehicles in a HashMap<String, Vehicle>.
    // Consider making it `public` so you can use it in other exercises.

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();
        printAllVehicles(vehicleMap);

        // 2. Print `vehicleMap` using your "print all" method.
    }

    public static void printAllVehicles(HashMap<String, Vehicle> vehicleMap) {
        for(Vehicle v: vehicleMap.values()){
            System.out.println(v);
        }
    }
}

