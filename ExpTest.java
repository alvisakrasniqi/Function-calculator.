import org.junit.Test;
import static org.junit.Assert.*;

//this JUnit class is testing the Exp Class
public class ExpTest {
  
  //test the value method with double input
   @Test
    public void testValue() {

        //a new variable operand
        Function operand = new Variable();
       
        //new expontential function with operand as a variable
        Exp exp = new Exp(operand);
        
        //compute the value of the exponential function at 8
        double result = exp.value(8.0);

        assertEquals(Math.exp(8.0), result, 0.0001);
    }
   
    @Test
    public void testDerivative() {
        // create a new variable operand
        Function operand = new Variable();

        //new expontential function with operand as a variable
        Exp exp = new Exp(operand);

        // calculation of the derivative of exponential function
        Function result = exp.derivative();

        assertNotNull(result);

        // check whether the result is an instance of BinaryOp
        assertTrue(result instanceof BinaryOp);

        // cast the result
        BinaryOp binaryOp = (BinaryOp) result;

        // check if the operator of the BinaryOp is MULT
        assertEquals(BinaryOp.Op.MULT, binaryOp.getOperator());

        // check whether the left operand is an exponential function
        assertTrue(binaryOp.getLeftOperand() instanceof Exp);

        // check if the right operand is derivative of the operand of the exponential function
        Function operandDerivative = operand.derivative();
        assertEquals(operandDerivative, binaryOp.getRightOperand());
    }
    
    // test if the toString method works as intended for the exponential function
    @Test
    public void testToString() {
        // create a new variable operand
        Function operand = new Variable();

        // create an exponential function with the variable operand
        Exp exp = new Exp(operand);

        // check if the string representation of the exponential function is as expected to be
        assertEquals("Exp[x]", exp.toString());
    }
    
    //test the equals method to see if two exponential functions are equal
    @Test
    public void testEquals() {
        // create two variable operands
        Function operand1 = new Variable();
        Function operand2 = new Variable();

        // create two exponential functions that have the same variable operand
        Exp exp1 = new Exp(operand1);
        Exp exp2 = new Exp(operand2);

        // check if the two exponential functions are equal
        assertTrue(exp1.equals(exp2));
    }
    
    
    
   

  
}