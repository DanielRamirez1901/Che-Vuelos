import java.util.Comparator;

public class Node<T,Integer> implements Comparator<Node>{
    private T node;
    private int cost;

    public Node(T node, int cost){
        this.node = node;
        this.cost = cost;
    }


    public T getNode() {return node;}
    public void setNode(T node) {this.node = node;}

    public int getCost() {return cost;}
    public void setCost(int cost){this.cost = cost;}


    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost)
            return -1;

        if (node1.cost > node2.cost)
            return 1;

        return 0;
    }

}