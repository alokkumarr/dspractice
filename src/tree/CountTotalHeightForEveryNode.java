package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountTotalHeightForEveryNode {
    public static void main(String[] args) {
          /*
                 10    - 0
              /     \
             20     30   - 1
            /  \     / \
           40   50  10  60  - 2

           Output = 8
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(10);
        root.right.right = new Node(60);

        int totalCount = totalWidthCount(root);
        System.out.println(totalCount);
    }

    private static int totalWidthCount(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int totalCount = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count -- > 0) {
                Node tmp = queue.poll();
                totalCount += level;

                assert tmp != null;
                if(tmp.left != null)
                    queue.add(tmp.left );
                if (tmp.right != null)
                    queue.add(tmp.right );
            }
            level += 1;
        }
        return totalCount;
    }
}
