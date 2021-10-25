import edu.princeton.cs.algs4.*;



public class Exercise11
{
    private static double infixToPostfix(String input)
    {
	String[] inputValues = input.split(" ");
	double operandsTotal;
	Stack<String> operators = new Stack<>();
	Stack<Double> operands = new Stack<>();

	for (String value : inputValues)
	    {
		
	        if ((!value.equals("+")) || (!value.equals("-")) || (!value.equals("*")) ||
		    (!value.equals("\\")))
		    {
			operands.push(Double.parseDouble(value));
		    }
		else if(value.equals("+"))
		    {
			double operand2 = operands.pop();
			double operand1 = operands.pop();
			operandsTotal = operand1 + operand2;
			StdOut.println(operandsTotal);
			operands.push(operandsTotal);
		    }
			
		else if (value.equals("-"))
		    {
			double operand2 = operands.pop();
			double operand1 = operands.pop();
			operandsTotal = operand1 - operand2;
			operands.push(operandsTotal);
		    }
		else if (value.equals("*"))
		    {
			double operand2 = operands.pop();
			double operand1 = operands.pop();
			operandsTotal = operand1 * operand2;
			operands.push(operandsTotal);
		    }
		else if (value.equals("\\"))
		    {
			double operand2 = operands.pop();
			double operand1 = operands.pop();
			operandsTotal = operand1 / operand2;
			operands.push(operandsTotal);
		    }
			
		
		
	    }

	
	return operands.pop();

	
    }
    

    public static void main(String[] args)
    {

	String input = args[0];

	
	double postfixExpression = infixToPostfix(input);
	StdOut.println(postfixExpression);
    }


}
