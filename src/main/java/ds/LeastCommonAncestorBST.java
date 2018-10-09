package ds;

public class LeastCommonAncestorBST {

    Node leastCommonAncestor(Node root, Node n1, Node n2) {
        while(root != null) {
            if(root.value > n1.value && root.value > n2.value) {
                root = root.left;
            }
            else if(root.value < n1.value && root.value < n2.value) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }


    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
