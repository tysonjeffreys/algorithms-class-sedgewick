

public class Queue<Item>
{
    private Node first; //link to least recently added node
    private Node last; //link to most recently added node
    private int n;

    private class Node
    {
	Item item;
	Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return n; }

    public void enqueue( Item item)
    { //Add item to end of the list
	Node oldlast = last;
	last = new Node();
	last.item = item;
	last.next = null;
	if (isEmpty()) first = last;
	else oldlast.next = last;
	n++;
    }

    public Item dequeue()
    { //Remove item from the beginning of the list
	//System.out.println("Dequeue is empty at the beginning");
	Item item = first.item;
	first = first.next;
	n--;
	if (isEmpty()) last = null;
	System.out.println(item);
	return item;
    }


    public static void main(String[] args)
    {
	Queue<String> collection = new Queue<String>();
	collection.enqueue("first entry");
	collection.dequeue();
    }
}
	

	
       
