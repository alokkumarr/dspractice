package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

  public static void main(String[] args) {
    /**
     *        10
     *     /     \
     *    20     30
     *   /  \    / \
     *  40   50 60  70
     */
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(50);
    root.right.left = new Node(60);
    root.right.right = new Node(70);

    printLevelOrderLineByLine(root);
  }

  static void printLevelOrder(Node root){
    if (root == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node tmp = queue.poll();
      System.out.print(tmp.data + "->");
      if (tmp.left != null) {
        queue.add(tmp.left);
      } else if (tmp.right != null){
        queue.add(tmp.right);
      }
    }
  }

  // even it has two loops but the complexity is O(n)
  // because we are adding and removing the queue
  static void printLevelOrderLineByLine(Node root){
    if (root == null) return;

    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int nodeCount= q.size();

      // Dequeue all nodes of current level and Enqueue all
      // nodes of next level
      while(nodeCount > 0) {
        Node node = q.poll();
        System.out.print(node.data + " ");

        if(node.left != null)
          q.add(node.left);
        if(node.right != null)
          q.add(node.right);

        nodeCount--;
      }
      System.out.println();
    }
  }
}