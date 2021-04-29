package guldilin.function.logarithm;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.mockito.AdditionalMatchers;

import java.io.FileReader;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogMocks {
    private static final double DELTA = 0.01;

    public static Ln createLnMock() {
        Ln ln = mock(Ln.class);
        String csvFileName = "src/test/resources/logarithm/mocks/log_ln_data.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFileName))) {
            reader.readAll().forEach(lineArray -> {
                double input = Double.parseDouble(lineArray[0]);
                double output = Double.parseDouble(lineArray[1]);
                when(ln.calculate(AdditionalMatchers.eq(input, DELTA))).thenReturn(output);
            });
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return ln;
    }

    public static Log2 createLog2Mock() {
        Log2 log2 = mock(Log2.class);
        String csvFileName = "src/test/resources/logarithm/mocks/log_log2_data.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFileName))) {
            reader.readAll().forEach(lineArray -> {
                double input = Double.parseDouble(lineArray[0]);
                double output = Double.parseDouble(lineArray[1]);
                when(log2.calculate(AdditionalMatchers.eq(input, DELTA))).thenReturn(output);
            });
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return log2;
    }

    public static Log3 createLog3Mock() {
        Log3 log3 = mock(Log3.class);
        String csvFileName = "src/test/resources/logarithm/mocks/log_log3_data.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFileName))) {
            reader.readAll().forEach(lineArray -> {
                double input = Double.parseDouble(lineArray[0]);
                double output = Double.parseDouble(lineArray[1]);
                when(log3.calculate(AdditionalMatchers.eq(input, DELTA))).thenReturn(output);
            });
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return log3;
    }

    public static Log10 createLog10Mock() {
        Log10 log10 = mock(Log10.class);
        String csvFileName = "src/test/resources/logarithm/mocks/log_log10_data.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFileName))) {
            reader.readAll().forEach(lineArray -> {
                double input = Double.parseDouble(lineArray[0]);
                double output = Double.parseDouble(lineArray[1]);
                when(log10.calculate(AdditionalMatchers.eq(input, DELTA))).thenReturn(output);
            });
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return log10;
    }
}
