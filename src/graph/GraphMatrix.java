package graph;

public class GraphMatrix {

  private boolean addMatrix[][];
  private int vertexCount;

  public GraphMatrix(int vertexCount) {
    this.vertexCount = vertexCount;
    addMatrix = new boolean[vertexCount][vertexCount];
  }

  public void addEdge(int i, int j) {
    if (i >= 0 && i < vertexCount && j >0 && j < vertexCount) {
      addMatrix[i][j] = true;
      addMatrix[j][i] = true;
    }
  }

  public void removeEdge(int i, int j) {
    if (i >= 0 && i < vertexCount && j >0 && j < vertexCount) {
      addMatrix[i][j] = true;
      addMatrix[j][i] = true;
    }
  }

  public boolean isEdge(int i, int j) {
    if (i >= 0 && i<vertexCount && j>0 && j < vertexCount) {
      return addMatrix[i][j];
    }
    return false;
  }
}
