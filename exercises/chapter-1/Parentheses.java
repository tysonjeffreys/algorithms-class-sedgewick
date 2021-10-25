import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class Parentheses
{
    public static void main(String[] args)
    {
	Stack<String> left = new Stack<String>();
	Stack<String> right = new Stack<String>();
	String val = "false";
	
	
	while (!StdIn.isEmpty())
	{
	    
	    String s = StdIn.readString();
	    

	    if (s.equals("(")) left.push(")");
	    else if (s.equals("{")) left.push("}");
	    else if (s.equals("[")) left.push("]");
	    else if (s.equals("]") || s.equals("}") || s.equals(")"))
		{
		    String lefty = left.pop();
		    if (s.equals(lefty)) val = "true";
		    else if (!s.equals(lefty))
			{
			    val = "false";
			    StdOut.println("false");
			    break;
			}
		}	
	}
	if (val.equals("true")) StdOut.println("true");
    }
}
					
