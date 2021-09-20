package stack;

public class ListStack {
  Node top;
  ListStack() {
    this.top = null;
  }

  public void push(int x) {
    Node temp = new Node(x);
    if (temp == null) {
      System.out.print("\nHeap Overflow");
      return;
    }
    temp.next = top;
    top = temp;
  }

  public int peek() {
    if (top == null) {
      System.out.println("Empty Stack");
      return -1;
    }
    return top.data;
  }

  public void pop() {
    if (top == null) {
      System.out.print("\nStack Underflow");
      return;
    }
    top = top.next;
  }

  public void display() {
    if (top == null) {
      System.out.printf("\nStack Underflow");
      return;
    }
    Node temp = top;
    while (temp != null) {
      System.out.printf("%d->", temp.data);
      temp = temp.next;
    }
  }

  public boolean isEmpty() {
    return top == null;
  }

  public static void main(String[] args) {
    ListStack listStack = new ListStack();
    listStack.push(10);
    listStack.push(20);
    listStack.push(30);
    listStack.push(40);
    listStack.push(60);

    listStack.display();
    System.out.println();
    System.out.println(listStack.peek());
    listStack.peek();
    System.out.println();
    listStack.display();
    listStack.pop();
    System.out.println();
    listStack.display();
  }
}

