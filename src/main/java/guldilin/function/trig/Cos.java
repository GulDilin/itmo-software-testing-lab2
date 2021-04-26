package guldilin.function.trig;

import guldilin.function.AbstractFunction;

public class Cos extends AbstractFunction {
    @Override
    public double calculate(double x) {
        double result = 1D;
        double current = 1D;
        double previous = 0;

        for (int i = 1; Math.abs(current - previous) > ACCURACY && i < MAX_ITERATIONS ; i++) {
            previous = current;
            current *= ( x * x * -1 );
            current /= ( (2 * i) * (2 * i - 1) );
            result += current;
        }

        if (result > 1) return 1;
        if (result < -1) return -1;
        return result;
    }
}
