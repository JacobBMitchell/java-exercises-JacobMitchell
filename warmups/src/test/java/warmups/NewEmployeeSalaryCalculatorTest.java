package warmups;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NewEmployeeSalaryCalculatorTest {
    NewEmployeeSalaryCalculator salary = new NewEmployeeSalaryCalculator();

    @Test
    void calculate() {
        //Jan 1
        //$60000
        //expected: $62550
        LocalDate start = LocalDate.of(2020, 1,1);
        BigDecimal income = new BigDecimal("60000");
        BigDecimal expected = new BigDecimal("62550.00");
        BigDecimal calculated = salary.calculate(start, income);
        assertEquals(expected, calculated); //60000*1.03*1.03

        //April 1
        //50000
        //expected:38890.03
        LocalDate start1 = LocalDate.of(2020, 4,1);
        BigDecimal income1 = new BigDecimal("50000");
        BigDecimal expected1 = new BigDecimal("38875.03");
        assertEquals(expected1, salary.calculate(start1,income1));

        LocalDate start2 = LocalDate.of(2020, 4,2);
        BigDecimal income2 = new BigDecimal("60000");
        assertThrows(IllegalArgumentException.class,()-> salary.calculate(start2,income2));

        //Exception exc = assertThrows(IllegalArgumentException.class,() -> );
       // assertEquals(expected1, salary.calculate(start2,income2));


    }
}