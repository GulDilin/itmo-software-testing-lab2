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
        double accuracy = getAccuracy();
        if (Math.abs(value) < accuracy) return Double.POSITIVE_INFINITY;
        if (Math.abs(value - Math.PI) < accuracy) return Double.NEGATIVE_INFINITY;
        return cos.calculate(value) / sin.calculate(value);
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }

    public void setSin(Sin sin) {
        this.sin = sin;
    }
}
