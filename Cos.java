/**
 * Represents a sine function that operates on a single operand
 * This class extends UnaryFunction, inheriting its behavior 
 *
 * @author Alvisa Krasniqi
 */
public class Cos extends UnaryFunction {
  
   /**
     * Constructor os function with the specified operand
     * @param operand The operand function for the cosine function
     */
    public Cos(Function operand) {
        super(operand);
    }

    /**
     * Computes the value of the cos function for the given input
     *
     * @param input The input value for the cos function
     * @return The computed value of the cos function
     */ 
    @Override
    public double value(double input) {
        return Math.cos(getOperand().value(input));
    }
    
    
    /**
     * Computes the derivative of cos function
     *
     * @return The derivative of cos
     */
    
    @Override
    public Function derivative() {
        // derivative of cos(X) is -sin(x)
        return new UnaryFunction(getOperand()) {
            @Override
            public double value(double input) {
                return -Math.sin(getOperand().value(input));
            }

            @Override
            public Function derivative() {
                // derivative of -sin(x) is cos(x)
                return new Cos(getOperand()).derivative();
            }

        @Override
        public String toString() {
            return "-Sin[" + getOperand().toString() + "]";
        }
    };
  }

    
    /**
     * Returns a string representation of the cosine function.
     *
     * @return A string representing the cosine function.
     */
    @Override
    public String toString() {
        return "Cos[" + getOperand().toString() + "]";
    }
    
    /**
     * Checks if this cosine function is equal to another function
     *
     * @param obj The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cos)) return false;
        Cos cos = (Cos) obj;
        return getOperand().equals(cos.getOperand());
    }
}
