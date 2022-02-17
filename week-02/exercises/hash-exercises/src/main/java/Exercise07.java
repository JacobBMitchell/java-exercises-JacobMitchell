import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise07 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();
        int count = 0;
        for (Vehicle c: vehicleMap.values()){
            if(c.getColor().equals("Pink")) count++;
        }
        System.out.println(count);
        // 1. How many vehicles are Pink (ignore case)?
        // Expected: 54
    }
}
