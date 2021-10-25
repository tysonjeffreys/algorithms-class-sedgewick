import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>
{
    private Node first; //first node in list

    private class Node
    {
	Item item;
	Node next;
    }

    public void add(Item item)
    { //same as push() in Stack
	Node oldfirst = first;
	first  = new Node();
	first.item = item;
	first.next = oldfirst;
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
	    System.out.println(item);
	    return item;
	}
    }

    public static void main(String[] args)
    {
	Bag<String> collection = new Bag<String>();
	collection.add("It's");
	collection.add("not");
	collection.add("my");
	collection.add("bag");
	Iterator<String> i = collection.iterator();
	i.next();
    }
}
