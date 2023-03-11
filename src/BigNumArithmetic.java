import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic extends Operations {
	public static void main(String[] args) {
		File filename = null;
		
		if (args[0] != null) {
			filename = new File(args[0]);
		}
		System.out.println(filename);
		
		Scanner scan = null;
		try {
			
			FileInputStream fileIn = new FileInputStream(filename);	// create FileInputStream and pass in filename
			scan = new Scanner(fileIn);		// create scanner to read from the file
			
			while (scan.hasNextLine()) {	// while the file has another line, read in each expression
				LStack stack = new LStack();
				String next = scan.next();	// scan next character

				//formatting for extra lines and trailing zeros - move on to the next if equal to a zero or blank space
				if (next.equals(" ")) {
					scan.next();
				} else if (next.equals("0")) {
					scan.next();
				}

				// if next is a digit 1-9
				if (next.equals("1") || next.equals("2") || next.equals("3") || next.equals("4") || next.equals("5") || next.equals("6") || next.equals("7") || next.equals("8") || next.equals("9")) {
					LList num = new LList();
					
					while (next.equals(" ") == false) {		// while next is not a space
						num.insert(next);
					}
					stack.push(next);		//push what is found at "next" onto the stack

				} else {
					Operations op = new Operations();	// make new operations object to call the operators
					//switch statement for reading operators and calling function
					switch (next) {

						//case for addition
						case ("+"):
							String additionResult;
							//call pop twice to get the two recent numbers found
							String add1 = stack.pop();
							String add2 = stack.pop();
							// TODO - add the two results together using the function call
							LList addLL1 = new LList();		// make llist to convert add1 from string to llist
							for (int c = add1.length() - 1; c >= 0; c--) {	// start at the last digit and insert it, then move towards the front and insert each digit
								addLL1.insert(add1.charAt(c));	// insert each char at char c into the llist
							}
							LList addLL2 = new LList();		// repeat for num2
							for (int c = add2.length() - 1; c >= 0; c--) {
								addLL2.insert(add2.charAt(c));
							}
							additionResult = op.add(addLL1, addLL2);	// perform addition
							stack.push(additionResult);	// push result onto to of stack
							break;
							
						//case for multiplication
						case("*"):
							String multiplyResult;
							//call pop twice to get the two recent numbers found
							String multi1 = stack.pop();
							String multi2 = stack.pop();
							// TODO - add the two results together using the function call
							LList multiLL1 = new LList();		// make llist to convert add1 from string to llist
							for (int c = multi1.length() - 1; c >= 0; c--) {
								multiLL1.insert(multi1.charAt(c));	// insert each char at char c into the llist
							}
							LList multiLL2 = new LList();		// repeat for num2
							for (int c = multi2.length() - 1; c >= 0; c--) {
								multiLL2.insert(multi2.charAt(c));
							}
							multiplyResult = op.multiply(multiLL1, multiLL2);	// perform addition
							stack.push(multiplyResult);	// push result onto to of stack
							break;
							
						//case for exponents
						case("^"):
							String exponResult;
							//calling pop and setting numbers
							String expon1 = stack.pop();
							String expon2 = stack.pop();
							// add the two results together using the function call
							exponResult = op.expon(expon1, expon2);	// perform exponentiation
							stack.push(exponResult);	// push result onto top of stack
							break;
					}
				}

				// TODO System.out.print(...\n);	// print the result for each line
			}
		}
		catch (FileNotFoundException e) {		// case if the entered file does not exist
			System.out.println("File not found. Exiting program...");
		}
	}
}
