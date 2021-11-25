import org.junit.Test;

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
}
