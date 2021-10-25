import edu.princeton.cs.algs4.*;


public class StackLinkList<Item>
{
    private Node first;
    private int n;


    private class Node
    {
        Item item;
	Node next;
	
    }

    public boolean isEmpty()
    {
	return first == null;
    }
    
    public void push(Item item)
    {
	Node oldfirst = first;
	first = new Node();
	first.item = item;
	first.next = oldfirst;
	//StdOut.println(first.item);
	n++;
	StdOut.println(n);
    }

    public Item pop()
    {
	Item item = first.item;
	first = first.next;
	n--;
	 
	return item;
	
    }

    public void removeLast()
    {
	if (!isEmpty())
	    {
		if (n == 1) {
		    first  = null;
		}
		else
		    {
			
	      		//Node current = first;
			for (int i = 0; i <= n-2;i++)
	    
			    {
				first = first.next;
		
			    }
			first.next = null;
			n--;
			StdOut.println(n);
		    }
	    }
    }
		
    



    public static void main(String[] args)
    {

	StackLinkList<String> stack = new StackLinkList<>();


      
	stack.push("Ground control");
	stack.push("to major");
	stack.push("Tom");
	stack.removeLast();
	//stack.removeLast();
	//stack.removeLast();
	//StdOut.println(stack.pop());
	//StdOut.println(stack.pop());
	//StdOut.println(stack.pop());
    }




}
