package guldilin.function.logarithm;

import guldilin.function.Calculable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Log3 tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Log3Test {

    private static final double DELTA = 0.01;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new Log3();
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_log3_data.csv")
    void dataLog3Test(double input, double expected) {
        double actual = fun.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void zeroTest() {
        assertThrows(IllegalArgumentException.class, () -> fun.calculate(0));
    }
}
