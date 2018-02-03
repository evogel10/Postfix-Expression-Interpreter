/**
 * 
 * This class implements a stack by creating user defined push() method for
 * entering elements, pop() method for retrieving elements, isEmpty() method to
 * test to see if the stack is empty, and peek() method to look at the top of
 * the stack.
 * 
 * @version 29 Feb 2016
 * @author Eric Vogel
 *
 */
public class Stack {

    private final int STACKSIZE = 50;   // Max number of elements in the stack.
    private int top;                    // Position of current stack top.
    private String[] stackArray;        // Array to hold the string items in the stack.

    /**
     * Basic constructor creates a new stack object with no parameters.
     */
    public Stack() {

        stackArray = new String[STACKSIZE];
        top = -1;
    }

    /**
     * Tests if the stack is empty.
     * 
     * @return returns true if the stack is empty, otherwise returns false.
     */
    public boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    /**
     * Pushes a String onto the top of the stack.
     * 
     * @param a string from the postfix expression to push onto the top of the stack.
     */
    public void push(String string) {
        if (top > STACKSIZE - 1) {
            System.out.println("Stack Overflow ");
            System.exit(1);
        }
        stackArray[++top] = string;
    }

    /**
     * Removes a String from the top of the stack.
     * 
     * @return The top item from the stack.
     */
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow ");
            System.exit(1);
        }
        return stackArray[top--];
    }

    /**
     * Allows the user to view the top item in the stack
     * 
     * @return Returns the top String in the stack
     */
    public String peek() {
        return stackArray[top];
    }
}
