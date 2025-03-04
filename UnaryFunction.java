import static java.util.Objects.requireNonNull;

/**
 * Abstract class represents a unary function that operates on a single operand.
 * The operand is a required parameter 
 *
 * @author Alvisa Krasniqi
 */
public abstract class UnaryFunction implements Function {
  
    /** The operand of the unary function. */
    final protected Function operand;

    /**
     * Constructs a UnaryFunction with the specified operand
     *
     * @param operand The operand of the unary function
     * @throws NullPointerException If the operand is null
     */
    public UnaryFunction(Function operand) {
        this.operand = requireNonNull(operand);
    }
    
    /**
     * Retrieves the operand of the unary function
     *
     * @return The operand of the unary function
     */    
    public Function getOperand() {
        return operand;
    }
    
    /**
     * determines the unary function's value
     * UnsupportedOperationException is thrown by this method because unary functions need an input value
     * @return The computed value of the unary function
     * @throws UnsupportedOperationException If the unary function does not support value computation without input
     */
    @Override
    public double value() {
        throw new UnsupportedOperationException("This requires an input value.");
    }
    
    /**
     *  Computes the value of the unary function for the given input
     * The UnsupportedOperationException exception is thrown by this method because unary functions do not accept input values
     * @param input The input value for the unary function 
     * @return The value of the unary function
     * @throws UnsupportedOperationException If the unary function does not support the value of the input
     */
    @Override
    public double value(double input) {
        throw new UnsupportedOperationException("Unary functions do not support input values.");
    }
    
    /**
     * Computes the derivative of the unary function.
     * This method throws UnsupportedOperationException because the derivative of a unary function is not implemented.
     *
     * @return The derivative function of the unary function.
     * @throws UnsupportedOperationException If the derivative operation is not supported
     */
    @Override
    public Function derivative() {
        throw new UnsupportedOperationException("Derivative of a unary function is not implemented.");
    }
    
    /**
     * Returns a string representation of the unary function
     *
     * @return A string representing the unary function
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + operand.toString() + "]";
    }
}
