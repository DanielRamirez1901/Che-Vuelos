import java.util.*;

public class Graph<T> {
    private int v;
    private final LinkedList<Integer>[] adjList;
    private int vDfs;
    private LinkedList<Integer> adjDfs[];
    private int dist[];
    private Set<T> settled;
    private PriorityQueue<Node<T,Integer>> pq;
    private List<List<Node<T,Integer>>> adj;

    // Constructor
    public Graph(int vx) {
        v = vx;
        vDfs = vx;
        adjList = new LinkedList[v];
        adjDfs = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adjList[i] = new LinkedList();
            adjDfs[i] = new LinkedList();
        }
    }

    public void addEdge(int v,int w) {
        adjList[v].add(w);
        adjDfs[v].add(w);
    }

    //***********************BFS*************************
    public void BFS(int s) {
        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print("["+s+"]");
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    //***********************DFS*************************

    // A function used by DFS
    public void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print("["+v+"]");

        Iterator<Integer> i = adjDfs[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public void DFS(int v) {
        boolean visited[] = new boolean[vDfs];
        DFSUtil(v, visited);
    }


    //***********************dijkstra*************************
    public void dijkstra(List<List<Node<T,Integer>> > adj, Node<T,Integer> src) {
        this.adj = adj;
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new Node(src.getNode(), 0));
        dist[src.getCost()] = 0;
        while (settled.size() != v) {
            if (pq.isEmpty()) {
                return;
            }
            Node<T,Integer> u = pq.remove();
            if (settled.contains(u.getNode()))

            settled.add(u.getNode());

            e_Neighbours(u.getCost());
        }
    }

    private void e_Neighbours(int u) {

        int edgeDistance = -1;
        int newDistance = -1;


        for (int i = 0; i < adj.get(u).size(); i++) {
            Node<T,Integer> v = adj.get(u).get(i);
            if (!settled.contains(v.getNode())) {
                edgeDistance = v.getCost();
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.getCost()])
                    dist[v.getCost()] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.getNode(), dist[v.getCost()]));
            }
        }
    }



    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
        System.out.println("\n");
        g.DFS(2);
    }


}

