package ds;

public class RootToLeafPathSum {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left=right=null;
        }
    }

    public boolean hasPath(Node root, int sum) {
        boolean result = false;
        if(root != null) {
            int subSum = sum - root.data;
            if(subSum == 0 && root.left == null && root.right == null) {
                result = true;
            } else if(root.left != null) {
                return hasPath(root.left, subSum);
            } else if(root.right != null) {
                return hasPath(root.right, subSum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        RootToLeafPathSum rootToLeafPathSum = new RootToLeafPathSum();
        boolean result = rootToLeafPathSum.hasPath(root, 29);
        System.out.println(result);
    }
}
