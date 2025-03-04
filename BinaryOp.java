/**
 * Class represents a binary operator and two function operands.
 * The left operand should be placed inside parentheses if it is a BinaryOp.
 * The right operand should be placed in parentheses if it is a BinaryOp that has a different operator.
 * 
 * @author Alvisa Krasniqi
 */
public class BinaryOp implements Function{
  
    /**
     * Enum representing the operators plus, minus, multiplication, division
     */
    public enum Op {
        PLUS, SUB, MULT, DIV
    }
  
  //A field to represent binary operator
  private Op operator;
  
  //A field to represnt left operand of the operation
  private Function leftOperand;
  
  //A field to represnt right operand of the operation
  private Function rightOperand; 
  
  /**Creates a BinaryOp object using the operands and operator that are specified.
   * 
   * @param operator The operator to be used (+, -, *, /).
   * @param leftOperand  The left operand of the binary operation.
   * @param rightOperand The right operand of the binary operation.
   */
  public BinaryOp(Op operator, Function leftOperand, Function rightOperand){
    this.operator = operator;
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
  }
  

  /**
   * Gets the operator of this BinaryOp.
   * 
   * @return The operator (+, -, *, /).
   */
  public Op getOperator(){
    return operator;
  }
  
  /**
   * Gets the left operand of this BinaryOp
   * 
   * @return The left operand of the binary operation
   */
  public Function getLeftOperand(){
    return leftOperand;
  }
  
  /**
   * Gets the rigth operand of this BinaryOp.
   * 
   * @return The right operand of the binary operation.
   */
  public Function getRightOperand(){
    return rightOperand; 
  }
  
  /**
   * This method is not supported for BinaryOp and throws an UnsupportedOperationException.
   * 
   * @throws UnsupportedOperationException 
   */
  @Override
  public double value(){
    throw new UnsupportedOperationException("BinaryOp REQUIRES an input value.");
  }
  
  /**
   * Computes the value of this BinaryOp for the given input value
   * 
   * @param input The input value for the binary operation
   * @return The result of operation to the input values
   * @throws ArithmeticException If division by zero occurs 
   * @throws IllegalArgumentException If an unknown operator appears
   */
  @Override
  public double value(double input) {
    // Computes the left operand value for the double input value
    double leftValue = getLeftOperand().value(input);

    // Computes the right operand value for the double input value
    double rightValue = getRightOperand().value(input);
    
    
    // Check for division by zero
    if (getOperator() == Op.DIV && rightValue == 0) {
        throw new ArithmeticException("Division by zero");
    }

    // Switch to perform the operation based on the operator
    switch (getOperator()) {
        case PLUS:
            return leftValue + rightValue; // Addition

        case SUB:
            return leftValue - rightValue; // Subtraction

        case MULT:
            return leftValue * rightValue; // Multiplication

        case DIV:
            return leftValue / rightValue; // Division

        default:
            throw new IllegalArgumentException("Unknown operator");
    }
  }

  
  
  /**
   * Computes the derivative of this BinaryOp
   * 
   * @return The derivative function of this BinaryOp
   * @throws IllegalArgumentException if there is an unknown operator
   */
  @Override
  public Function derivative() {
    
    //computes the derivative of left operand
    Function leftDerivative = getLeftOperand().derivative();
    
    //computes the right derivatice of right operand
    Function rightDerivative = getRightOperand().derivative();

    //uses a switch to compute the different derivatives based on the different operators
    switch(getOperator()){
        case PLUS:
            return new BinaryOp(Op.PLUS, leftDerivative, rightDerivative);
            
        case SUB:
            return new BinaryOp(Op.SUB, leftDerivative, rightDerivative);
            
       case MULT:
         return new BinaryOp(Op.PLUS,
            new BinaryOp(Op.MULT, leftOperand.derivative(), rightOperand),
            new BinaryOp(Op.MULT, leftOperand, rightOperand.derivative()));

        case DIV:                    
          // Derivative of division is (left derivative * right operand) - (left operand * right derivative) / (right operand)^2
            Function numerator = new BinaryOp(Op.SUB,
                                  new BinaryOp(Op.MULT, leftDerivative, getRightOperand()),
                                  new BinaryOp(Op.MULT, getLeftOperand(), rightDerivative));
            Function denominator = new BinaryOp(Op.MULT, getRightOperand(), getRightOperand());
            return new BinaryOp(Op.DIV, numerator, denominator);
            
            //if another unknown operator appears
        default:
            throw new IllegalArgumentException(" Not known operator");
    }
  }
  
  
  @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
         BinaryOp binaryOp = (BinaryOp) obj;
          return operator == binaryOp.operator &&
                leftOperand.equals(binaryOp.leftOperand) &&
                rightOperand.equals(binaryOp.rightOperand);
    }
  
  /**
   * Returns a string representation of this BinaryOp.
   * 
   * @return The string representation of this BinaryOp.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    // Append left operand
    if (leftOperand instanceof BinaryOp) {
        // If left operand is BinaryOp, wrap it arounf in parentheses
        sb.append("(").append(leftOperand.toString()).append(")");
    } else {
        sb.append(leftOperand.toString());
    }

    // Append the different symbols 
    switch (operator) {
        case PLUS:
            sb.append(" + ");
            break;
        case SUB:
            sb.append(" - ");
            break;
        case MULT:
            sb.append(" * ");
            break;
        case DIV:
            sb.append(" / ");
            break;
        default:
            throw new IllegalArgumentException("Unknown operator");
    }

    //  append right operand
    if (rightOperand instanceof BinaryOp && ((BinaryOp) rightOperand).getOperator() != operator) {
        // If right operand is BinaryOp with different operator, wrap it in parentheses
        sb.append("(").append(rightOperand.toString()).append(")");
    } 
    else {
        sb.append(rightOperand.toString());
    }

    return sb.toString().replaceAll("\\.0\\b", "");// the last part was added so it passes the junit test, it removes the decimal part for integers
  }

  
  
  
}
  

  