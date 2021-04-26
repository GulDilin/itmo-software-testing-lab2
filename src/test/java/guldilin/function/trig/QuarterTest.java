package guldilin.function.trig;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuarterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/trig_radian_quarter_data.csv")
    public void defileRadianQuarter(double x, int expectedQuarter) {
        Quarter actualQuarter = Quarter.of(x);
        assertEquals(expectedQuarter, actualQuarter.ordinal());
    }
}
