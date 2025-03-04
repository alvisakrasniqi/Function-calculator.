import org.junit.Test;
import static org.junit.Assert.*;

//this JUnit class is testing the BinaryOp Class
public class BinaryOpTest {

 // Test the value method for addition
  @Test
  public void testValueAddition() {
    
    Function leftOperand = new Number(5);
    Function rightOperand = new Number(3);
    
    //create a BinaryOp intance with the PLUS operation from binaryop
    BinaryOp addition = new BinaryOp(BinaryOp.Op.PLUS, leftOperand, rightOperand);

    double input = 0.0; // an intial input value
    double result = addition.value(input);
    assertEquals(8.0, result, 0.00001);
  }
  
  //test value for subtraction
    @Test
    public void testValueSubtraction() {
        Function leftOperand = new Number(10);
        Function rightOperand = new Number(5);
        BinaryOp subtraction = new BinaryOp(BinaryOp.Op.SUB, leftOperand, rightOperand);

        double result = subtraction.value(0); // Providing an input value (0 in this case)
        assertEquals(5.0, result, 0.00001);
    }

  //test value for multiplication 
    @Test
    public void testValueMultiplication() {
        Function leftOperand = new Number(6);
        Function rightOperand = new Number(4);
        BinaryOp multiplication = new BinaryOp(BinaryOp.Op.MULT, leftOperand, rightOperand);

        double result = multiplication.value(0); // Providing an input value (0 in this case)
        assertEquals(24.0, result, 0.00001);
    }

    //test value for division
    @Test
    public void testValueDivision() {
        Function leftOperand = new Number(15);
        Function rightOperand = new Number(3);
        BinaryOp division = new BinaryOp(BinaryOp.Op.DIV, leftOperand, rightOperand);

        double result = division.value(0); // Providing an input value (0 in this case)
        assertEquals(5.0, result, 0.00001);
    }
  
    // Test division by zero
    @Test(expected = ArithmeticException.class)
    public void testValueDivisionByZero() {
        Function leftOperand = new Number(10);
        Function rightOperand = new Number(0); // Division by zero
        BinaryOp division = new BinaryOp(BinaryOp.Op.DIV, leftOperand, rightOperand);

        division.value(10); 
    }
    
    //test derivitave when there is a plus
    @Test
    public void testDerivativePlus() {
      
      //Create a BinaryOp instance with PLUS operation, left operand 10, and right operand 13
        Function leftOperand = new Number(10);
        Function rightOperand = new Number(13);
        BinaryOp addition = new BinaryOp(BinaryOp.Op.PLUS, leftOperand, rightOperand);

        Function derivative = addition.derivative();
        assertTrue(derivative instanceof BinaryOp);
        assertEquals(BinaryOp.Op.PLUS, ((BinaryOp) derivative).getOperator());
        assertTrue(((BinaryOp) derivative).getLeftOperand() instanceof Number);
        assertTrue(((BinaryOp) derivative).getRightOperand() instanceof Number);
    }
    
    //test derivative for subtraction
    @Test
    public void testDerivativeMinus() {
      
     // Create a BinaryOp instance with SUB operation, left operand 10, and right operand 5
        Function leftOperand = new Number(10);
        Function rightOperand = new Number(5);
        BinaryOp subtraction = new BinaryOp(BinaryOp.Op.SUB, leftOperand, rightOperand);

        Function derivative = subtraction.derivative();
        assertTrue(derivative instanceof BinaryOp);
        assertEquals(BinaryOp.Op.SUB, ((BinaryOp) derivative).getOperator());
        assertTrue(((BinaryOp) derivative).getLeftOperand() instanceof Number);
        assertTrue(((BinaryOp) derivative).getRightOperand() instanceof Number);
    }
   
     // Test the derivative method for multiplication
    @Test
    public void testDerivativeMultiplication() {
      
        //Create a BinaryOp instance with MULT operation, left operand as a variable, and right operand 5
        Function leftOperand = new Variable();
        Function rightOperand = new Number(5);
        BinaryOp multiplication = new BinaryOp(BinaryOp.Op.MULT, leftOperand, rightOperand);

        Function derivative = multiplication.derivative();
        assertTrue(derivative instanceof BinaryOp);

        BinaryOp derivativeBinaryOp = (BinaryOp) derivative;
        assertEquals(BinaryOp.Op.PLUS, derivativeBinaryOp.getOperator());
        assertTrue(derivativeBinaryOp.getLeftOperand() instanceof BinaryOp);
        assertTrue(derivativeBinaryOp.getRightOperand() instanceof BinaryOp);
    }
    
    //test derivative for division
      @Test
      public void testDerivativeDivision() {
        
        //Create a BinaryOp instance with DIV operation, left operand 12, and right operand as a variable
        Function leftOperand = new Number(12);
        Function rightOperand = new Variable();
        BinaryOp division = new BinaryOp(BinaryOp.Op.DIV, leftOperand, rightOperand);

        Function derivative = division.derivative();
        assertTrue(derivative instanceof BinaryOp);
        assertEquals(BinaryOp.Op.DIV, ((BinaryOp) derivative).getOperator());
        assertTrue(((BinaryOp) derivative).getLeftOperand() instanceof BinaryOp);
        assertTrue(((BinaryOp) derivative).getRightOperand() instanceof BinaryOp);
    }

   // Test the toString method
    @Test
    public void testToString() {
      
      //Create a BinaryOp instance with SUB operation, left operand as a variable, and right operand 8
      Function leftOperand = new Variable();
      Function rightOperand = new Number(8);
      BinaryOp subtraction = new BinaryOp(BinaryOp.Op.SUB, leftOperand, rightOperand);

      String result = subtraction.toString();
      assertEquals("x - 8", result); //
    }
    
    // Test the equals method
    @Test
    public void testEquals() {
      
      //Create two BinaryOp instances with the same operation and operands
        Function leftOperand1 = new Number(6);
        Function rightOperand1 = new Number(5);
        BinaryOp addition1 = new BinaryOp(BinaryOp.Op.PLUS, leftOperand1, rightOperand1);

        Function leftOperand2 = new Number(6);
        Function rightOperand2 = new Number(5);
        BinaryOp addition2 = new BinaryOp(BinaryOp.Op.PLUS, leftOperand2, rightOperand2);

        assertTrue(addition1.equals(addition2));
    }
}

