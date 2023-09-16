package part2;

import java.util.NoSuchElementException;

public class CList<E> {
    private Node last;
    private int size;

    public CList() {
        last = null;
        size = 0;
    }

    public void insert(E newItem) {
        Node newNode = new Node(newItem, null);
        if (last == null) {
            newNode.setNext(newNode);
            last = newNode;
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    public Node delete() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node x = last.getNext();
        if (x == last) {
            last = null;
        } else {
            last.setNext(x.getNext());
            x.setNext(null);
        }
        size--;
        return x;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
