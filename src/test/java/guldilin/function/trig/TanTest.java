package guldilin.function.trig;

import guldilin.function.Calculable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tan tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TanTest {

    private static final double DELTA = 0.01;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new Tan();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_tan_data.csv")
    void dataDegreeTestStub(double inputDeg, double expected) {
        Tan tan = new Tan();
        tan.setCos(TrigMocks.createCosMock());
        tan.setSin(TrigMocks.createSinMock());
        double input = inputDeg / 180 * Math.PI;
        double actual = tan.calculate(input);
        System.out.printf("expected = %9f | inputDegrees = %9f | inputRad = %9f | actual = %9f\n",
                expected, inputDeg, input, actual);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_tan_pi_data.csv")
    void dataPITest(int nominator, int denominator, double expected) {
        double input = (nominator * Math.PI) / denominator;
        double actual = fun.calculate(input);
        System.out.printf("expected = %9f | nominator = %3d | denominator = %3d | input = %9f | actual = %9f\n",
                expected, nominator, denominator, input, actual);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_tan_data.csv")
    void dataDegreeTest(double inputDeg, double expected) {
        double input = inputDeg / 180 * Math.PI;
        double actual = fun.calculate(input);
        System.out.printf("expected = %9f | inputDegrees = %9f | inputRad = %9f | actual = %9f\n",
                expected, inputDeg, input, actual);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void testPositiveInfinity() {
        double actual = fun.calculate(Math.PI / 2);
        assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
        actual = fun.calculate(Math.PI / 2 + 4 * Math.PI);
        assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
    }

    @Test
    void testNegativeInfinity() {
        double actual = fun.calculate(- Math.PI / 2);
        assertEquals(Double.NEGATIVE_INFINITY, actual, DELTA);
        actual = fun.calculate(- Math.PI / 2 + 4 * Math.PI);
        assertEquals(Double.NEGATIVE_INFINITY, actual, DELTA);
    }
}