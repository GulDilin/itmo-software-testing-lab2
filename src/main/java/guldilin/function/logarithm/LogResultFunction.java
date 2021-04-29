package guldilin.function.logarithm;

import guldilin.function.AbstractFunction;

public class LogResultFunction extends AbstractFunction {

    private Ln ln;
    private Log2 log2;
    private Log3 log3;
    private Log10 log10;

    public LogResultFunction() {
        this.ln = new Ln();
        this.log2 = new Log2();
        this.log3 = new Log3();
        this.log10 = new Log10();
    }

    @Override
    public double calculate(double x) {
        double result = 2 * log2.calculate(x);
        result /= log10.calculate(x);
        result /= (log3.calculate(x) - ln.calculate(x)) * log2.calculate(x);
        result *= result;
        result += log10.calculate(x);
        return result;
    }

    public void setLn(Ln ln) {
        this.ln = ln;
    }

    public void setLog2(Log2 log2) {
        this.log2 = log2;
    }

    public void setLog3(Log3 log3) {
        this.log3 = log3;
    }

    public void setLog10(Log10 log10) {
        this.log10 = log10;
    }
}
