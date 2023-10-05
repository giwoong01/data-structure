package part4;

public class UnionFindNode {
    int parent;
    int rank;

    public UnionFindNode(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

    public int getParent() {
        return parent;
    }

    public int getRank() {
        return rank;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
