import edu.princeton.cs.algs4.*;



public class Exercise10
{
    private static String infixToPostfix(String input)
    {
	String[] inputValues = input.split(" ");
	String subString;
	Stack<String> operators = new Stack<>();
	Stack<String> operands = new Stack<>();

	for (String value : inputValues)
	    {
		if (value.equals("(")); //Ignore left parentheses
		else if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("\\"))
		    {
			operators.push(value);
		    }
		else if(value.equals(")"))
			{
			    String operand2 = operands.pop();
			    String operand1 = operands.pop();
			    subString = operand1 +  " "  + operand2 + " " + operators.pop();
			    operands.push(subString);
			}
			
			else operands.push(value);      
		
	    }

	
	return operands.pop();

	
    }
    

    public static void main(String[] args)
    {

	String input = args[0];

	
	String postfixExpression = infixToPostfix(input);
	StdOut.println(postfixExpression);
    }


}
