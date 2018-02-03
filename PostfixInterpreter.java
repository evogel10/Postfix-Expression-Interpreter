/**
 * 
 * This class converts a postfix string into sequence of readable instructions.
 * 
 * @version 29 Feb 2016
 * @author Eric Vogel
 *
 */
public class PostfixInterpreter {

    /**
     * Reads through a postfix string to create a sequence of instructions to
     * solve the expression.
     * 
     * @param postfix
     *            string from an input file.
     * @return a string of commands.
     */
    public String convert(String postfix) {

        String a = "";              // Contains the string in the index below the top of the
                                    // stack.
        String b = "";              // Contains the string at the top of the stack.
        String commands = "";
        int n = 0;                  // Initial number assigned to the TEMP variable.

        Stack stack = new Stack();  // Declaration of new stack object.

        // This for loop reads through each postfix expression one char at a
        // time and
        // creates instructions to solve the expression.
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            // If the expression doen't not only contain single letter operands
            // and
            // the operators +, -, *, /, and $, it exits the for loop
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == '+')
                    || (c == '-') || (c == '*') || (c == '/') || (c == '$')) {

                // Series of if/else if statements to determine which command to
                // print out
                // and what to put back into the stack.
                if (c == '+') {
                    b = stack.pop();
                    a = stack.pop();
                    n++;
                    commands = commands + "LD " + a + "\n" + "AD " + b + "\n"
                            + "ST " + "TEMP" + n + "\n";
                    stack.push("TEMP" + String.valueOf(n));
                } else if (c == '-') {
                    b = stack.pop();
                    a = stack.pop();
                    n++;
                    commands = commands + "LD " + a + "\n" + "SB " + b + "\n"
                            + "ST " + "TEMP" + n + "\n";
                    stack.push("TEMP" + String.valueOf(n));
                } else if (c == '*') {
                    b = stack.pop();
                    a = stack.pop();
                    n++;
                    commands = commands + "LD " + a + "\n" + "ML " + b + "\n"
                            + "ST " + "TEMP" + n + "\n";
                    stack.push("TEMP" + String.valueOf(n));
                } else if (c == '/') {
                    b = stack.pop();
                    a = stack.pop();
                    n++;
                    commands = commands + "LD " + a + "\n" + "DV " + b + "\n"
                            + "ST " + "TEMP" + n + "\n";
                    stack.push("TEMP" + String.valueOf(n));
                } else if (c == '$') {
                    b = stack.pop();
                    a = stack.pop();
                    n++;
                    commands = commands + "LD " + a + "\n" + "EX " + b + "\n"
                            + "ST " + "TEMP" + n + "\n";
                    stack.push("TEMP" + String.valueOf(n));
                } else
                    stack.push(String.valueOf(c));
            } else {
                // Error message to tell the user to review the postfix
                // expression.
                commands = "Your postfix expression does not only contain single letter operands "
                        + "and the operators +, -, *, /, and $. Please review you postfix expresstion "
                        + "and try again.\n";
                i = postfix.length();       // Ends the for loop if error is found.
            }
        }
        // This while loop clears the stack for the next postfix expression
        // and allows for at many expressions as desired as long as they fit
        // in the array index of 50.
        while (!(stack.isEmpty())) {
            stack.pop();
        }
        // Returns the sequence of readable instructions.
        return commands;
    }
}
