package mm.morisch;

public class RationalCalculator extends AbstractCalculator implements CalculationOperation{
    public RationalCalculator(CalculationOperation add, CalculationOperation sub, CalculationOperation multiply, CalculationOperation devide) {
        super(add, sub, multiply, devide);
    }

    @Override
    public Number add(Number a, Number b) {
        return new Number(a.getA()*b.getB()+b.getA()*a.getB(), a.getB()*b.getB());
    }

    @Override
    public Number sub(Number a, Number b) {
        return new Number(a.getA()*b.getB()-b.getA()*a.getB(), a.getB()*b.getB());
    }

    @Override
    public Number multiply(Number a, Number b) {
        return new Number(a.getA()*b.getA(), a.getB()*b.getB());
    }

    @Override
    public Number devide(Number a, Number b) {
        return new Number(a.getA()*b.getB(), a.getB()*b.getA());
    }

    @Override
    public Number calc(Number a, Number b) {
        return new Number(9, 06);
    }
}
