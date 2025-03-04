/**
 * Represents the variable x.
 * The constructor takes no input.
 * The toString method gives "x".
 * The equals method returns true if this object is equal compared to another Variable.
 * 
 * @author Alvisa Krasniqi
 */
public class Variable implements Function {
  
   /**
     * Returns the input value for the variable function.
     * 
     * @param input The input value.
     * @return The input value itself.
     */
    @Override
    public double value(double input) {
        return input; // Simply returns the input value for the variable function
    }
    
    /**
     * Throws an UnsupportedOperationException because this operation is not supported.
     * 
     * @return UnsupportedOperationException
     * @throws UnsupportedOperationException always thrown.
     */
    @Override
    public double value() {
        throw new UnsupportedOperationException("This is a not supported opperation");
    }
        
    /**
     * Returns a constant of 1, as the derivative of a variable is 1.
     * 
     * @return A constant of 1.
     */
    @Override
    public Function derivative() {
        // The derivative of a variable is 1, so we return a constant representing 1
        return new Number(1);
    }

    /**
     * Provides the string "x" as the variable function's string representation.
     * 
     * @return The string "x".
     */
    @Override
    public String toString() {
        return "x"; // String representation of the variable 
    }
    
    /**
     * Checks if this object is equal to another Variable object.
     * 
     * @param obj Object which is being compared.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Variable variable = (Variable) obj;

    return true;
    
    }

}

