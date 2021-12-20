package stack;

public class ArrayStack {

  public static void main(String[] args) {
    ArrayStack as = new ArrayStack(12);
    as.push(10);
    as.push(23);
    System.out.println(as.size());
    System.out.println(as.peek());
    as.pop();
    System.out.println(as.size());
    System.out.println(as.peek());
  }

  int[] arr;
  int top;
  int cap;

  ArrayStack(int c) {
    top = -1;
    cap = c;
    arr = new int[cap];
  }

  public void push(int x) {
    if (top > arr.length ) {
      System.out.println("Overflow stack");
      return;
    }

    top = top + 1;
    arr[top] = x;
  }

  public int peek() {
    if (top == -1) {
      System.out.println("Underflow stack");
      return -1;
    }
    return arr[top];
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

  public int size() {return top+1;};
}
