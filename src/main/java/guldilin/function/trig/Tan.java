package guldilin.function.trig;

import guldilin.function.AbstractFunction;

public class Tan extends AbstractFunction {

    private final Cos cos;
    private final Sin sin;

    public Tan() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    @Override
    public double calculate(double value) {
        double accuracy = getAccuracy();
        double cropValue = Quarter.cropAnglePositive(value);
        if (Math.abs(cropValue - Math.PI / 2) < accuracy) return Double.POSITIVE_INFINITY;
        if (Math.abs(cropValue - Math.PI * 3 / 2) < accuracy) return Double.NEGATIVE_INFINITY;
        return sin.calculate(value) / cos.calculate(value);
    }
}
