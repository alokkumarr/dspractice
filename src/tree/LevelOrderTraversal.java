package tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class LevelOrderTraversal {


  void printLevelOrder(Node root){

    Queue<Node> queue = new PriorityQueue<>();

    Node tempNode = root;

    while (tempNode != null){
      // print the data
      System.out.println(tempNode.data);

      // enqueue the children (fist left then right)
      queue.add(tempNode.left);
      queue.add(tempNode.right);

      // deque a node from queue and assign to temp node
      tempNode = queue.poll();
    }
  }

}

class Node {
  Object data;
  Node left;
  Node right;

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
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