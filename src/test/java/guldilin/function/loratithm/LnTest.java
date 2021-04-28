package guldilin.function.loratithm;

import guldilin.function.Calculable;
import guldilin.function.logarithm.Ln;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Ln tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LnTest {

    private static final double DELTA = 0.01;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new Ln();
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/log_ln_data.csv")
    void dataLnTest(double input, double expected) {
        double actual = fun.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }
}
