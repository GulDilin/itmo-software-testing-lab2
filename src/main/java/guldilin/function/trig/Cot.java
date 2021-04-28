package guldilin.function.trig;

import guldilin.function.AbstractFunction;

public class Cot extends AbstractFunction {

    private Cos cos;
    private Sin sin;

    public Cot() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    @Override
    public double calculate(double value) {
        return cos.calculate(value) / sin.calculate(value);
    }
}
