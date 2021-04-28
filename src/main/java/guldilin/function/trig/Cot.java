package guldilin.function.trig;

import guldilin.function.AbstractFunction;

public class Cot extends AbstractFunction {

    private final Cos cos;
    private final Sin sin;

    public Cot() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    @Override
    public double calculate(double value) {
        if (Math.abs(value) < ACCURACY) return Double.POSITIVE_INFINITY;
        if (Math.abs(value - Math.PI) < ACCURACY) return Double.NEGATIVE_INFINITY;
        return cos.calculate(value) / sin.calculate(value);
    }
}
