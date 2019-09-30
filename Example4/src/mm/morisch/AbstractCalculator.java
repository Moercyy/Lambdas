package mm.morisch;

public abstract class AbstractCalculator {

        protected CalculationOperation add;
        protected CalculationOperation sub;
        protected CalculationOperation multiply;
        protected CalculationOperation devide;

    public AbstractCalculator(CalculationOperation add, CalculationOperation sub, CalculationOperation multiply, CalculationOperation devide) {
        this.add = add;
        this.sub = sub;
        this.multiply = multiply;
        this.devide = devide;
    }

    public AbstractCalculator(){

    }

    public abstract Number add(Number a, Number b);
    public abstract Number sub(Number a, Number b);
    public abstract Number multiply(Number a, Number b);
    public abstract Number devide(Number a, Number b);
}
