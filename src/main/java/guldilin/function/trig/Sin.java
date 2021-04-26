package guldilin.function.trig;

import guldilin.function.AbstractFunction;

public class Sin extends AbstractFunction {
    private final Cos cos;

    public Sin() {
        this.cos = new Cos();
    }

    @Override
    public double calculate(double x) {
        double value = Math.sqrt(1 - cos.calculate(x) * cos.calculate(x));
        Quarter quarter = Quarter.of(x);
        return quarter.isTop() ? value : -value;
    }
}
