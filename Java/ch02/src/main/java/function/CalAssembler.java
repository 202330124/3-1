package function;

public class CalAssembler {
    MyCalculator myCalculator;
    CalAdd calAdd;
    CalSub calSub;
    CalMul calMul;
    CalDiv calDiv;

    public CalAssembler(MyCalculator myCalculator, CalAdd calAdd, CalSub calSub, CalMul calMul, CalDiv calDiv) {
        this.myCalculator = myCalculator;
        this.calAdd = calAdd;
        this.calSub = calSub;
        this.calMul = calMul;
        this.calDiv = calDiv;
    }

    public void assemble() {
        myCalculator.calculator(7, 5, calAdd);
        myCalculator.calculator(10, 5, calSub);
        myCalculator.calculator(10, 5, calMul);
        myCalculator.calculator(10, 5, calDiv);
    }
}