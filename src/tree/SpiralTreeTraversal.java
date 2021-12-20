package tree;

import java.util.*;

public class SpiralTreeTraversal {

    public static void main(String[] args) {
        /**
         *        10
         *     /     \
         *    20     30
         *   /  \    / \
         *  40   50 60  70
         *
         *  Output -> 10 30 20 40 50 60 70
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        //spiralTraversal(root);
        System.out.println();
        //spiralTraversalBestSol(root);

        System.out.println();
        System.out.println("------------------------");
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(30);
        treeNode.left.left = new TreeNode(40);
        treeNode.left.right = new TreeNode(50);
        treeNode.right.left = new TreeNode(60);
        treeNode.right.right = new TreeNode(70);

        Solution s = new Solution();
        System.out.println(s.zigzagLevelOrder(treeNode));
    }


    private static void spiralTraversalBestSol(Node root) {
        if (root == null) return;

        Stack<Node> s1 = new Stack<>();
        s1.push(root);
        Stack<Node> s2 = new Stack<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node tmp = s1.pop();
                System.out.print(tmp.data + " ");

                // push data in sq left then right
                if (tmp.left != null) s2.push(tmp.left);
                if (tmp.right != null) s2.push(tmp.right);
            }

            while (!s2.isEmpty()) {
                Node tmp = s2.pop();
                System.out.print(tmp.data + " ");

                // push data in sq right then left
                if (tmp.right != null) s1.push(tmp.right);
                if (tmp.left != null) s1.push(tmp.left);            }
        }

    }
    // level order traversal line by line but printing the line use
    // Stack to print data in reverse
    // O(n)
    private static void spiralTraversal(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Stack<Integer> stack  = new Stack<>();
        boolean reverse = false;
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i =0; i < count; i++) {
                Node cur = q.poll();
                if (reverse) {
                    //while (!q.isEmpty())
                    stack.push(cur.data);
                } else {
                    System.out.print(cur.data + " ");
                }

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

            if (reverse) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
            }
            reverse = !reverse;
        }
    }
}


class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Stack<Integer> s = new Stack();
        boolean reverse = false;

        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int count = q.size();
            for(int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (reverse) {
                    s.push(curr.val);
                } else {
                    //System.out.print(curr.val + " ");
                    list.add(curr.val);
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            if (reverse) {
                while (!s.isEmpty()) {
                    int data = s.pop();
                    //System.out.print(data + " ");
                    list.add(data);
                }
            }
            reverse = !reverse;
            //System.out.println();
            //System.out.println(list);
            result.add(list);
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}