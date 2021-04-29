package guldilin.function.trig;

import guldilin.function.AbstractFunction;

public class TrigResultFunction extends AbstractFunction {
    private Cos cos;
    private Sin sin;
    private Csc csc;
    private Sec sec;
    private Cot cot;
    private Tan tan;

    public TrigResultFunction() {
        this.cos = new Cos();
        this.sin = new Sin();
        this.csc = new Csc();
        this.sec = new Sec();
        this.cot = new Cot();
        this.tan = new Tan();
    }

    @Override
    public double calculate(double x) {
        double result = sin.calculate(x) / tan.calculate(x);
        result *= result * result;
        result /= tan.calculate(x);
        result -= csc.calculate(x);
        result += cot.calculate(x);
        result *= result;
        result *= result;
        result /= tan.calculate(x);

        result /= cot.calculate(x) + (csc.calculate(x) - sec.calculate(x)) / sec.calculate(x);
        result += sin.calculate(x);
        result -= (tan.calculate(x) / sin.calculate(x));

        result *= (tan.calculate(x) * ((cos.calculate(x) + sin.calculate(x)) / cos.calculate(x)) - sin.calculate(x));
        result *= result * result;
        return result;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }

    public void setSin(Sin sin) {
        this.sin = sin;
    }

    public void setCot(Cot cot) {
        this.cot = cot;
    }

    public void setCsc(Csc csc) {
        this.csc = csc;
    }

    public void setSec(Sec sec) {
        this.sec = sec;
    }

    public void setTan(Tan tan) {
        this.tan = tan;
    }
}
