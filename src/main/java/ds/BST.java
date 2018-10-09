package ds;

public class BST {

    Node root;

    public Node addNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (root.value > value) {
            root.left = addNode(root.left, value);
        } else if (root.value < value) {
            root.right = addNode(root.right, value);
        }
        return root;
    }

    public void deleteNode(int value) {

    }

    public Node findNode(Node root, int value) {
        if (root.value == value) {
            return root;
        } else if (root.value > value) {
            root = findNode(root.left, value);
        } else {
            root = findNode(root.right, value);
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.println(root.value);
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        System.out.println(root.value);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(Node root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.value >= maxVal || root.value <= minVal) return false;
        return isValidBST(root.left, minVal, root.value) && isValidBST(root.right, root.value, maxVal);
    }

    public void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.println(root.value);
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = bst.addNode(bst.root, 8);
        bst.addNode(bst.root, 5);
        bst.addNode(bst.root, 4);
        bst.addNode(bst.root, 6);
        bst.addNode(bst.root, 9);
        bst.addNode(bst.root, 10);
        bst.inOrder(bst.root);
        bst.preOrder(bst.root);
        bst.postOrder(bst.root);

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
