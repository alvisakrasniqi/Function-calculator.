import org.junit.Test;
import static org.junit.Assert.*;

//this JUnit class is testing the Number Class
public class NumberTest {
  
  //test for the value method with a double input 
  @Test
  public void testValueWithInput() {
        // Create a number instance with value 9.0
        Number number = new Number(9.0);
        
        double result = number.value(8.0);//the value of the input should not affect the result of the method
        assertEquals(9.0, result, 0.001);//
  }
  
  
    // test for value method with no input
    @Test
    public void testValueWithoutInput() {
        // Create a numberinstacne with value 14.0
        Number number = new Number(14.0);

        // when the method without any input is called it should return the previous value storred of 14.0 
        double result = number.value();
        assertEquals(14.0, result, 0.001); // assert that the result is equal to 14.0 that has a tolerance of 0.001
    }
  
    //test case for the derivative method
    @Test
    public void testDerivative(){
      
      //create a number instance with value of 17.0
      Number number = new Number(17.0);
      
      Function derivative = number.derivative();
      assertNotNull(derivative);
      assertTrue(derivative instanceof Number);
      assertEquals(0.0, derivative.value(14.0), 0.001);//returns a constant value of 0
      
    }
    
      @Test
    public void testToString() {
        // create a new instance of Number with a value of 24.0
        Number number = new Number(24.0);

        // est the toString method and it should return "24.0"
        String result = number.toString();
        assertEquals("24.0", result);
    }
      
    //test for the equals method
    @Test
    public void testEquals(){
      
      Number number1 = new Number(3.0);
      Number number2 = new Number(3.0);
      
      //the equals method should return true for number1 and number2
      assertTrue(number1.equals(number2));
    
    }

  
}
  