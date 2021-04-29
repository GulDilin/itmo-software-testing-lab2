package guldilin.function.trig;

import guldilin.function.AbstractFunction;

public class Sec extends AbstractFunction {
    private Cos cos;

    public Sec() {
        this.cos = new Cos();
    }

    @Override
    public double calculate(double value) {
        return 1 / cos.calculate(value);
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }
}
