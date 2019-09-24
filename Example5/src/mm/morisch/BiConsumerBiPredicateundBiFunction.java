package mm.morisch;

import java.util.function.*;

public class BiConsumerBiPredicateundBiFunction {

    public static void main(String[] args) {
        boolean resultl = biVergleich((a, b) -> a == b * 3, 30, 10);
        biAnzeige((Integer il, Integer i2) -> System.out.println("Das Ergebnis des Testes " + i2 + " * 3 == " + il + " mit BiPredicate ist " + resultl), 30, 10);

        Integer result2 = biBerechnung((Integer il, Integer i2) -> il - i2, 15, 10);
        biAnzeige((Integer il, Integer i2) -> System.out.println("Der Wert der BiFunction mit den Argumenten " + il + " und " + i2 + " ist " + result2), 15, 10);

        Integer result3 = biBerechnung(BinaryOperator.<Integer>maxBy(Integer::compareTo), 20, 10);
        biAnzeige((Integer il, Integer i2) -> System.out.println("Der Wert des BinaryOperators maxBy " + "mit den Argumenten " + il + " and " + i2 + " ist " + result3), 20, 10);

        Integer result4 = biBerechnung(BinaryOperator.<Integer>minBy(Integer::compareTo), 5, 10);
        biAnzeige((Integer il, Integer i2) -> System.out.println("Der Wert des BinaryOperators minBy " + "mit den Argumenten " + il + " and " + i2 + " ist " + result4), 5, 10);

        UnaryOperator<Integer> identityOperator = UnaryOperator.<Integer>identity();
        Integer result5 = berechnung(identityOperator.andThen((t) -> {
            return t * 3;
        }), 20);
        anzeige((i) -> System.out.println("Der Wert des UnaryOperators mit dem Argument " + i + " ist " + result5), 60);

    }

    static boolean vergleich(Predicate<Integer> predicate, Integer i) {
        return predicate.test(i);
    }

    static void anzeige(Consumer<Integer> consumer, Integer i) {
        consumer.accept(i);
    }

    static boolean biVergleich(BiPredicate<Integer, Integer> biPredicate,
                               Integer i1, Integer i2) {
        return biPredicate.test(i1, i2);
    }

    static void biAnzeige(BiConsumer<Integer, Integer> biConsumer, Integer i1, Integer i2) {
        biConsumer.accept(i1, i2);
    }

    static Integer berechnung(Function<Integer, Integer> function, Integer i) {
        return function.apply(i);
    }

    static Integer biBerechnung(BiFunction<Integer, Integer, Integer> biFunction, Integer i1, Integer i2) {
        return biFunction.apply(i1, i2);
    }
}

