import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;
import java.util.Map;

public class Exercise06 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Loop over each vehicle in `vehicleMap` and print vehicles with a Dodge make.
        for(Vehicle car:vehicleMap.values()){
            if (car.getMake().equals("Dodge")){
                System.out.println(car);
            }
        }
        System.out.println();
        for(Map.Entry<String, Vehicle> vin: vehicleMap.entrySet()){
            if(vin.getValue().getMake().equals("Dodge")){
                System.out.println(vin.getValue());
            }

        }
        System.out.println();
        for(String key : vehicleMap.keySet()){
            if (vehicleMap.get(key).getMake().equals("Dodge")){
                System.out.println(vehicleMap.get(key));
            }
        }
        // 2. Loop three times with three different techniques: .values(), .entrySet(), and .keySet().
    }
}
