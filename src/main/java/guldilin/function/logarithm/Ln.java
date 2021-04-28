package guldilin.function.logarithm;

import guldilin.function.AbstractFunction;

public class Ln extends AbstractFunction {
    @Override
    public double calculate(double value) {
        if (value <= 0) throw new IllegalArgumentException("Value need to be upper that zero");
        if (value > 2) return -calculate(1 / value);

        double x = value - 1;
        double result = x;
        double current = x;

        for (int i = 2; i < MAX_ITERATIONS ; i++) {
            current *= ( x * -1 * (i - 1) );
            current /= i;
            result += current;
        }

        return result;

    }
}
