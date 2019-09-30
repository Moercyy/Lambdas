package mm.morisch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Number> numbers = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        ComplexCalculator complexCalculator = new ComplexCalculator();
        RationalCalculator rationalCalculator = new RationalCalculator();
        VectorCalculator vectorCalculator = new VectorCalculator();
        int z = 0;

        do {
            System.out.println("Wählen sie einen Rechner:");
            System.out.println("1...ComplexCalculator");
            System.out.println("2...RationalCalculator");
            System.out.println("3...VectorCalculator");
            System.out.println("4...Beenden");
            int des = sc.nextInt();


            if (des > 4 || des < 0) {
                System.out.println("Bitte geben Sie eine Zahl zwischen 1-4 ein.");

            }
            switch (des) {
                case 1:
                    z = main.getRechenoperation();
                    main.numbers.clear();
                    main.numbers = main.getNumbers();
                    if (z == 1) {
                        System.out.println(complexCalculator.add(main.numbers.get(0), main.numbers.get(0)).toString());
                    } else if (z == 2) {
                        System.out.println(complexCalculator.sub(main.numbers.get(0), main.numbers.get(0)).toString());

                    } else if (z == 3) {
                        System.out.println(complexCalculator.multiply(main.numbers.get(0), main.numbers.get(0)).toString());
                    } else if (z == 4) {
                        System.out.println(complexCalculator.devide(main.numbers.get(0), main.numbers.get(0)).toString());
                    }
                    break;
                case 2:
                    z = main.getRechenoperation();
                    main.numbers.clear();
                    main.numbers = main.getNumbers();
                    if (z == 1) {
                        System.out.println(rationalCalculator.add(main.numbers.get(0), main.numbers.get(0)).toString());
                    } else if (z == 2) {
                        System.out.println(rationalCalculator.sub(main.numbers.get(0), main.numbers.get(0)).toString());
                    } else if (z == 3) {
                        System.out.println(rationalCalculator.multiply(main.numbers.get(0), main.numbers.get(0)).toString());
                    } else if (z == 4) {
                        System.out.println(rationalCalculator.devide(main.numbers.get(0), main.numbers.get(0)).toString());
                    }
                    break;
                case 3:
                    z = main.getRechenoperation();
                    main.numbers.clear();
                    main.numbers = main.getNumbers();
                    if (z == 1) {
                        System.out.println(vectorCalculator.add(main.numbers.get(0), main.numbers.get(0)).toString());
                    } else if (z == 2) {
                        System.out.println(vectorCalculator.sub(main.numbers.get(0), main.numbers.get(0)).toString());
                    } else if (z == 3) {
                        System.out.println(vectorCalculator.multiply(main.numbers.get(0), main.numbers.get(0)).toString());
                    } else if (z == 4) {
                        System.out.println(vectorCalculator.devide(main.numbers.get(0), main.numbers.get(0)).toString());
                    }
                    break;
                case 4:
                    System.out.println("Vielen Dank für die Benutzung des Rechners von Morisch GmbH. Bitte beehren Sie uns bald wieder");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + des);
            }


        }while (z != 4) ;

    }
    public int getRechenoperation(){
        System.out.println("Welche Rechenoperation wollen sie durchführen?");
        System.out.println("1...addieren");
        System.out.println("2...subtrahieren");
        System.out.println("3...multiplizieren");
        System.out.println("4...dividieren");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public List<Number> getNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Number A a:");
        int aA = sc.nextInt();
        System.out.println("Number A b:");
        int aB = sc.nextInt();
        System.out.println("Number B a:");
        int bA = sc.nextInt();
        System.out.println("Number B b:");
        int bB = sc.nextInt();
        Number n1 = new Number(aA, aB);
        Number n2 = new Number(bA, bB);
        numbers = new ArrayList<>();
        numbers.add(n1);
        numbers.add(n2);
        return numbers;


    }


}
