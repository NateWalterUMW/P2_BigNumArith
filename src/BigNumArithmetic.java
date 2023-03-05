import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic {
	public static void main(String[] args) {
		try {
			String fname = args[0];		// create new string to store the entered filename
			File file = new File(fname);	// create new file, passing in filename as a string
			FileInputStream fileIn = new FileInputStream(fname);	// create fileinputstream and pass in filename
			
			Scanner scan = new Scanner(fileIn);		// create scanner to read from the file
			
			while (scan.hasNextLine()) {	// while the file has another line
				// TODO
			}
		}
		catch (FileNotFoundException e) {		// case if filename is not passed through the command line
			System.out.println("File not found. Exiting program...");
		}
	}

	public String add(LList num1, LList num2) {	// this function performs addition on 2 operands (stored as linked lists)
		//create two link lists for storing values (setting empty)
		LList biggest = null;
		//save the reverse total and a boolean for keeping track of the reverse operation
		boolean reverse = true;
		String reverseTotal = "";

		//first check to determine which of the linked lists is bigger, so that the smaller can be added to it
		if(num1.length() > num2.length()){
			biggest = num1;
		}else{
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
		for(int i = 0; i < biggest.length(); i++){
			int ones = 0;
			int twos = 0;
			int total = 0;

			if( i < biggest.length()){
				if( i < num1.length()){
					String value1 = String.valueOf(num1.getValue());
					ones = Integer.parseInt(value1);
				}
				if( i < num2.length()){
					String value2 = String.valueOf(num2.getValue());
					twos = Integer.parseInt(value2);
				}
				//sum of the operations above
				total = ones + twos + carry;

				if(num1.length() == 1 && num2.length() == 1){
					additionResult.append(total);
					reverse = false;
					reverseTotal = String.valueOf(total);
				}else if(total < 10){
					additionResult.append(total);
					carry = 0;
				}else{
					additionResult.append(total % 10);
					carry = 1;
				}
				//move to the next
				num1.next();
				num2.next();
			}
		}

		//this operation will add the carry value if it needed to be appended to the total
		if(carry == 1){
			additionResult.append(carry);
		}

		//we then need a space to store the final result, so we create a value and loop through once more
		String finalTotal = "";
		for(int j = additionResult.length()-1; j >= 0; j--){
			finalTotal = finalTotal + additionResult.getValue();
			additionResult.next();
		}
		//precautionary - if the string requires it to be reversed
		if(reverse){
			char c;
			for(int a = 0; a < finalTotal.length(); a++){
				c = finalTotal.charAt(a);
				reverseTotal = c + reverseTotal;
			}
		}
		return reverseTotal;
	}
	
	public int multiply(LList num1, LList num2) {	// this function performs multiplication on 2 operands
		// TODO
		
		return 0;
	}
	
	
	public int expon(LList num1, LList num2) {		// this function performs exponentiation on 2 operands
		// TODO
		
		return 0;
	}
}
