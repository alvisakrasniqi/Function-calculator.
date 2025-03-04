import org.junit.Test;
import static org.junit.Assert.*;

//this JUnit class is testing the Polynomail Class
public class PolynomialTest {
  
  //check the getOperand method
  @Test
  public void testGetOperand() {
    Function operand = new Number(2);
    Polynomial polynomial = new Polynomial(operand, 4);

    Function result = polynomial.getOperand();

    // this checks whether the result is not null
    assertNotNull(result);
    // this checks whether the result is an instance of Number
    assertTrue(result instanceof Number);
    // it checks whether the value of the Number matches the operand
    assertEquals(2.0, ((Number) result).value(), 0.0001);
    }
  
  // test for the value method without input
  @Test(expected = UnsupportedOperationException.class)
  public void testValueWithoutInput() {
    Function operand = new Number(2);
    Polynomial polynomial = new Polynomial(operand, 3);

    polynomial.value();
    }
  
  //test for the value method with an input
   @Test
   public void testValue() {
     Function operand = new Number(2); 
     Polynomial polynomial = new Polynomial(operand, 4);

        double result = polynomial.value(2);
        assertEquals(16.0, result, 0.0001);
    }
   
   //test derivative for the polynomials
   @Test
   public void testDerivative(){
     //create testOperand and polynomial
        Function testOperand = new Number(5);
        Polynomial polynomial = new Polynomial(testOperand, 3);

        // calculate the derivative of the Polynomial
        Function result = polynomial.derivative();

        assertNotNull(result); 
        assertTrue(result instanceof Polynomial);
     
   }
   
   // test the toString method
   @Test
   public void testToString() {
    Function operand = new Number(2);
    Polynomial polynomial = new Polynomial(operand, 4);

    String result = polynomial.toString();
    assertEquals("2.0^4.0", result); 
   }
   
     // test the equal method
    @Test
    public void testEquals() {
        Function operand1 = new Number(2);
        Polynomial polynomial1 = new Polynomial(operand1, 3);

        Function operand2 = new Number(2);
        Polynomial polynomial2 = new Polynomial(operand2, 3);

        assertTrue(polynomial1.equals(polynomial2));
    }  
}
   