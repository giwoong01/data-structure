package part2;

import java.util.NoSuchElementException;

public class SList<E> {

    protected Node<E> head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    public int search(E target) {
        Node<E> p = head;

        for (int k = 0; k < size; k++) {
            if (p.getItem() == target) { // 원래 코드는 p.getItem().compareTo(target) == 0인데 compareTo함수를 우째 짜야할지 몰겠음. 근데 == 0 인것을 보니 같다는 경우 인듯하여 이꼴사용.
                return k;
            }

            p = p.getNext();
        }

        return -1;
    }

    public void insertFront(E newItem) {
        head = new Node<>(newItem, head);
        size++;
    }

    public void insertAfter(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    public void deleteFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        head = head.getNext();
        size--;
    }

    public void deleteAfter(Node p) {
        if (p == null) {
            throw new NoSuchElementException();
        }

        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
