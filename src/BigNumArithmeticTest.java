import org.junit.Test;
import static org.junit.Assert.*;

public class BigNumArithmeticTest {
	BigNumArithmetic bna = new BigNumArithmetic();	// create new BigNumArithmetic object to call the functions on
	
	@Test
	public final void addTest() {
		LList num1 = new LList();	// llist to store first number
		LList num2 = new LList();	// llist to store second number
		
		// case: "6 +" --> tests when one number is empty
		// this should return null
		num1.insert(6);		// first number is 6
		assertEquals(null, bna.add(num1, num2));
		num1.clear();	// clear llist for next test
		
		// case: "0 0 +"
		// this should return "0"
		num1.insert(0);		// first number is 0
		num2.insert(0);		// second number is 0
		assertEquals("0", bna.add(num1, num2));
		num1.clear();
		num2.clear();	// clear both llists
		
		// case: "3 7 +"
		// this should return "10"
		num1.insert(3);
		num2.insert(7);
		assertEquals("10", bna.add(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "0 457564 +"
		// this should return "457564"
		num1.insert(0);		// num1 is 0, num2 gets each digit inserted as a node in the llist
		num2.insert(4); num2.insert(5); num2.insert(7); num2.insert(5); num2.insert(6); num2.insert(4);
		assertEquals("457564", bna.add(num1,  num2));
		num1.clear();
		num2.clear();
		
		// case: "240 9822 +"
		// this should return "10062"
		num1.insert(2); num1.insert(4); num1.insert(0);
		num2.insert(9); num2.insert(8); num2.insert(2); num2.insert(2);
		assertEquals("10062", bna.add(num1,  num2));
		num1.clear();
		num2.clear();
		
		// case: "86767 2315 +"
		// this should return "89082"
		num1.insert(8); num1.insert(6); num1.insert(7); num1.insert(6); num1.insert(7);
		num2.insert(2); num2.insert(3); num2.insert(1); num2.insert(5);
		assertEquals("89082", bna.add(num1,  num2));
		num1.clear();
		num2.clear();
		
		// case: "996992443 12345 +"
		// this should return "997004788"
		num1.insert(9); num1.insert(9); num1.insert(6); num1.insert(9); num1.insert(9); num1.insert(2); num1.insert(4); num1.insert(4); num1.insert(3);
		num2.insert(1); num2.insert(2); num2.insert(3); num2.insert(4); num2.insert(5);
		assertEquals("997004788", bna.add(num1,  num2));
		num1.clear();
		num2.clear();
	}

	@Test
	public final void multiplyTest() {
		LList num1 = new LList();
		LList num2 = new LList();
		
		// case: "0 *" --> tests when one number is empty
		// this should return null
		num1.insert(0);
		assertEquals(null, bna.multiply(num1, num2));
		num1.clear();
		
		// case: "0 3 *"
		// this should return "0"
		num1.insert(0);
		num2.insert(3);
		assertEquals("0", bna.multiply(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "1 45 *"
		// this should return "45"
		num1.insert(1);
		num2.insert(4); num2.insert(5);
		assertEquals("45", bna.multiply(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "556 8 *"
		// this should return "4448"
		num1.insert(5); num1.insert(5); num1.insert(6);
		num2.insert(8);
		assertEquals("4448", bna.multiply(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "32 8656 *"
		// this should return "276992"
		num1.insert(3); num1.insert(2);
		num2.insert(8); num2.insert(6); num2.insert(5); num2.insert(6);
		assertEquals("276992", bna.multiply(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "375340 654 *"
		// this should return "245472360"
		num1.insert(3); num1.insert(7); num1.insert(5); num1.insert(3); num1.insert(4); num1.insert(0);
		num2.insert(6); num2.insert(5); num2.insert(4);
		assertEquals("245472360", bna.multiply(num1, num2));
		num1.clear();
		num2.clear();
	}

	@Test
	public final void exponTest() {
		LList num1 = new LList();
		LList num2 = new LList();
		
		// case: "8 ^"
		// this should return null --> tests when one number is empty
		num1.insert(8);
		assertEquals(null, bna.expon(num1, num2));
		num1.clear();
		
		// case: "0 0 ^"
		// this should return "1"
		num1.insert(0);
		num2.insert(0);
		assertEquals("1", bna.expon(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "0 324 ^"
		// this should return "0"
		num1.insert(0);
		num2.insert(3); num2.insert(2); num2.insert(4);
		assertEquals("1", bna.expon(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "12 0 ^"
		// this should return 1
		num1.insert(1); num1.insert(2);
		num2.insert(0);
		assertEquals("1", bna.expon(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "253 5 ^"
		// this should return "1036579476493"
		num1.insert(2); num1.insert(5); num1.insert(3);
		num2.insert(5);
		assertEquals("1036579476493", bna.expon(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "61 3 ^"
		// this should return "226981"
		num1.insert(6); num1.insert(1);
		num2.insert(3);
		assertEquals("226981", bna.expon(num1, num2));
		num1.clear();
		num2.clear();
		
		// case: "29 11 ^"
		// this should return "12200509765705829"
		num1.insert(2); num1.insert(9);
		num2.insert(1); num2.insert(1);
		assertEquals("12200509765705829", bna.expon(num1, num2));
		num1.clear();
		num2.clear();
	}

}
