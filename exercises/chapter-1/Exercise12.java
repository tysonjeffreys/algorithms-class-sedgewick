import edu.princeton.cs.algs4.*;



public class Exercise12
{

    
    public static Stack<String> copy(Stack<String> stack)
    {
	Stack<String> stackTemp = new Stack<>();
	Stack<String> stackCopy = new Stack<>();
	Queue<String> queCopy = new Queue<>();

	for (String value : stack)
	    {
		stackTemp.push(value);
	    }
	for (String value : stackTemp)
	    {
		stackCopy.push(value);
	    }
	
	return stackCopy;
    }


    public static void main(String[] args)

    {
	
	Stack<String> stackOfStrings = new Stack<>();
	stackOfStrings.push("Ground");
	stackOfStrings.push("control");
	stackOfStrings.push("to major");
	stackOfStrings.push("Tom");

	StdOut.println(stackOfStrings);
	StdOut.println(copy(stackOfStrings));
    }		   


}

    
