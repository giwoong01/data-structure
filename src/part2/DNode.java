package part2;

public class DNode<E> {
    private E item;
    private DNode previous;
    private DNode next;

    public DNode(E newItem, DNode p, DNode q) {
        item = newItem;
        previous = p;
        next = q;
    }

    public E getItem() {
        return item;
    }

    public DNode getPrevious() {
        return previous;
    }

    public DNode getNext() {
        return next;
    }

    public void setItem(E newItem) {
        this.item = newItem;
    }

    public void setPrevious(DNode p) {
        this.previous = p;
    }

    public void setNext(DNode q) {
        this.next = q;
    }
}
