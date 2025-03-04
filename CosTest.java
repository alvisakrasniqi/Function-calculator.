import static org.junit.Assert.*;
import org.junit.Test;

//this JUnit class is testing the Cos class
public class CosTest {
  
  // this tests the method value
  @Test
  public void testValue() {
    //create a new variable operand
    Function operand = new Variable();

    //create a cosine function 
    Cos cos = new Cos(operand);
          
     //calculate the value of the cosine function for 0
      double result = cos.value(0.0); 
      
    //check if the result is equal to the expected value of 1 since cos of 0 is 1
    assertEquals(1.0, result, 0.0001);
    }
  
  // Test derivative calculation
    @Test
    public void testDerivative() {
        Function operand = new Variable(); 
        Cos cosFunction = new Cos(operand);
        Function derivative = cosFunction.derivative();

        // Test for various input values
        double result1 = derivative.value(0); // -sin(0) = 0
        double result2 = derivative.value(Math.PI / 2); // -sin(pi/2) = -1
        double result3 = derivative.value(Math.PI); // -sin(pi) = 0

        assertEquals(0, result1, 0.0001);
        assertEquals(-1, result2, 0.0001);
        assertEquals(0, result3, 0.0001);
    }
        
  //test the toString method for the representation of cosine function
  @Test
  public void testToString() {
    
    // create a new variable operand
    Function operand = new Variable(); 

    // create a cos function 
    Cos cos = new Cos(operand);

    //check the string representation of cosine function
    assertEquals("Cos[" + operand.toString() + "]", cos.toString());
    }
     
  
  //check if the two cos functions are equal
  @Test
  public void testEquals() {
        // create tow variable operands
    Function operand1 = new Variable(); 
    Function operand2 = new Variable(); 

        // create cosine functions
        Cos cos1 = new Cos(operand1);
        Cos cos2 = new Cos(operand2);

        // check if the two cosine functions with different operands are equal
        assertTrue(cos1.equals(cos2));
    }  
}