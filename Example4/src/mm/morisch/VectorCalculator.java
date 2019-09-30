package mm.morisch;

import java.util.function.BiFunction;

public class VectorCalculator extends AbstractCalculator {

    public VectorCalculator(CalculationOperation add, CalculationOperation sub, CalculationOperation multiply, CalculationOperation devide) {
        super(add, sub, multiply, devide);
    }


    public VectorCalculator() {
    }

    @Override
    public Number add(Number a, Number b) {
        BiFunction<Number, Number, Number> biFunction = (num1, num2) -> new Number(num1.getA() + num2.getA(), num1.getB() + num2.getB());
        return biFunction.apply(a, b);
    }

    @Override
    public Number sub(Number a, Number b) {
        BiFunction<Number, Number, Number> biFunction = (num1, num2) -> new Number(num1.getA() - num2.getA(), num1.getB() - num2.getB());
        return biFunction.apply(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        BiFunction<Number, Number, Number> biFunction = (num1, num2) -> new Number(num1.getA() * num2.getA(), num1.getB() * num2.getB());
        return biFunction.apply(a, b);
    }

    @Override
    public Number devide(Number a, Number b) {
        BiFunction<Number, Number, Number> biFunction = (num1, num2) -> new Number(num1.getA() / num2.getA(), num1.getB() / num2.getB());
        return biFunction.apply(a, b);
    }
}
