package stacks;

public class LinkedListStack implements StackOfString {
    private class Node {
        private String data;
        private Node next;
        public Node (String s, Node n) {
            data = s;
            next = n;
        }
        public String getData() {
            return data;
        }
    }
    private Node head;
    private long size;

    public LinkedListStack() {
        head = null;
        size = 0;
    }

    public void push(String s) {
        head = new Node(s,head);
        size++;
    }

    public String pop() {
        if (head == null) return null;
        String temp = head.getData();
        head = head.next;
        size--;
        return temp;
    }

    public String toString() {
        String s = "[";
        Node p = head;
        while (p != null) {
            s += p.getData();
            if (p.next != null) s += ", ";
            p = p.next;
        }
        s += "]";
        return s;
    }
}
