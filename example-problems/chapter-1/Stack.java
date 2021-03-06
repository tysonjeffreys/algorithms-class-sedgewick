//import edu.princeton.cs.algs4.*;

public class Stack<Item>
{
    private Node first;
    private int n;

    private class Node
    { //nested class to define nodes
	Item item;
	Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return n; }

    public void push (Item item)
    { //Add item to top of stack
	Node oldfirst = first;
	first = new Node();
	first.item = item;
	first.next = oldfirst;
	n++;
    }

    public Item pop()
    { //Remove item from top of stack.
	Item item = first.item;
	first = first.next;
	n--;
	System.out.println(item);
	return item;
    }

    public static void main(String[] args)
    {
	Stack<String> collection = new Stack<String>();
	collection.push("hello");
	collection.pop();
    }
    
}
    
