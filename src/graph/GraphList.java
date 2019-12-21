package graph;

import java.util.ArrayList;

public class GraphList {



  private ArrayList<Integer> vertices;
  private ListNode[] edges;
  private int vertexCount = 0;

  public GraphList(int vertexCount) {
    this.vertexCount = vertexCount;
    vertices = new ArrayList<>();
    edges = new ListNode[vertexCount];
    for (int i = 0; i < vertexCount; i++) {
      vertices.add(i);
      edges[i] = new ListNode();
    }
  }

  public void addEdge(int source, int destination) {
    int i = vertices.indexOf(source);
    int j = vertices.indexOf(destination);
    if (i != -1 || j != -1) {
      edges[i].insertAtBeginning(destination);
      edges[j].insertAtBeginning(source);
    }
  }

  class ListNode {
    private ListNode node;
    private int data;

    ListNode() {
      node = new ListNode();
    }

    public void insertAtBeginning(int data) {

    }
  }
}
