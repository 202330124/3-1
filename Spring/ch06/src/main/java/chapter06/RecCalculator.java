package chapter06;

public class RecCalculator implements Calculator {
    @Override
    public long factorial(int n) {
        // long start = System.currentTimeMillis();
        try {
            if(n == 0) {
                return 1;
            }

            else {
                return n * factorial(n-1);
            }
        }

        finally {
            // long end = System.currentTimeMillis();
            // System.out.printf("RecCalculator.Factorial(%d) 실행시간: %d \n", n, (end - start));
        }
    }
}