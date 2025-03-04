import org.junit.Test;
import static org.junit.Assert.*;

//this JUnit class is testing the Log Class
public class LogTest{
   
  //testing the testValue method for log
  @Test
   public void testValue() {
    Function operand = new Number(10); 
    Log log = new Log(operand); // this is creating a log object with the operand
    
    double result = log.value(2); //calculate the log value at 2
    assertEquals(Math.log(10), result, 0.0001);
    }
  
  
  //testinf the derivative method
    @Test
    public void testDerivative() {

        Function operand = new Variable();
        Log log = new Log(operand);

        // derivative of the logarithm function
        Function result = log.derivative();

        assertNotNull(result);

        // check if the result is an instance of BinaryOp
        assertTrue(result instanceof BinaryOp);

        // cast the result
        BinaryOp binaryOp = (BinaryOp) result;

        // check if the operator is DIV
        assertEquals(BinaryOp.Op.DIV, binaryOp.getOperator());

        // check if the left operand of the BinaryOp is 1.0
        assertTrue(binaryOp.getLeftOperand() instanceof Number);
        assertEquals(1.0, ((Number) binaryOp.getLeftOperand()).value(), 0.0001);

        // check whether the right operand is the derivative of the operand of the logarithmic function
        Function operandDerivative = operand.derivative();
        assertEquals(operandDerivative, binaryOp.getRightOperand());
    }
  
  
  //test the tostring method
    @Test
    public void testToString() {
        Function operand = new Variable();
        Log log = new Log(operand);

        String result = log.toString();

        assertEquals("log(x)", result);
    }
  
  
  //test the equals method
  @Test
    public void testEquals() {
        Function operand1 = new Variable();
        Function operand2 = new Variable();
        Log log1 = new Log(operand1);
        Log log2 = new Log(operand2);

        assertTrue(log1.equals(log2)); 
    }
  
 
  

}