package guldilin.function.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Quarter tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuarterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/trig_radian_quarter_data.csv")
    public void quarterRadianTest(double radian, int expectedQuarter) {
        Quarter actualQuarter = Quarter.of(radian);
        assertEquals(expectedQuarter, actualQuarter.ordinal());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig_degree_quarter_data.csv")
    public void quarterDegreeTest(double degree, int expectedQuarter) {
        double radian = degree / 180 * Math.PI;
        Quarter actualQuarter = Quarter.of(radian);
        assertEquals(expectedQuarter, actualQuarter.ordinal());
    }
}
