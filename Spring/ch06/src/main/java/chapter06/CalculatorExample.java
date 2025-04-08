package chapter06;

public class CalculatorExample {
    public static void main(String[] args) {
        /*
        long start1 = System.currentTimeMillis();
        ImpleCalculator impleCalculator = new ImpleCalculator();
        impleCalculator.factorial(4);
        long end1 = System.currentTimeMillis();
        System.out.println("ImpleCalculator Factorial: " + (end1 - start1) + "ms\n");

        long start2 = System.currentTimeMillis();
        RecCalculator recCalculator = new RecCalculator();
        recCalculator.factorial(4);
        long end2 = System.currentTimeMillis();
        System.out.println("RecCalculator Factorial: " + (end2 - start2) + "ms\n");
        */

        ExeTimeCalculator calculator1 = new ExeTimeCalculator(new ImpleCalculator());
        System.out.println(calculator1.factorial(20));

        ExeTimeCalculator calculator2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(calculator2.factorial(20));
    }
}