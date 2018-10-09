package ds;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    int numOfVertices;
    LinkedList<Integer>[] adjacencyListArray;

    public boolean IS_DIRECTED=false;

    public Graph(int numOfVertices, boolean isDirected) {
        this.numOfVertices = numOfVertices;
        IS_DIRECTED = isDirected;
        adjacencyListArray = new LinkedList[numOfVertices];
        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new LinkedList();
        }
    }

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        adjacencyListArray = new LinkedList[numOfVertices];
        for (int i = 0; i < adjacencyListArray.length; i++) {
            adjacencyListArray[i] = new LinkedList();
        }
    }

    void addEdge(int source, int dest) {
        adjacencyListArray[source].add(dest);
        if(!IS_DIRECTED) {
            adjacencyListArray[dest].add(source);
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "numOfVertices=" + numOfVertices +
                ", adjacencyListArray=" + Arrays.toString(adjacencyListArray) +
                ", IS_DIRECTED=" + IS_DIRECTED +
                '}';
    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[numOfVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjacencyListArray[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjacencyListArray[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[numOfVertices];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    public static void main(String args[])
    {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println(graph);
        graph.BFS(2);
    }


}
