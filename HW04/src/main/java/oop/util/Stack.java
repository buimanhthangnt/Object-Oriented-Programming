package oop.util;

public class Stack {
    private class Node {
        private String data;
        private Node next;
        private Node(String s) {
            data = s;
        }
    }
    private Node head;
    private long size;

    public Stack() {
        size = 0;
        head = null;
    }
    public long getSize() {return size;}
    public boolean isEmpty() {return size <= 0;}
    public void push(String s) {
        Node newNode = new Node(s);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public String pop() {
        if (isEmpty()) return "";
        String temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
    public String top() {
        return head.data;
    }
}
