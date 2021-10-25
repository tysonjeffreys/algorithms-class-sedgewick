import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise25<Item> implements Iterable<Item> {
    private Node first;
    private int n;


    private class Node {
        Item item;
        Node next;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        //StdOut.println(first.item);
        n++;
        StdOut.println(n);
    }

    public Node createNode(Item item) {
        Node node = new Node();
        node.item = item;
        return node;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;

        return item;

    }

    public void removeLast() {
        if (!isEmpty()) {
            if (n == 1) {
                first = null;
            } else {

                //Node current = first;
                for (int i = 0; i < n - 2; i++) {
                    first = first.next;

                }
                first.next = null;
                n--;

            }
        }
    }

    public void delete(int k) {
        int count = 1;
        if (k > n || isEmpty()) {
            return;
        }
        if (k == 1) {
            first = first.next;
        } else {
            for (Node current = first; current != null; current = current.next) {
                if (count == k - 1 && current.next != null) {
                    current.next = current.next.next;
                    break;
                }
                count++;

            }

        }
        n--;
    }

    public boolean find(Exercise25<Item> stringList, Item key) {
        for (Item value : stringList) {
            if (value.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Node findNode(Exercise25<Item> itemList, Item key) {
        Node node;
        for (Node current = itemList.first; current != null; current = current.next) {
            if (current.item.equals(key)) {
                node = current;
                return node;
            }
        }
        return null;
    }

    public void removeAfter(Node node) {
        if (isEmpty() || node == null) return;
        for (Exercise25<Item>.Node current = first; current != null; current = current.next) {
            if (current.equals(node) && current.next != null) {
                current.next = current.next.next;
                n--;
                break;
            }
        }
    }

    public void insertAfter(Node node1, Node node2) {
        if (isEmpty() || node1 == null || node2 == null) return;
        for (Exercise25<Item>.Node current = first; current != null; current = current.next) {
            if (current.equals(node1)) {
                node2.next = current.next;
                current.next = node2;
            }
        }
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
        Exercise25<String> exercise25 = new Exercise25<>();
        //LinkedList<String> linkList = new LinkedList<>();
        exercise25.add("ground control");
        exercise25.add("to");
        exercise25.add("major tom");
        Exercise25<String>.Node node = exercise25.findNode(exercise25, "major tom");
        //exercise25.removeAfter(node);
        Exercise25<String>.Node node2 = exercise25.createNode("sitting in a tin can");
        exercise25.insertAfter(node, node2);
        Iterator<String> i = exercise25.iterator();

        while (i.hasNext()) {
            StdOut.println(i.next());
        }

    }
}
