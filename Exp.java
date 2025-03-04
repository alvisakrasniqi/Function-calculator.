/**
 * Class represents an exponential function that operates on a single operand
 * This function calculates e raised to the power of the operand value
 * This class extends UnaryFunction, inheriting its behavior 
 *
 * @author Alvisa Krasniqi
 */
public class Exp extends UnaryFunction{
  
  /**
   * Constructs an exponential function object with the specified operand
   *
   * @param op The operand of the exponential function
   */
  public Exp(Function op) {
    super(op);
  }
  
  /**
   * Computes the value of the exponential function for the given input
   *
   * @param input The input value for the exponential function
   * @return The computed value of the exponential function
   */
  @Override
  public double value(double input){
    return Math.exp(getOperand().value(input));
  }
  
  /**
   * Computes the derivative of the exponential function, which doesnt change
   *
   * @return The derivative function of the exponential function
   */
  @Override
  public Function derivative() {
   // Derivative of exp(x) is exp(x)
    return new BinaryOp(BinaryOp.Op.MULT, new Exp(getOperand()), getOperand().derivative());
    }
       
  /**
   * Returns a string representation of the exponential function
   *
   * @return A string representing the exponential function
   */
  @Override
  public String toString() {
    return "Exp[" + getOperand().toString() + "]";
    }
  
  /**
   * Checks if this exponential function is eual to another one
   *
   * @param obj The object to compare it with 
   * @return True if the objects are equal, false otherwise
   */
   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Exp)) return false;
        Exp exp = (Exp) obj;
        return getOperand().equals(exp.getOperand());
    }

}
  