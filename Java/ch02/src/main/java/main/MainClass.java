package main;

import chapter02.TransportationWalk;
import function.CalAssembler;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        /*
        TransportationWalk transportationWalk = ctx.getBean("tWalk", TransportationWalk.class);
        transportationWalk.move();
        */

        CalAssembler calAssembler = ctx.getBean("calAssembler", CalAssembler.class);
        calAssembler.assemble();

        ctx.close();
    }
}