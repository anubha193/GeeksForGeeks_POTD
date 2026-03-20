import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {

    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(Integer.MIN_VALUE); // predecessor
        al.add(Integer.MAX_VALUE); // successor

        inorderTraversal(root, key, al);

        ArrayList<Node> res = new ArrayList<>();

        Node pre = null, suc = null;

        if (al.get(0) != Integer.MIN_VALUE) {
            pre = new Node(al.get(0));
        }
        if (al.get(1) != Integer.MAX_VALUE) {
            suc = new Node(al.get(1));
        }

        res.add(pre);
        res.add(suc);

        return res;
    }

    static void inorderTraversal(Node node, int key, ArrayList<Integer> al) {
        if (node == null) return;

        inorderTraversal(node.left, key, al);

        if (node.data < key && node.data > al.get(0)) {
            al.set(0, node.data);
        }

        if (node.data > key && node.data < al.get(1)) {
            al.set(1, node.data);
        }

        inorderTraversal(node.right, key, al);
    }
}

class FindPreSuc {   // ✅ renamed main class

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        Solution obj = new Solution();
        int key = 65;

        ArrayList<Node> res = obj.findPreSuc(root, key);

        System.out.println("Predecessor: " + (res.get(0) != null ? res.get(0).data : "null"));
        System.out.println("Successor: " + (res.get(1) != null ? res.get(1).data : "null"));
    }
}