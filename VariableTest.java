import org.junit.Test;
import static org.junit.Assert.*;

//this JUnit class is the Variable Class
public class VariableTest {

    // Test for the double input method with input value 14.0
    @Test
    public void testValueWithInput() {
        //this creates a new instance of Variable
        Variable variable = new Variable();

        // Test the double input value method with input value 14.0
        double result = variable.value(14.0);
        assertEquals(14.0, result, 0.001);
    }

        // Test for the no input method
    @Test(expected = UnsupportedOperationException.class)
    public void testValueWithoutInput() {
        // this creates a new instance of Variable
        Variable variable = new Variable();

        // test the value method with no input throws UnsupportedOperationException
        variable.value();
    }
    

    // Test for the derivative method
    @Test
    public void testDerivative() {
      
        // create a new instance of Variable
        Variable variable = new Variable();

        // test the derivative method
        Function derivative = variable.derivative();
        assertNotNull(derivative);
        assertTrue(derivative instanceof Number); 
        assertEquals(1.0, derivative.value(5.0), 0.001); // number's value method returns the input value
    }

     // Test for the toString method 
    @Test
    public void testToString() {
        // Create a new instance of Variable
        Variable variable = new Variable();

        // test the toString method
        String result = variable.toString();
        assertEquals("x", result);
    }

    //test for the equals method
    @Test
    public void testEquals() {
        // Create two instances of Variable for comparison
        Variable variable1 = new Variable();
        Variable variable2 = new Variable();

        // test the equals method
        assertTrue(variable1.equals(variable2)); // Variables with the same class and no unique properties should be equal
    }
}
