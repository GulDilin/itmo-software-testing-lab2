package guldilin.function.logarithm;

import guldilin.function.AbstractFunction;

public class LogN extends AbstractFunction {
    private Ln ln;
    private final int base;

    public LogN(int base) {
        ln = new Ln();
        this.base = base;
    }

    @Override
    public double calculate(double value) {
        return ln.calculate(value) / ln.calculate(base);
    }

    public void setLn(Ln ln) {
        this.ln = ln;
    }
}
