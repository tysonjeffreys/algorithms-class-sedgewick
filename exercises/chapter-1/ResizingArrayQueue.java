import edu.princeton.cs.algs4.*;
import java.util.Iterator;


public class ResizingArrayQueue<Item> implements Iterable<Item>
{

    private Item[] a = (Item[]) new Object[1];
    private int n = 0;

    private void resize(int max)
    {
	Item[] temp = (Item[]) new Object[max];
	for (int i = 0; i < n; i++)
	    {
		temp[i] = a[i];
	    }
	a = temp;
    }
    
    public void enque(Item item)
    {
	
	if (n == a.length) resize(a.length*2);
	a[n++] = item;
		
    }

    public Item deque()
    {
	Item item  =  a[--n];
	a[n] = null;
	if (n > 0 && n == a.length/4) resize(a.length/2);
	return item;
    }

    public Iterator<Item> iterator()
    { return new ArrayIterator(); }

    private class ArrayIterator implements Iterator<Item>
    {
	private int i = n-1;
	public boolean hasNext() { return i >= 0; }
	public Item next() { return a[i--]; }
	public void remove() {}
    }

    public static void main(String[] args)
    {
	
	ResizingArrayQueue<String> newQueue = new ResizingArrayQueue<>();
	newQueue.enque("elesium");
	newQueue.enque("some");
	newQueue.enque("day");
	StdOut.println(newQueue.deque());
	newQueue.enque("Ground control");
	StdOut.println(newQueue.n);
	Iterator<String> i = newQueue.iterator();
	
	while (i.hasNext())
	    {
		StdOut.println(i.next());
	    }
	

    }

}
