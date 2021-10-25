import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise24<Item> implements Iterable<Item> {
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

    public boolean find(Exercise24<Item> stringList, Item key) {
        for (Item value : stringList) {
            if (value.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Node findNode(Exercise24<Item> itemList, Item key) {
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
        for (Exercise24<Item>.Node current = first; current != null; current = current.next) {
            if (current.item.equals(node.item) && current.next != null) {
                current.next = current.next.next;
                n--;
                break;
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
        Exercise24<String> exercise24 = new Exercise24<>();
        //LinkedList<String> linkList = new LinkedList<>();
        exercise24.add("ground control");
        exercise24.add("to");
        exercise24.add("major tom");
        Exercise24<String>.Node node = exercise24.findNode(exercise24, "to");
        exercise24.removeAfter(node);

        Iterator<String> i = exercise24.iterator();

        while (i.hasNext()) {
            StdOut.println(i.next());
        }

    }
}
