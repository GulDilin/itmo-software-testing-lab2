package guldilin.function.logarithm;

import guldilin.function.CSVLogger;
import guldilin.function.Calculable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Log2 tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Log2Test {

    private static final double DELTA = 0.01;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new Log2();
    }

    @AfterAll
    void log() {
        CSVLogger logger = new CSVLogger("graph_log_2.csv", 0.01, 5, 0.1);
        logger.log(fun);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_log2_data.csv")
    void dataLog2TestStub(double input, double expected) {
        Log2 log2 = new Log2();
        log2.setLn(LogMocks.createLnMock());
        double actual = log2.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_log2_data.csv")
    void dataLog2Test(double input, double expected) {
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
