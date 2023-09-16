package part2;

public class Node<E> {
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> Node) {
        item = newItem;
        next = Node;
    }

    public E getItem() {
        return item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setItem(E newItem) {
        this.item = newItem;
    }

    public void setNext(Node<E> newNext) {
        this.next = newNext;
    }
}
