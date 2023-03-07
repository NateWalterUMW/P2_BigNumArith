import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class multiplyTest {

	@Test
	public void validMultiplyTest() {
		LList num1 = new LList();
		LList num2 = new LList();
		
		// case: "0 *" --> tests when one number is empty
		// this should return "0"
		num1.insert(0);
		assertEquals(null, BigNumArithmetic.multiply(num1, num2));
		num1.clear();
		
		// case: "0 3 *"
		// this should return "0"
		num1.insert(0);
		num2.insert(3);
		assertEquals("0", BigNumArithmetic.multiply(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "1 45 *"
		// this should return "45"
		num1.insert(1);
		num2.insert(4); num2.insert(5);
		assertEquals("45", BigNumArithmetic.multiply(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "556 8 *"
		// this should return "4448"
		num1.insert(5); num1.insert(5); num1.insert(6);
		num2.insert(8);
		assertEquals("4448", BigNumArithmetic.multiply(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "32 8656 *"
		// this should return "276992"
		num1.insert(3); num1.insert(2);
		num2.insert(8); num2.insert(6); num2.insert(5); num2.insert(6);
		assertEquals("276992", BigNumArithmetic.multiply(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "375340 654 *"
		// this should return "245472360"
		num1.insert(3); num1.insert(7); num1.insert(5); num1.insert(3); num1.insert(4); num1.insert(0);
		num2.insert(6); num2.insert(5); num2.insert(4);
		assertEquals("245472360", BigNumArithmetic.multiply(num1, num2));
		num1.clear();
		num2.clear();
	}
}
