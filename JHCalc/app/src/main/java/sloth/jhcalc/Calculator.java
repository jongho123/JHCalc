package sloth.jhcalc;

/**
 * Created by sloth0 on 2015-03-08.
 */
public class Calculator {
    private int var1;
    private int var2;

    public Calculator(int num1, int num2) {
        var1 = num1;
        var2 = num2;
    }

    public int plus() { return var1 + var2; }

    public int minus() {
        return var1 - var2;
    }

    public int multiply() {
        return var1 * var2;
    }

    public float division() {
        return (float)var1 / var2;
    }
}
