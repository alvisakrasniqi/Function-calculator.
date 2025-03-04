/**
 * Represents a constant number in a mathematical function 
 * The constructor takes a single double value 
 * The toString method represents the number as a String
 * The equals method compares the two number values
 * 
 * @author Alvisa Krasniqi
 */
public class Number implements Function {
  
   //A field storing a double value
    private double value;

    /**
     * Constructs a Number with the double value.
     * 
     * @param value The constant number value.
     */
    public Number(double value) {
        this.value = value;
    }
    
    /**
     * Returns a constant number value for any input.
     * 
     * @param input parameter is not used for any computation 
     * @return The constant number value.
     */
    @Override
    public double value(double input) {
        return value;
    }

   /**
     * Returns the constant Number value without taking an input
     * 
     * @return The constant Number value.
     */
    @Override
    public double value() {
        return value;
    }
    
   /**
     * Returns A Number with a constant derivative of 0.
     * 
     * @return A Number with 0 as a constant value.
     */
    @Override
    public Function derivative() {
        return new Number(0);
    }
    

    /**
     * Returns the String representation of the constant number value
     * 
     * @return The String representation of the constant number value
     */
    @Override
    public String toString() {
        return Double.toString(value);
    }
    
    /**
     * Compares this Number object to another object
     * Returns true if otheer object is a Number object with the same value
     * 
     * @param obj The object to compare
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj){
      if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Number number = (Number) obj;
        return Double.compare(number.value, value) == 0;
    }
}

