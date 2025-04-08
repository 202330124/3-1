import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ObjectInputFilter;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        Greeter greeter1 = context.getBean("greeter", Greeter.class);
        // String msg = greeter.greet1("Hello");
        Greeter greeter2 = context.getBean("greeter", Greeter.class);

        // System.out.println(msg);

        System.out.println(greeter1 == greeter2);
    }
}