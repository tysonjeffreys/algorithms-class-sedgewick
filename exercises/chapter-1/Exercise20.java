import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class Exercise20<Item>
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
                        for (int i = 0; i < n - 2;i++)
            
                            {
                                first = first.next;
                
                            }
                        first.next = null;
                        n--;
                        
                    }
            }
    }


	

    public void delete(int k)
    {
	int count = 1;
	if (k > n || isEmpty())
	    {
		return;
	    }
	 if (k == 1) {
	     first  = first.next;
	 }
	 else
	     {
		 for (Node current = first; current != null;current = current.next)
		     {
			 if (count == k-1 && current.next != null)
			     {
				 current.next = current.next.next;
				 break;
			     }
			 count++;
		      
		     }
		 
	     }
	 n--;
    }

    

		
    public Iterator<Item> iterator()
    { return new ListIterator(); }

    private class ListIterator implements Iterator<Item>
    {
	private Node current = first;

	public boolean hasNext()
	{ return current != null; }

	public void remove() {}

	public Item next()
	{
	    Item item = current.item;
	    current = current.next;
	    return item;
	}
    }
		



    public static void main(String[] args)
    {

	Exercise20<String> stack = new Exercise20<String>();


      
	stack.push("Ground control");
	stack.push("to major");
	stack.push("Tom");
	//stack.removeLast();
	stack.delete(3);
	//stack.removeLast();
	//stack.removeLast();
	//StdOut.println(stack.pop());
	//StdOut.println(stack.pop());
	//StdOut.println(stack.pop());
	Iterator<String> i = stack.iterator();

	while (i.hasNext())
	    {
		StdOut.println(i.next());
	    }
    }




}
