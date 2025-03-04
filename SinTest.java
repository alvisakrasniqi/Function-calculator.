import static org.junit.Assert.*;
import org.junit.Test;

//this JUnit class is testing the Sin Class
public class SinTest {
  
  //test the value method for sin 
   @Test
    public void testValue() {
     
        // create a variable operand
        Function operand = new Variable();

        // create a sine function with the variable operand
        Sin sin = new Sin(operand);

        // calculate the value of the sine function for 0
        double result = sin.value(0); 

        // check the result is equal to the expected value of 0
        assertEquals(0.0, result, 0.0001);
    }
   
   //test the derivative method
   @Test
   public void testDerivative() {
    // create a variable operand
     Function operand = new Variable();

    // create a sine function with the variable operand
     Sin sin = new Sin(operand);

     // calculate the derivative of sine
     Function result = sin.derivative();

     //checks result of the derivative is not null
     assertNotNull(result);

     // checks if the result is an instance of BinaryOp
     assertTrue(result instanceof BinaryOp);

     // casts the result to BinaryOp 
     BinaryOp binaryOp = (BinaryOp) result;

     // check whether the operator of the BinaryOp is MULT
     assertEquals(BinaryOp.Op.MULT, binaryOp.getOperator());

     // check if the left operand of BinaryOp is cosine func
     assertTrue(binaryOp.getLeftOperand() instanceof Cos);

     // check if the right operand is derivative of sine function
     Function operandDerivative = operand.derivative();
     assertEquals(operandDerivative, binaryOp.getRightOperand());
   }
   
   
   //test the toString method
    @Test
    public void testToString() {
        // create a variable operand
        Function operand = new Variable();

        // create a sine function with the variable operand
        Sin sin = new Sin(operand);

        // check if sine function's string representation is as intended
        assertEquals("Sin[x]", sin.toString());
    }
   
    //test the equals method
    @Test 
    public void testEquals() {
        // create two variable operand
        Function operand1 = new Variable();
        Function operand2 = new Variable();

        // create two sine functions 
        Sin sin1 = new Sin(operand1);
        Sin sin2 = new Sin(operand2);

        //check whether the two sine functions are equal
        assertTrue(sin1.equals(sin2));
    }
    
}