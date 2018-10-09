package ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyGraph {
    static class Node {
        int value;
        Set<Node> nodeList;

        public Node(int value) {
            this.value = value;
            this.nodeList = new HashSet<>();
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Set<Node> getNodeList() {
            return nodeList;
        }

        public void setNodeList(Set<Node> nodeList) {
            this.nodeList = nodeList;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", nodeList=" + nodeList +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            return value == node.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    List<Node> adjacencyList;

    public void addEdge(Node source, Node dest) {
        source.getNodeList().add(dest);
        if(adjacencyList == null) {
            adjacencyList = new ArrayList<>();
        }
        adjacencyList.add(source);
    }

    @Override
    public String toString() {
        return "MyGraph{" +
                "adjacencyList=" + adjacencyList +
                '}';
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        graph.addEdge(node0,node1);
        graph.addEdge(node0, node4);
        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node1, node4);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node4);

        System.out.println(graph);
    }


}
