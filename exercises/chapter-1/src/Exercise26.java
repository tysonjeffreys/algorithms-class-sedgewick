import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise26<Item> implements Iterable<Item> {
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

    public boolean find(Exercise26<Item> stringList, Item key) {
        for (Item value : stringList) {
            if (value.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Node findNode(Exercise26<Item> itemList, Item key) {
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
        for (Exercise26<Item>.Node current = first; current != null; current = current.next) {
            if (current.equals(node) && current.next != null) {
                current.next = current.next.next;
                n--;
                break;
            }
        }
    }

    public void remove(Exercise26<Item> itemList, String key) {
        if (isEmpty() || key == null) return;
        int k = 1;
        for (Node current = itemList.first; current != null; current = current.next) {
            if (current.item.equals(key)) {
                delete(k);
                continue;
            }
            k++;
        }
    }

    public void insertAfter(Node node1, Node node2) {
        if (isEmpty() || node1 == null || node2 == null) return;
        for (Exercise26<Item>.Node current = first; current != null; current = current.next) {
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
        Exercise26<String> exercise26 = new Exercise26<>();
        //LinkedList<String> linkList = new LinkedList<>();
        exercise26.add("ground control");
        exercise26.add("to");
        exercise26.add("major tom");
        exercise26.add("ground control");
        exercise26.add("ground control");

        //Exercise26<String>.Node node = exercise26.findNode(exercise26, "major tom");
        //exercise25.removeAfter(node);
        //Exercise26<String>.Node node2 = exercise26.createNode("sitting in a tin can");
        //exercise26.insertAfter(node, node2);
        exercise26.remove(exercise26, "ground control");
        Iterator<String> i = exercise26.iterator();

        while (i.hasNext()) {
            StdOut.println(i.next());
        }
    }
}
