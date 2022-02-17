import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise04Test {

    @Test
    void calculateTotalCost() {
        Exercise04 instance = new Exercise04();

        // doubles are notoriously hard to test because they use floating-point rounding.
        // The third argument in `assertEquals` is a delta. It represents the margin of error for equality.
        // As long as the expected and actual differ by less than the delta, the test passes.
        assertEquals(1.25, instance.calculateTotalCost(0.25, 5), 0.001);//100
        assertEquals(99.06, instance.calculateTotalCost(1.27, 100), 0.001);//.78
        assertEquals(0, instance.calculateTotalCost(1,-3),.001);
        assertEquals(0,instance.calculateTotalCost(-2,30),.001);
        assertEquals(0, instance.calculateTotalCost(-25,-3),.001);
        assertEquals(47.5, instance.calculateTotalCost(2,25),.001);//.95
        assertEquals(1296, instance.calculateTotalCost(30,48),.001);//.9
        assertEquals(591.6, instance.calculateTotalCost(12,58),.001);//.85

    }
}