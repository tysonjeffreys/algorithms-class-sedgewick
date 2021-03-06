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


    public static void main(String[] args)
    {
	ResizingArrayStack<String> collection = new ResizingArrayStack<String>();
	collection.push("hello");
	collection.push("there");
	//collection.pop();
	//StdOut.println("hello");

	 Iterator<String> i = collection.iterator();
	wile (i.hasNext())
	    {
		String s = i.next();
		StdOut.println(s);
	    }
	
	for ( String s : collection)
	    StdOut.println(s);
	   
    }




}


    
				 
       
						
