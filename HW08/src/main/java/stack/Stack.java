package stack;

import java.util.Iterator;

public class Stack <Item> implements StackOfAllTypes<Item>, Iterable<Item>{
    private class Node {
        private Item data;
        private Node next;
        public Node (Item s, Node n) {
            data = s;
            next = n;
        }
        public Item getData() {
            return data;
        }
    }
    private Node head;

    public Stack() {
        head = null;
    }

    public void push(Item s) {
        head = new Node(s,head);
    }

    public Item pop() {
        if (head == null) return null;
        Item temp = head.getData();
        head = head.next;
        return temp;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<Item>{
        private Node current = head;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.getData();
            current = current.next;
            return item;
        }
        public void remove() {}
    }
}
