package guldilin.function.trig;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Cos tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CosTest {

    private static final double DELTA = 0.01;
    private Cos cos;

    @BeforeAll
    void setUp() {
        cos = new Cos();
    }

    @ParameterizedTest(name = "Calculate cos({0})")
    @CsvFileSource(resources = "/trig_cos_pi_data.csv")
    void dataPITest(double expected, int nominator, int denominator) {
        double input = (nominator * Math.PI) / denominator;
        double actual = cos.calculate(input);
        System.out.printf("expected = %9f | nominator = %3d | denominator = %3d | input = %9f | actual = %9f\n",
                expected, nominator, denominator, input, actual);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest(name = "Calculate cos({0})")
    @CsvFileSource(resources = "/trig_cos_data.csv")
    void dataTest(double expected, double inputDeg) {
        double input = inputDeg / 180 * Math.PI;
        double actual = cos.calculate(input);
        System.out.printf("expected = %9f | inputDegrees = %9f | inputRad = %9f | actual = %9f\n",
                expected, inputDeg, input, actual);
        assertEquals(expected, actual, DELTA);
    }
}