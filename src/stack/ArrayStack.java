package stack;

public class ArrayStack {
  int arr[] = new int[10];
  int top = -1;

  public void push(int x) {
    if (top > arr.length ) {
      System.out.println("Overflow stack");
      return;
    }

    top = top + 1;
    arr[top] = x;
  }

  public int pop() {
    if (top == -1) {
      System.out.println("Underflow stack");
      return -1;
    }
    int x = arr[top];
    top --;
    return x;
  }

  public boolean isEmpty() {
    if (top == -1) {
      return true;
    }
    return false;
  }

  public int top() {
    return arr[top];
  }
}
