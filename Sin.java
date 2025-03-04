/**
 * Represents a sine function that operates on a single operand
 * This class extends UnaryFunction, inheriting its behavior 
 *
 * @author Alvisa Krasniqi
 */
public class Sin extends UnaryFunction {
  
  /**
   * Constructs a sin function with the specified operand
   *
   * @param operand The operand of the sine function
   */
    public Sin(Function operand) {
        super(operand);
    }
    
    /**
     * Computes the value of the sine function for the given input
     *
     * @param input The input value for the sine function
     * @return The computed value of the sine function
     */ 
    @Override
    public double value(double input) {
        return Math.sin(getOperand().value(input));
    }
    
    /**
     * Computes the derivative of the sine function
     *
     * @return The derivative of sine
     */
    @Override
    public Function derivative() {
        // Derivative of sin(x) is cos(x)
        return new BinaryOp(BinaryOp.Op.MULT, new Cos(getOperand()), getOperand().derivative());
    }
     
    /**
     * Returns a string representation of sine functionm
     *
     * @return A string representing sine function
     */
    @Override
    public String toString() {
        return "Sin[" + getOperand().toString() + "]";
    }

    /**
     * Checks if this sine function is equal to another object
     *
     * @param obj The object it compares the sine function to 
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Sin)) return false;
        Sin sin = (Sin) obj;
        return getOperand().equals(sin.getOperand());
    }
}
