package chapter06;

public class ExeTimeCalculator implements Calculator {
    private Calculator delegate;

    public ExeTimeCalculator(Calculator calculator) {
        this.delegate = calculator;
    }

    @Override
    public long factorial(int n) {
        long start = System.nanoTime();
        long result = delegate.factorial(n);
        long end = System.nanoTime();

        System.out.printf("Factorial(%d) 실행시간: %d \n", n, (end - start));

        return result;
    }
}