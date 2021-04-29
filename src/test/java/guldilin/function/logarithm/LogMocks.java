package guldilin.function.logarithm;


import guldilin.function.MockCSVer;

import static org.mockito.Mockito.mock;


public class LogMocks {
    private static final double DELTA = 0.01;

    public static Ln createLnMock() {
        Ln fun = mock(Ln.class);
        MockCSVer.setupFromCSV(fun, "src/test/resources/logarithm/mocks/log_ln_data.csv", DELTA);
        return fun;
    }

    public static Log2 createLog2Mock() {
        Log2 fun = mock(Log2.class);
        MockCSVer.setupFromCSV(fun, "src/test/resources/logarithm/mocks/log_log2_data.csv", DELTA);
        return fun;
    }

    public static Log3 createLog3Mock() {
        Log3 fun = mock(Log3.class);
        MockCSVer.setupFromCSV(fun, "src/test/resources/logarithm/mocks/log_log3_data.csv", DELTA);
        return fun;
    }

    public static Log10 createLog10Mock() {
        Log10 fun = mock(Log10.class);
        MockCSVer.setupFromCSV(fun, "src/test/resources/logarithm/mocks/log_log10_data.csv", DELTA);
        return fun;
    }

    public static LogResultFunction createLogResultFunctionMock() {
        LogResultFunction fun = mock(LogResultFunction.class);
        MockCSVer.setupFromCSV(fun, "src/test/resources/logarithm/mocks/log_log_result_function_data.csv", DELTA);
        return fun;
    }
}
