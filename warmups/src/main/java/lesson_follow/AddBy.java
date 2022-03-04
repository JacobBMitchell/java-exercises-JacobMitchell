package lesson_follow;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AddBy {
    public static void main(String[] args) {
        List<Address> addresses = getAddresses();

        Predicate<Address> clarksville = a -> a.getCity().equalsIgnoreCase("Clarksville");
       // Function<Address, String> getCity = Address::getCity;
        List<Address> addressesByCity = filter(addresses, clarksville);
        List<Address> addressesByState = filter(addresses, address -> address.getState().equalsIgnoreCase("TN"));


        print(addressesByCity);
        System.out.println();
        print(addressesByState);


        //Predicate<Address> cities = a -> a.getCity().contains("a");

        //List<Address> testByCity = tbc(addresses, getCity);

//        Stream<Address> addressStream = getAddressesStream()=

    }

//    private static List<Address> tbc(List<Address> addresses, Function<Address, String> getCity) {
//        ArrayList<Address> result = new ArrayList<>();
//        for (Address b: addresses){
//            System.out.println(b::getCity);
//        }
//    }

    private static void print(List<Address> addressesBy) {
        for (Address a: addressesBy){
            System.out.println(a.toString());
        }
    }

    static List<Address> filter(List<Address> source , Predicate<Address> criteria){
        ArrayList<Address> result = new ArrayList<>();
        for (Address a : source) {
            if (criteria.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    private static List<Address> getAddresses() {
        List<Address> addresses = new ArrayList<>();
        Address add1 = new Address("Shiloh Canaan", "Palmyra","TN","37142");
        Address add2 = new Address("Bellevue", "Tucson","AZ","85716");
        Address add3 = new Address("Center Pointe", "Clarksville","TN","37140");
        addresses.add(add1);
        addresses.add(add2);
        addresses.add(add3);
        return addresses;
    }
}
