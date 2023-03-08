import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic {
	public static void main(String[] args) {
		File filename = null;
		
		if (args[0] != null) {
			filename = new File(args[0]);
		}

		Scanner scan = null;
		
		try {
			FileInputStream fileIn = new FileInputStream(filename);	// create fileinputstream and pass in filename
			scan = new Scanner(filename);		// create scanner to read from the file
			while (scan.hasNextLine()) {	// while the file has another line, read in each expression
				
				String next = scan.next();	// scan next character
				if (next.equals("1") || next.equals("2") || next.equals("3") || next.equals("4") || next.equals("5") || next.equals("6") || next.equals("7") || next.equals("8") || next.equals("9")) {
					
					while (next.equals(" ") == false) {	// while next char is not a space
						LList num = new LList();		// create new LList to store the number
						num.insert(next);
					}
				}
				else if (next == "+" || next == "*" || next == "^") {
					LStack op = new LStack();
					
					// push operator onto stack
				}
				// TODO System.out.print(...\n);	// print the result for each line
			}
		}
		catch (FileNotFoundException e) {		// case if filename is not passed through the command line
			System.out.println("File not found. Exiting program...");
		}
	}

	public static String add(LList num1, LList num2) {	// this function performs addition on 2 operands (stored as linked lists)
		//create two link lists for storing values (setting empty)
		LList biggest = null;
		//save the reverse total and a boolean for keeping track of the reverse operation
		boolean reverse = true;
		String reverseTotal = "";

		// if num1 or num2 is empty, return null
		if (num1.isEmpty() || num2.isEmpty()) {
			return null;
		}
		
		//first check to determine which of the linked lists is bigger, so that the smaller can be added to it
		if (num1.length() > num2.length()) {
			biggest = num1;
		} else {
			biggest = num2;
		}

		//we then should move our pointer to the start of each LList using the moveToStart function
		num1.moveToStart();
		num2.moveToStart();

		//we can now loop through the list from the beginning and add - we will use a variable to keep track of what
		//should be carried due to addition
		int carry = 0;
		//new link list to store the results of the addition
		LList additionResult = new LList();
		//looping begins
		for (int i = 0; i < biggest.length(); i++) {
			int ones = 0;
			int twos = 0;
			int total = 0;

			if ( i < biggest.length()) {
				if ( i < num1.length()) {
					String value1 = String.valueOf(num1.getValue());
					ones = Integer.parseInt(value1);
				}
				if ( i < num2.length()) {
					String value2 = String.valueOf(num2.getValue());
					twos = Integer.parseInt(value2);
				}
				//sum of the operations above
				total = ones + twos + carry;

				if (num1.length() == 1 && num2.length() == 1) {
					additionResult.append(total);
					reverse = false;
					reverseTotal = String.valueOf(total);
				} else if (total < 10) {
					additionResult.append(total);
					carry = 0;
				} else {
					additionResult.append(total % 10);
					carry = 1;
				}
				//move to the next
				num1.next();
				num2.next();
			}
		}

		//this operation will add the carry value if it needed to be appended to the total
		if (carry == 1){
			additionResult.append(carry);
		}

		//we then need a space to store the final result, so we create a value and loop through once more
		String finalTotal = "";
		for (int j = additionResult.length()-1; j >= 0; j--) {
			finalTotal = finalTotal + additionResult.getValue();
			additionResult.next();
		}
		//precautionary - if the string requires it to be reversed
		if (reverse){
			char c;
			for (int a = 0; a < finalTotal.length(); a++) {
				c = finalTotal.charAt(a);
				reverseTotal = c + reverseTotal;
			}
		}
		return reverseTotal;
	}
	
	public static String multiply(LList num1, LList num2) {	// this function performs multiplication on 2 operands - the addition method is also used
		//we start again similarly to addition, by creating variables that will keep track of varying characteristics
		LList biggest = null;
		LList smallest = null;
		LList result = null;

		//for reverse operations
		String reversedResult = "";
		LList previousR = new LList();
		boolean reverse = true;
		
		// if num1 or num2 is empty, return null
			if (num1.isEmpty() || num2.isEmpty()) {
				return null;
			}

		//first, we check to see which list is bigger so that it can be multiplied to the other
		if (num1.length() >= num2.length()) {
			biggest = num1;
			smallest = num2;
		} else {
			biggest = num2;
			smallest = num1;
		}
		//move our pointer to the start of each by calling the moveToStart function
		num1.moveToStart();
		num2.moveToStart();

		//now, we loop through the smallest number based on the above operation and multiply it by the digits of the other
		//the loop continuously moves through the smallest number digit by digit while keeping a running total
		//this loop takes into account additional 0's and ends by returning the product of multiplication operation after being reversed
		//the final result is written out in the correct order

		int carry = 0;
		result = new LList();
		for (int i = 0; i < smallest.length(); i++) {
			int ones = 0;
			int twos = 0;
			int product = 0;
			String total = "";
			if (smallest.getValue() != null) {
				String onesTotal = String.valueOf(smallest.getValue());
				ones = Integer.parseInt(onesTotal);

				if (i >=1 ) {
					for (int k = 0; k < i; k++) {
						result.append("0");
					}
				}
				for (int m = 0; m < biggest.length(); m++) {
					String twosTotal = String.valueOf(biggest.getValue());
					twos = Integer.parseInt(twosTotal);

					if (smallest.length() == 1 && ones == 0) {
						reversedResult = "0";
						return reversedResult;
					}
					product = (ones * twos) + carry;

					if (smallest.length() == 1 && biggest.length() == 1) {
						result.append(product);
						reversedResult = String.valueOf(product);
						return reversedResult;
					}
					else if (product < 10) {
						result.append(product);
						carry = 0;
					}
					else {
						result.append(product % 10);
						carry = (product / 10);
					}
					biggest.next();
					//if we are at the end of the digit
					if (biggest.isAtEnd() && carry > 0) {
						result.append(carry);
						carry = 0;
					}
				}
				if (smallest.length() == 1) {
					for (int e = result.length()-1; e >= 0; e--) {
						reversedResult = result.getValue() + reversedResult;
						result.next();
					}
					return reversedResult;
				}
			}
			//now, we will append each of the values to the correct lists and make sure that everything is in order
			if ( i == 0) {

				for (int b = 0; b < result.length(); b++) {
					result.next();
				}
				result.moveToStart();
				for (int d = 0; d < result.length(); d++) {
					previousR.append(result.getValue());
					result.next();
				}
				for (int b = 0; b < previousR.length(); b++) {
					previousR.next();
				}
				previousR.moveToStart();
			} else if(i >= 1) {
				for (int b = 0; b < result.length(); b++) {
					result.next();
				}
				total = add(result,previousR);
				reversedResult = total;

				previousR.clear();
				for (int a = total.length()-1; a >= 0; a--) {
					previousR.append(total.charAt(a));
				}
				previousR.moveToStart();
				for (int t =0; t < previousR.length(); t++) {
					previousR.next();
				}
			}
			//move pointers and clear necessary variables
			smallest.next();
			biggest.moveToStart();
			result.clear();
		}
		return reversedResult;

	}
	
	public static String expon(LList num1, LList num2) {		// this function performs exponentiation on 2 operands
		// TODO
		
		// if num1 or num2 is empty, return null
		if (num1.isEmpty() || num2.isEmpty()) {
			return null;
		}
		
		String reversedResult = "";
		
		return reversedResult;
	}
}
