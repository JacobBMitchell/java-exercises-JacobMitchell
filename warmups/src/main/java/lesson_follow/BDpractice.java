package lesson_follow;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BDpractice {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("10.5");
        BigDecimal b = a.divide(new BigDecimal(2.5));
        System.out.println(b);
        block1();
        block2();
        BigDecimal value = new BigDecimal("1.13");
        BigDecimal twoHundredths = new BigDecimal("0.02");
        BigDecimal threshold = new BigDecimal("2.0");
        System.out.println("VALUE |  UP  | DOWN | CEILING | FLOOR | HALF_UP | HALF_DOWN | HALF_EVEN");
        for (; value.compareTo(threshold) < 0; value = value.add(twoHundredths)) {
            System.out.printf("%s  |  %s | %s  | %s     | %s   | %s     | %s       | %s%n",
                    value,
                    value.setScale(1, RoundingMode.UP),
                    value.setScale(1, RoundingMode.DOWN),
                    value.setScale(1, RoundingMode.CEILING),
                    value.setScale(1, RoundingMode.FLOOR),
                    value.setScale(1, RoundingMode.HALF_UP),
                    value.setScale(1, RoundingMode.HALF_DOWN),
                    value.setScale(1, RoundingMode.HALF_EVEN)
            );
        }
    }

    public static void block2(){
        BigDecimal rent = new BigDecimal("1200.00");
        BigDecimal utilities = new BigDecimal("225.00");

        BigDecimal fixedCosts = rent.add(utilities);
        System.out.println(fixedCosts);
    }

    public static void block1(){
        double taxRevenue = 3500000000000.0;
        int dozen = 12;

        BigDecimal usTaxRevenue = new BigDecimal(taxRevenue);
        BigDecimal perPackage = new BigDecimal(dozen);
        BigDecimal quadCopterPrice = new BigDecimal("299.99");

        BigDecimal value = null;

        try {
            value = new BigDecimal("nefarious");
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(usTaxRevenue);
        System.out.println(perPackage);
        System.out.println(quadCopterPrice);
        System.out.println(value);

    }
}
