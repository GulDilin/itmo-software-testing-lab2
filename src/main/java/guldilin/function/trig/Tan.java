package guldilin.function.trig;

import guldilin.function.AbstractFunction;

public class Tan extends AbstractFunction {

    private Cos cos;
    private Sin sin;

    public Tan() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    @Override
    public double calculate(double value) {
        return sin.calculate(value) / cos.calculate(value);
    }
}
