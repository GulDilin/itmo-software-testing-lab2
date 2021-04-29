package guldilin.function.trig;

import guldilin.function.Calculable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Sin tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SinTest {

    private static final double DELTA = 0.01;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new Sin();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_sin_pi_data.csv")
    void dataPITest(double expected, int nominator, int denominator) {
        double input = (nominator * Math.PI) / denominator;
        double actual = fun.calculate(input);
        System.out.printf("expected = %9f | nominator = %3d | denominator = %3d | input = %9f | actual = %9f\n",
                expected, nominator, denominator, input, actual);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_sin_data.csv")
    void dataDegreeTest(double expected, double inputDeg) {
        double input = inputDeg / 180 * Math.PI;
        double actual = fun.calculate(input);
        System.out.printf("expected = %9f | inputDegrees = %9f | inputRad = %9f | actual = %9f\n",
                expected, inputDeg, input, actual);
        assertEquals(expected, actual, DELTA);
    }
}