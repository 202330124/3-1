package chapter06;

import config.AppContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        Calculator calculator = context.getBean("calculator", Calculator.class);
        long result = calculator.factorial(3);
        System.out.println(result);
        System.out.println(calculator.getClass().getSimpleName());

        context.close();
    }
}