/**
 * Represents a logarithm function that operates on a single operand
 * This class extends UnaryFunction, inheriting its behavior 
 *
 * @author Alvisa Krasniqi
 */

public class Log extends UnaryFunction {

    /**
     * Constructs a Log object with specified operand
     *
     * @param op The operand of the logarithm function
     */
    public Log(Function op) {
        super(op);
    }
    
    
    /**
     * Computes the logarithm's value based on the input
     * This method calculates the natural logarithm (base e) of the operand's value.
     *
     * @param input The input value for the logarithm function.
     * @return The computed value of the logarithm function.
     */
    @Override
    public double value(double input) {
        return Math.log(getOperand().value(input));
    }
    
    /**
     * Computes the logarithm function's derivative
     *
     * @return The derivative function of the logarithm function.
     */
    @Override
    public Function derivative() {
        // Derivative of log(x) is 1 / x
        return new BinaryOp(BinaryOp.Op.DIV, new Number(1), getOperand().derivative());
    }

    /**
     * Returns a string representation of the logarithm function
     *
     * @return A string representing the logarithm function
     */
    @Override
    public String toString() {
        return "log(" + getOperand().toString() + ")";
    }

    /**
     * this checks if this logarithm function is equal to another object
     * Functions are considered equal if their operands are equal
     *
     * @param o The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log)) return false;
        Log abs = (Log) o;
        return getOperand().equals(abs.getOperand());
    }
}

 
