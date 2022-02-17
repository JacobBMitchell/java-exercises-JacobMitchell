import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise04 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();
        Vehicle myCar = new Vehicle();
        myCar.setColor("Teal");
        myCar.setMake("Rolls Royce");
        myCar.setModel("Phantom");
        myCar.setVin("abc123");
        myCar.setYear(2022);
        vehicleMap.put(myCar.getVin(), myCar);
        System.out.println(vehicleMap.get("abc123"));
        // 1. Create a new Vehicle. Use a VIN that's easy to remember.
        // 2. Add the Vehicle to `vehicleMap` with the `put` method.
        // 3. Confirm the Vehicle was added by retrieving it with `get` and printing it to the console.
    }
}
