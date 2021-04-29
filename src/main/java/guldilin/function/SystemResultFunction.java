package guldilin.function;

import guldilin.function.logarithm.LogResultFunction;
import guldilin.function.trig.TrigResultFunction;

public class SystemResultFunction extends AbstractFunction {
    private LogResultFunction logResultFunction;
    private TrigResultFunction trigResultFunction;

    public SystemResultFunction() {
        this.logResultFunction = new LogResultFunction();
        this.trigResultFunction = new TrigResultFunction();
    }

    @Override
    public double calculate(double value) {
        if (value <= 0) return trigResultFunction.calculate(value);
        return logResultFunction.calculate(value);
    }

    public void setLogResultFunction(LogResultFunction logResultFunction) {
        this.logResultFunction = logResultFunction;
    }

    public void setTrigResultFunction(TrigResultFunction trigResultFunction) {
        this.trigResultFunction = trigResultFunction;
    }
}
