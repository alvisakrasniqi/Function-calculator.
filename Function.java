/**
 * This is an interface which represent whether a function can be evaluated and differentiated.
 *
 * @author Alvisa Krasniqi
 * 
 */ 
public interface Function{
  
 /**
  * Computes the value of the function without any input.
  *
  * @return The value of the function.
  */
  double value();
 
  /**
   * Computes the value of the function with the specified input.
   *
   * @param input The input value for the function.
   * @return The value of the function at the specified input.
   */
  double value(double input);
 
  /**
   * Computes the derivative of the function.
   *
   * @return The derivative function of the current function.
   */
  Function derivative();
  
}