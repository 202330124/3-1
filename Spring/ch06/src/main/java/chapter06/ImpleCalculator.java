package chapter06;

public class ImpleCalculator implements Calculator {
    @Override
    public long factorial(int n) {
        // long start = System.currentTimeMillis();
        long result = 1;

        for(long i = 1; i <= n; i++) {
            result *= i;
        }

        // long end = System.currentTimeMillis();
        // System.out.printf("ImpleCalculator.Factorial(%d) 실행시간: %d \n", n, (end - start));

        return result;
    }
}