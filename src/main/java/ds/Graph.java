package ds;

import java.util.LinkedList;

public class Graph {
    int NumOfVertices;
    LinkedList<Integer>[] adjacencyListArray;

    public Graph(int numOfVertices) {
        this.NumOfVertices = numOfVertices;
        adjacencyListArray = new LinkedList[numOfVertices];
        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new LinkedList();
        }
    }

    void addEdge(int source, int dest) {
        adjacencyListArray[source].add(dest);
    }
}
