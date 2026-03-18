public class DistributionCandy {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int moves = 0;

    public static void main(String[] args) {

        /*
              3
             / \
            0   0
        */

        Node root = new Node(3);
        root.left = new Node(0);
        root.right = new Node(0);

        DistributionCandy obj = new DistributionCandy();
        int result = obj.distCandy(root);

        System.out.println("Minimum moves required: " + result);
    }

    public int distCandy(Node root) {
        dfs(root);
        return moves;
    }

    private int dfs(Node node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        moves += Math.abs(left) + Math.abs(right);

        return node.data + left + right - 1;
    }
}