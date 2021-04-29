package guldilin.function.logarithm;

import guldilin.function.CSVLogger;
import guldilin.function.Calculable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Log result function tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogResultFunctionTest {
    private static final double DELTA = 0.1;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new LogResultFunction();
    }

    @AfterAll
    void log() {
        CSVLogger logger = new CSVLogger("graph_log_result_function.csv", 0.01, 5, 0.01);
        logger.log(fun);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_log_result_function_data.csv")
    void dataTestStub(double input, double expected) {
        LogResultFunction logResultFunction = new LogResultFunction();
        logResultFunction.setLn(LogMocks.createLnMock());
        logResultFunction.setLog2(LogMocks.createLog2Mock());
        logResultFunction.setLog3(LogMocks.createLog3Mock());
        logResultFunction.setLog10(LogMocks.createLog10Mock());

        double actual = logResultFunction.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_log_result_function_data.csv")
    void dataTest(double input, double expected) {
        double actual = fun.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

}
