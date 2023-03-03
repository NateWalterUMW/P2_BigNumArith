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
	public int add(LList num1, LList num2) {	// this function performs addition on 2 operands (stored as linked lists)
		// TODO
		return 0;
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
