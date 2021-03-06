import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class FixedCapacityStackOfStrings {
    private String[] a;
    private int n;
    private int cap;

    public FixedCapacityStackOfStrings(int capacity)
    {
	a = new String[capacity];
        cap = capacity;
    }

    public boolean isEmpty() { return n == 0; }
    public boolean isFull() { return n == cap; }
    public int size() { return n; }
    public void printCapacity() { StdOut.println(cap); }
    

    public void push(String item)
    { a[n++] = item; }
    public String pop()
    { return a[--n]; }


public static void main(String[] args)
{
    FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(2);
    while (!StdIn.isEmpty()) {
	String item = StdIn.readString();
	if (s.isFull()) { StdOut.print("Stack is Full "); break; }
	else if (!item.equals("-"))
	    s.push(item);
	else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
	//else if (s.isFull()) StdOut.print("Stack is Full");
    }
    StdOut.println("(" + s.size() + " left on stack)");
    
    s.printCapacity(); 
}
}
