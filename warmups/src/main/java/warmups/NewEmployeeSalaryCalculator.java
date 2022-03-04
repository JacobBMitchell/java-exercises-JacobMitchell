package warmups;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.lang.IllegalArgumentException;

public class NewEmployeeSalaryCalculator {

    public BigDecimal calculate(LocalDate date, BigDecimal yearlySalary){
        if (date.getDayOfMonth() != 1){
            throw new IllegalArgumentException("Cannot have day not the first");
        }
        BigDecimal monthlyRate = yearlySalary.divide(BigDecimal.valueOf(12),2, RoundingMode.HALF_UP);
        BigDecimal pay = BigDecimal.ZERO;

        LocalDate startDate = date;
        LocalDate nextYear = LocalDate.of(date.getYear()+1,1,1);

        BigDecimal raiseRate = BigDecimal.ONE;
        while (date.isBefore(nextYear)){
            if (date.isEqual(startDate.plusMonths(2)) || date.isAfter(startDate.plusMonths(2))){
                raiseRate = new BigDecimal("1.03");
            }
            if (date.isEqual(startDate.plusMonths(5)) || date.isAfter(startDate.plusMonths(5))){
                raiseRate = new BigDecimal("1.06");
            }
            pay = pay.add(monthlyRate.multiply(raiseRate));

            date = date.plusMonths(1);
        }


        return pay.setScale(2,RoundingMode.HALF_UP);
    }

}
