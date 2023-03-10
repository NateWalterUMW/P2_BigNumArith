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
			scan = new Scanner(fileIn);		// create scanner to read from the file
			
			while (scan.hasNextLine()) {	// while the file has another line, read in each expression
				LStack stack = new LStack();
				String next = scan.next();	// scan next character
				
				// if next is a digit 1-9
				if (next.equals("1") || next.equals("2") || next.equals("3") || next.equals("4") || next.equals("5") || next.equals("6") || next.equals("7") || next.equals("8") || next.equals("9")) {
					LList num = new LList();
					
					while (next.equals(" ") == false) {		// while next is not s space
						num.insert(next);
					}
					//stack.push(num);	// trying to push the LList onto the stack, but getting type mismatch errors

				}else{
					//switch statement for reading operators and calling function
					switch (next){

						//case for addition
						case ("+"):


							break;

						case("*"):

							break;

						case("^"):

							break;
					}
				}

				// TODO System.out.print(...\n);	// print the result for each line
			}
		}
		catch (FileNotFoundException e) {		// case if filename is not passed through the command line
			System.out.println("File not found. Exiting program...");
		}
	}
}
