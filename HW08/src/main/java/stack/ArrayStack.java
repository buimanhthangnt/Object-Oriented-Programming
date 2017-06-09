package stack;

import java.util.Iterator;

public class ArrayStack<Item> implements StackOfAllTypes<Item>, Iterable {
    private Item[] data;
    private int index;

    public ArrayStack() {
        data = (Item[]) new Object[222];
        index = 0;
    }

    public void push(Item s) {
        data[index] = s;
        index++;
    }

    public Item pop() {
        if (index == 0) return null;
        index--;
        Item temp = data[index];
        data[index] = null;
        return temp;
    }

    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {
        private int index2 = index - 1;
        public boolean hasNext() {
            return index2 >= 0;
        }

        public Item next() {
            Item temp = data[index2];
            data[index2] = null;
            index2--;
            return temp;
        }
    }
}
