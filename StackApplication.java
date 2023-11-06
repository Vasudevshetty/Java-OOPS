/* Question 12
Develop an application which consists of Stack class and include methods to 
push and pop the stack elements. Create your own defined Exception class 
and handle exceptions while stacks run with “Stack as full” and “Stack under 
flow” while calling push() and pop() methods respectively. Implement this 
using ‘throws’ and ‘throw’ keywords. */

// create a exception class for over flow(Stack full) exception.
class StackOverFlowException extends Exception {
    // override the toString() method.
    @Override
    public String toString() {
        return "Stack Over flow.(Full)";
    }
}

// create a exception class for over flow(Stack full) exception.
class StackUnderFlowException extends Exception {
    // override the toString() method.
    @Override
    public String toString() {
        return "Stack under flow.(Empty)";
    }
}

// create a stack class with push and pop methods.
class Stack {
    private int size; // the size of the array.
    private int top = -1; // the indx(pointer) to navigate
    private int[] elements; // container to store the elements.

    // constructor to create custom size conatiner(array)
    public Stack(int size) {
        this.size = size;
        elements = new int[size];
    }

    // method to push
    public void push(int data) throws StackOverFlowException{
        if(top == size -1){
            throw new StackOverFlowException();
        }
        elements[++top] = data;
    }

    // method to pop
    public int pop() throws StackUnderFlowException{
        if(top == -1){
            throw new StackUnderFlowException();
        }
        int data = elements[top--];
        return data;
    }

    // used throws and throw keywords int the above methods.
}

// the main method can be made simple with using throws keyword
/*
    * public static void main(String args[]) throws StackOverFlowException, StackUnderFlowException{
*       int stackSize = 5;
        Stack stack = new Stack(stackSize);
        
        for (int i = 0; i < stackSize + 1; i++) {
            stack.push(i);
        }

        for (int i = 0; i < stackSize + 1; i++) {
            int poppedElement = stack.pop();
            System.out.println("Popped: " + poppedElement);
        }
    * }
*/
    
// In main method instead of using throws and throw keyword used try catch block and returned the exception while pushing and poping
// respectively.

public class StackApplication {
    public static void main(String args[]) {
        int stackSize = 5; // if need we can input from user.
        Stack stack = new Stack(stackSize);

        try{
            // if needed we can input the values from user itself.
            for(int i = 0; i < stackSize + 1; i++){
                stack.push(i);
            }
        }catch(StackOverFlowException e){
            System.out.println(e);
        }

        System.out.println();

        // pop out the elements while checking the exception too.
        try{
            for(int i = 0; i < stackSize + 1; i++){
                int data = stack.pop();
                System.out.println("Popped out element is "  + data );
            }
        }catch(StackUnderFlowException e){
            System.out.println(e);
        }
    }
}
