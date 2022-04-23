package memories.domain;

import memories.models.Memory;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationMemoryTest {

    @Test
    void emptyMemoryShouldFail() {
        Memory mem = new Memory();
        MemoryResult res = new MemoryResult();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Memory>> violations = validator.validate(mem);
        assertEquals(2,violations.size());
        violations.stream().forEach(a -> res.addErrorMessage(a.getMessage()));
        //return res;
        res.getErrorMessages().forEach(System.out::println);
        //in this validation I could
        //return res;

        //servicelayer
        //return violations
        //
    }
}
