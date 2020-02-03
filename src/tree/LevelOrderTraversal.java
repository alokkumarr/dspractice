package tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class LevelOrderTraversal {


  void printLevelOrder(Node1 root){

    Queue<Node1> queue = new PriorityQueue<>();

    Node1 tempNode = root;

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

class Node1 {
  Object data;
  Node1 left;
  Node1 right;

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Node1 getLeft() {
    return left;
  }

  public void setLeft(Node1 left) {
    this.left = left;
  }

  public Node1 getRight() {
    return right;
  }

  public void setRight(Node1 right) {
    this.right = right;
  }
}