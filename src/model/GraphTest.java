import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GraphTest {

    public <T> Graph<T> setupStage1(){
        return new Graph<T>(4);
    }
    public <T> Graph<T> setupStage2(){
        Graph<T> graph = new Graph<>(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        return graph;
    }

    @Test
    public void bfsTest(){

        Graph graph = setupStage1();
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(0);
        arr.add(3);
        arr.add(1);
        graph.BFS(2);
        ArrayList<Integer> orderInBfs = new ArrayList<>();
        orderInBfs.add(2);
        orderInBfs.add(0);
        orderInBfs.add(3);
        orderInBfs.add(1);
        assertEquals(arr,orderInBfs);
    }

    @Test
    public void dfsTest(){

        Graph graph = setupStage1();
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(0);
        arr.add(1);
        arr.add(3);
        ArrayList<Integer> orderInDfs = new ArrayList<>();
        orderInDfs.add(2);
        orderInDfs.add(0);
        orderInDfs.add(1);
        orderInDfs.add(3);
        graph.DFS(2);
        assertEquals(arr,orderInDfs);

    }

    @Test
    public void floydTest(){
        Graph g = setupStage1();
        int graph[][] = { {0,   5,  g.getFloydNumber(), 10},
                {g.getFloydNumber(), 0,   3, g.getFloydNumber()},
                {g.getFloydNumber(), g.getFloydNumber(), 0,   1},
                {g.getFloydNumber(), g.getFloydNumber(), g.getFloydNumber(), 0}};
        int graph2[][] = { {0,   5,  8, 9},
                {g.getFloydNumber(), 0,   3, 4},
                {g.getFloydNumber(), g.getFloydNumber(), 0,   1},
                {g.getFloydNumber(), g.getFloydNumber(), g.getFloydNumber(), 0}};
        assertArrayEquals(graph2,g.floydWarshall(graph));
    }

    @Test
    public void primAlgorithmTest(){
        Graph g = setupStage1();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        int graph2[][] = { {0,1,2},
                {1,2,3},
                {0,2,3},
                {1,4,5}};
        g.primAlgorithm(graph);
        int graphExpected[][] = { {0,1,2},
                {1,2,3},
                {0,2,3},
                {1,4,5}};
        assertArrayEquals(graph2,graphExpected);
    }

}
