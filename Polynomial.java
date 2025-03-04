/**
 *Represents a polynomial function with an operand and power
 *
 * @author Alvisa Krasniqi
 * 
 */ 
public class Polynomial implements Function {
  
  // Represents a function for the operand of the polynomial
  private Function operand;
  
  //Represents the power that the polynomial is being raised to
  private double power;
  
  /**
   * Constructs a Polynomial with operand and power
   *
   * @param operand The operand of the polynomial function
   * @param power   The power of the polynomial function
   */
  public Polynomial(Function operand, double power) {
    this.operand = operand;
    this.power = power;
  }
  
  /**
   * Gets the power of the polynomial function.
   *
   * @return The power of the polynomial function.
   */
  public double getPower() {
    return power;
  }

  /**
   * Gets the operand of the polynomial function
   *
   * @return The operand of the polynomial function
   */
  public Function getOperand() {
    return operand;
  }
    
  @Override
  public double value(){
    throw new UnsupportedOperationException("Polynomial value without input v is a not supported opperation");
  }

   /**
    * Computes the value of the polynomial function for a specific input
    *
    * @param input The input value for the polynomial function
    * @return The computed value of the polynomial function
    */
  @Override
  public double value(double input) {
    return Math.pow(operand.value(input), power);
  } 
    
  /**
   * Computes the derivative of the polynomial function
   *
   * @return The derivative function of the polynomial
   */
  @Override
  public Function derivative() {
    // The mathematical formula for a derivative of a polynomial: n * x^(n-1)
    double newPower = power - 1;
    Function newOperand = new Polynomial(operand.derivative(), newPower);
    return newOperand;
  }
    
  /**
   * Returns the string representation of the polynomial function
   *
   * @return The string representation of the polynomial function
   */
  @Override
  public String toString() {
    String operandStr = operand instanceof BinaryOp ?
      "(" + operand.toString() + ")" : operand.toString();
    return operandStr + "^" + power;
  }
    
  /**
   * Compares this polynomial function with the object to see if they are equal
   *
   * @param obj The object that the polynomial is being compared to
   * @return True if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    
    // Check if the object references are the same
    if (this == obj) {
      return true;
    }
    // Check if the object is null or not an instance of polynomial class
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    
    // Cast the object to a Polynomial
    Polynomial polynomial = (Polynomial) obj;
    
    //Compare the two polynomial's power
    return Double.compare(polynomial.power, power) == 0 &&
      operand.equals(polynomial.operand);
  }
  
}

