import java.io.*;
import java.util.Scanner;

public class BigNumArithmetic extends Operations {
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
}
