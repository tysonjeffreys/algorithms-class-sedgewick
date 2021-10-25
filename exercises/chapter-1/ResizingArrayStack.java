import java.util.Iterator;
import edu.princeton.cs.algs4.*;

public class ResizingArrayStack<Item> implements Iterable<Item>
{
    private Item[] a = (Item[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() { return n == 0; }
    public int size() { return n; }

    public void resize(int max)
    { //move stack to a new array of size max.
	Item[] temp = (Item[]) new Object[max];
	for (int i = 0; i < n; i++)
	    temp[i] = a[i];
	a = temp;
    }

    public void push(Item item)
    { // Add item to top of stack.
       if (n == a.length) resize(2*a.length);
       a[n++] = item;
    }

    // Return the most recently inserted item without popping it.
    public Item peek()
    {
	return a[--n];
    }

    public Item pop()
    { // Remove item from top of stack.
	Item item = a[--n];
	a[n] = null; //Avoid loitering
	if (n > 0 && n == a.length/4) resize (a.length/2);
	StdOut.println(item);
	return item;
    }

    public Iterator<Item> iterator()
    { return new ReverseArrayIterator(); }

    private class ReverseArrayIterator implements Iterator<Item>
    { //Support LIFO iteration.
	private int i = n-1;
	public boolean hasNext() { return i >= 0; }
	public Item next() { return a[i--]; }
	public void remove() {}
    }

    //The textsbooks test client

    public static void main(String[] args)
    {
	ResizingArrayStack<String> s = new ResizingArrayStack<String>();

	while (!StdIn.isEmpty())
	    {
		String item = StdIn.readString();
		if (!item.equals("-"))
		    s.push(item);
		else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
	    }
	Iterator<String> i = s.iterator();
	while (i.hasNext())
	    {
		String t = i.next();
		StdOut.print(t + " ");
	    }
	
	StdOut.println("The size of the stack is " + s.size() + ".");
    }

    /*
    public static void main(String[] args)
    {
	ResizingArrayStack<String> collection = new ResizingArrayStack<String>();
	collection.push("hello");
	String peek = collection.peek();
	StdOut.println(peek);
	
	//StdOut.println("hello");

        Iterator<String> i = collection.iterator();
	while (i.hasNext())
	    {
		String s = i.next();
		//StdOut.println(s);
	    }
	
	
	
	   
    }
    */

    



}


    
				 
       
						
