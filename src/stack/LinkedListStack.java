package stack;

public class LinkedListStack {

  public static void main(String[] args) {
    LinkedListStack linkedListStack = new LinkedListStack();
    linkedListStack.push(10);
    linkedListStack.push(20);
    linkedListStack.push(30);
    linkedListStack.push(40);
    linkedListStack.push(60);
    System.out.println(linkedListStack.size());

    linkedListStack.display();
    System.out.println();
    System.out.println(linkedListStack.peek());
    linkedListStack.peek();
    System.out.println();
    linkedListStack.display();
    linkedListStack.pop();
    System.out.println();
    linkedListStack.display();
    System.out.println(linkedListStack.size());
  }

  Node head;
  int size;

  LinkedListStack() {
    this.head = null;
    size = 0;
  }

  int size() {
    return size;
  }

  public void push(int x) {
    Node temp = new Node(x);
    if (temp == null) {
      System.out.print("\nHeap Overflow");
      return;
    }
    temp.next = head;
    head = temp;
    size++;
  }

  public int peek() {
    if (head == null) {
      System.out.println("Empty Stack");
      return -1;
    }
    return head.data;
  }

  public void pop() {
    if (head == null) {
      System.out.print("\nStack Underflow");
      return;
    }
    head = head.next;
    size--;
  }

  public void display() {
    if (head == null) {
      System.out.printf("\nStack Underflow");
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.printf("%d->", temp.data);
      temp = temp.next;
    }
  }

  public boolean isEmpty() {
    return head == null;
  }
}

