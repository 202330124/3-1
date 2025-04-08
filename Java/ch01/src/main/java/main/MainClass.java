package main;

import function.*;

public class MainClass {
    public static void main(String[] args) {
        /*
        MyCalculator myCalculator = new MyCalculator();
        myCalculator.calculator(10, 5, new CalAdd());
        myCalculator.calculator(10, 5, new CalSub());
        myCalculator.calculator(10, 5, new CalMul());
        myCalculator.calculator(10, 5, new CalDiv());
        */

        CalAssembler calAssembler = new CalAssembler();
        calAssembler.assemble();
    }
}