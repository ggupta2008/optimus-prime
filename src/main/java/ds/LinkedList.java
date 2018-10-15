package ds;


class Node {
    int value;
    Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

public class LinkedList {
    Node root;

    public LinkedList() {
        root = new Node();
    }

    public Node addNode(Node node){
        if(node == null) return null;
        node.next = root.next;
        root.next = node;
        return node;
    }

    public Node removeNode(){
        Node temp = root.next;
        root.next = temp.next;
        temp.next = null;
        return temp;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "root=" + root + '}';
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(new Node(10));
        linkedList.addNode(new Node(5));
        linkedList.removeNode();
        linkedList.removeNode();
        System.out.println(linkedList);
    }
}
