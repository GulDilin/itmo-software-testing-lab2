package guldilin.function;

import guldilin.function.logarithm.LogMocks;
import guldilin.function.trig.TrigMocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("System result function tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SystemResultFunctionTest {
    private static final double DELTA = 0.1;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new SystemResultFunction();
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/system_result_function_data.csv")
    void dataTestStub(double input, double expected) {
        SystemResultFunction systemResultFunction = new SystemResultFunction();
        systemResultFunction.setTrigResultFunction(TrigMocks.createTrigResultFunctionMock());
        systemResultFunction.setLogResultFunction(LogMocks.createLogResultFunctionMock());
        double actual = systemResultFunction.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }


    @ParameterizedTest()
    @CsvFileSource(resources = "/system_result_function_data.csv")
    void dataTest(double input, double expected) {
        double actual = fun.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

}
