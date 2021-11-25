import java.util.*;

public class Graph<T> {

    //Attributes BFS******************************
    private int vertexInBfs;
    private LinkedList<Integer>[] listBfs;
    //Attributes DFS******************************
    private int vertexInDfs;
    private LinkedList<Integer> [] listDfs;
    //Attributes Dij******************************
    private int dist[];
    private Set<T> settled;
    private PriorityQueue<Node<T,Integer>> pq;
    private List<List<Node<T,Integer>>> adj;
    //AttributesFloyd******************************
    private int floydNumber = 99999;
    private int vertexInFloyd = 4;
    //AttributesPrims******************************
    private int vertexInPrim = 5;
    //AttributesKruskal****************************
    private int vertexInKruskal = 5;
    private int[] parent = new int[vertexInKruskal];
    private int valueInfInKruskal = Integer.MAX_VALUE;

    // Constructor
    public Graph(int vx) {
        vertexInBfs = vx;
        vertexInDfs = vx;
        listBfs = new LinkedList[vertexInBfs];
        listDfs = new LinkedList[vertexInBfs];
        for (int i = 0; i< vertexInBfs; ++i) {
            listBfs[i] = new LinkedList();
            listDfs[i] = new LinkedList();
        }
    }

    public void addEdge(int vx,int wd) {
        listBfs[vx].add(wd);
        listDfs[vx].add(wd);
    }

    //***********************BFS*************************

    public void BFS(int source) {
        boolean[] alreadyVisited = new boolean[vertexInBfs];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        alreadyVisited[source]=true;
        queue.add(source);
        while (queue.size() != 0) {
            source = queue.poll();
            System.out.print("["+source+"]");
            for (int n : listBfs[source]) {
                if (!alreadyVisited[n]) {
                    alreadyVisited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    //***********************DFS*************************


    private void dfsSearch(int v, boolean[] vtxVisited) {
        vtxVisited[v] = true;
        System.out.print("["+v+"]");
        for (int n : listDfs[v]) {
            if (!vtxVisited[n])
                dfsSearch(n, vtxVisited);
        }
    }

    public void DFS(int v) {
        boolean[] vtxVisited = new boolean[vertexInDfs];
        dfsSearch(v, vtxVisited);
    }


    //***********************dijkstra*************************

    public void dijkstra(List<List<Node<T,Integer>> > adj, Node<T,Integer> src) {
        this.adj = adj;
        for (int i = 0; i < vertexInBfs; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new Node(src.getNode(), 0));
        dist[src.getCost()] = 0;
        while (settled.size() != vertexInBfs) {
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

    //**********************FloydWarshall**********************

    public int[][] floydWarshall(int graph[][]) {
        int dist[][] = new int[vertexInFloyd][vertexInFloyd];
        int i, j, k;
        for (i = 0; i < vertexInFloyd; i++)
            for (j = 0; j < vertexInFloyd; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < vertexInFloyd; k++) {
            for (i = 0; i < vertexInFloyd; i++) {
                for (j = 0; j < vertexInFloyd; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist);
        return dist;
    }

    private void printSolution(int dist[][]) {
        for (int i = 0; i< vertexInFloyd; ++i)
        {
            for (int j = 0; j< vertexInFloyd; ++j)
            {
                if (dist[i][j]==floydNumber)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    //*********************Prim'sAlgorithm*********************

    private int minKeyInG(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < vertexInPrim; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printMST(int parent[], int graph[][]) {
        System.out.println("E \tW");
        for (int i = 1; i < vertexInPrim; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public void primAlgorithm(int[][] graph) {
        int[] parent = new int[vertexInPrim];
        int[] key = new int[vertexInPrim];
        Boolean[] mstSet = new Boolean[vertexInPrim];
        for (int i = 0; i < vertexInPrim; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < vertexInPrim - 1; count++) {
            int u = minKeyInG(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < vertexInPrim; v++)
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        printMST(parent, graph);
    }

    //*********************Kruskal Algorithm********************

    private int findValue(int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    private void union(int i, int j) {
        int a = findValue(i);
        int b = findValue(j);
        parent[a] = b;
    }

    public void kruskalAlgorithm(int[][] cost) {
        int mincost = 0; // Cost of min MST.
        for (int i = 0; i < vertexInKruskal; i++) {
            parent[i] = i;
        }
        int edge_count = 0;
        while (edge_count < vertexInKruskal - 1) {
            int min = valueInfInKruskal, a = -1, b = -1;
            for (int i = 0; i < vertexInKruskal; i++) {
                for (int j = 0; j < vertexInKruskal; j++) {
                    if (findValue(i) != findValue(j) && cost[i][j] < min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            union(a, b);
            System.out.printf("Edge %d:(%d, %d) cost:%d \n",
                    edge_count++, a, b, min);
            mincost += min;
        }
        System.out.printf("\n Minimum cost= %d \n", mincost);
    }

    /*
    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
        System.out.println("\n");
        g.DFS(2);
        Graph g2 = new Graph(4);
        int[][] graph = { {0,   5, g2.floydNumber, 10},
                {g2.floydNumber, 0,   3, g2.floydNumber},
                {g2.floydNumber, g2.floydNumber, 0,   1},
                {g2.floydNumber, g2.floydNumber, g2.floydNumber, 0}
        };
        g2.floydWarshall(graph);

        Graph g3 = new Graph(4);
        int[][] graph2 = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        g3.primAlgorithm(graph2);

        Graph g4 = new Graph(4);
        int cost[][] = {
                { g4.valueInfInKruskal, 2, g4.valueInfInKruskal, 6, g4.valueInfInKruskal },
                { 2, g4.valueInfInKruskal, 3, 8, 5 },
                { g4.valueInfInKruskal, 3, g4.valueInfInKruskal, g4.valueInfInKruskal, 7 },
                { 6, 8, g4.valueInfInKruskal, g4.valueInfInKruskal, 9 },
                { g4.valueInfInKruskal, 5, 7, 9, g4.valueInfInKruskal },
        };

        g4.kruskalAlgorithm(cost);
    }

     */


    //Setters&Getters*********************************************


    public int getFloydNumber() {
        return floydNumber;
    }
}

