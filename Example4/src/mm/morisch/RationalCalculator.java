package mm.morisch;

import java.util.function.BiFunction;

public class RationalCalculator extends AbstractCalculator{
    public RationalCalculator(CalculationOperation add, CalculationOperation sub, CalculationOperation multiply, CalculationOperation devide) {
        super(add, sub, multiply, devide);
    }

    public RationalCalculator() {
    }

    @Override
    public Number add(Number a, Number b) {
        //BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" +(num1 + num2);
        //System.out.println(biFunction.apply(20,25));
        //return new Number(a.getA()*b.getB()+b.getA()*a.getB(), a.getB()*b.getB());
        BiFunction<Number, Number, Number> biFunction = (num1, num2) -> new Number(num1.getA()*num2.getB()+num2.getA()*num1.getB(), num1.getB()*num2.getB());
        return biFunction.apply(a, b);
    }

    @Override
    public Number sub(Number a, Number b) {
        BiFunction<Number, Number, Number> biFunction = (num1, num2) -> new Number(num1.getA()*num2.getB()-num2.getA()*num1.getB(), num1.getB()*num2.getB());
        return biFunction.apply(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        //return new Number(a.getA()*b.getA(), a.getB()*b.getB());
        BiFunction<Number, Number, Number> biFunction = (num1, num2) -> new Number(num1.getA()*num2.getA(), num1.getB()*num2.getB());
        return biFunction.apply(a, b);
    }

    @Override
    public Number devide(Number a, Number b) {
        //return new Number(a.getA()*b.getB(), a.getB()*b.getA());
        BiFunction<Number, Number, Number> biFunction = (num1, num2) -> new Number(num1.getA()*num2.getB(), num1.getB()*num2.getA());
        return biFunction.apply(a, b);
    }

}
