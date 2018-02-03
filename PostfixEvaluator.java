import java.io.*;
import java.util.Scanner;

/**
 * 
 * This class receives input from a file and writes the sequence of instructions
 * to solve the expression to another file.
 * 
 * @version 29 Feb 2016
 * @author Eric Vogel
 *
 */
public class PostfixEvaluator {

    /**
     * Main class to the program.
     * 
     * @param args
     *            .
     * @throws IOException.
     */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        // Name of the input file.
        System.out.print("Please Enter input File Name: ");
        String inputFileName = sc.next();
        // Name of the output file.
        System.out.print("Please Enter output File Name: ");
        String outputFileName = sc.next();
        sc.close();

        // Create a new PostfixInterpreter object.
        PostfixInterpreter obj = new PostfixInterpreter();

        // This will reference one line at a time.
        String line = null;

        try {
            // FileReader reads text files in.
            FileReader fileReader = new FileReader(inputFileName);
            // FileWriter writes the text files in the output file
            FileWriter fileWriter = new FileWriter(outputFileName);

            // Reads text from a character-input stream.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Writes text to a character-output stream.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            while ((line = bufferedReader.readLine()) != null) {
                int operands = 0;               // Number of operands
                int operators = 1;              // Number of operators
                boolean whitespace = false;     // Variable used to see if the
                                                // expression has whitespace.
                // This for loop checks to see if there is the proper amount of
                // operands and operators.
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                        operands++;
                    if ((c == '+') || (c == '-') || (c == '*') || (c == '/')
                            || (c == '$'))
                        operators++;
                    if ((c == ' ') || (c == '\n') || (c == '\t'))
                        whitespace = true;

                }
                // If there is whitespace, the program will ask the user to
                // remove from their expression.
                if (whitespace == true) {
                    bufferedWriter.write("Please remove whitespaces from you postfix expression "
                                    + "and try again.\n");
                    bufferedWriter.write("---------\n");
                }
                // Since there must be one more operand than operators in the
                // expressions we are using
                // we can determine if the postfix expression is valid or not by
                // comparing how many of
                // each there is.
                else if (!(operands == operators)) {
                    bufferedWriter.write("You have an invalid postfix expression. Check to see if "
                                    + "you have the proper amount of operators and operands "
                                    + "and try again.\n");
                    bufferedWriter.write("---------\n");
                } else {
                    // Writes the commands to the output file.
                    bufferedWriter.write(obj.convert(line));
                    bufferedWriter.write("---------\n");
                }
            }

            // Closes files.
            bufferedReader.close();
            bufferedWriter.close();

            // Used if the input file can't opened
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + inputFileName + "'");

            // Used if there is an error reading the input file
        } catch (IOException ex) {
            System.out.println("Error reading file '" + inputFileName + "'");

        }
    }
}
