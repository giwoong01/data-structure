package part4;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparator<Key>> {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void preorder(Node n) { // 전위 순회
        if (n != null) {
            System.out.println(n.getKey() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    public void inorder(Node n) { // 중위 순회
        if (n != null) {
            inorder(n.getLeft());
            System.out.println(n.getKey() + " ");
            inorder(n.getRight());
        }
    }

    public void postorder(Node n) { // 후위 순회
        if (n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.println(n.getKey() + " ");
        }
    }

    public void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        Node t;
        q.add(root);
        while (!q.isEmpty()) {
            t = q.remove();
            System.out.println(t.getKey() + " ");
            if (t.getLeft() != null) {
                q.add(t.getLeft());
            }
            if (t.getRight() != null) {
                q.add(t.getRight());
            }
        }
    }

    public int size(Node n) {
        if (n == null) {
            return 0;
        } else {
            return (1 + size(n.getLeft()) + size(n.getRight()));
        }
    }

    public int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
        }
    }

    public static boolean isEqual(Node n, Node m) {
        if (n == null || m == null) {
            return n == m;
        }

        if (n.getKey().compareTo(m.getKey()) != 0) {
            return false;
        }

        return (isEqual(n.getLeft(), m.getRight()) && isEqual(n.getRight(), m.getRight()));
    }
}
