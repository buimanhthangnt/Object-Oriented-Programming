package stacks;

public class ArrayStack implements StackOfString {
    private String[] data;
    private int index;

    public ArrayStack() {
        data = new String[222];
        index = 0;
    }

    public void push(String s) {
        data[index] = s;
        index++;
    }

    public String pop() {
        if (index == 0) return null;
        index--;
        String temp = data[index];
        data[index] = null;
        return temp;
    }

    public String toString() {
        String s = "[";
        int i = index - 1;
        while (i >= 0) {
            s += data[i];
            if (i != 0) s += ", ";
            i--;
        }
        return s + "]";
    }
}
