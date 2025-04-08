package function;

public class CalAssembler {
    MyCalculator myCalculator;
    CalAdd calAdd;
    CalSub calSub;
    CalMul calMul;
    CalDiv calDiv;

    public CalAssembler() {
        myCalculator = new MyCalculator();
        calAdd = new CalAdd();
        calSub = new CalSub();
        calMul = new CalMul();
        calDiv = new CalDiv();
    }

    public void assemble() {
        myCalculator.calculator(7, 5, calAdd);
        myCalculator.calculator(10, 5, calSub);
        myCalculator.calculator(10, 5, calMul);
        myCalculator.calculator(10, 5, calDiv);
    }
}