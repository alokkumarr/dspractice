package stack;

// With an efficient space
public class TwoStack {

  int arr[];
  int size;
  int top1, top2;

  public TwoStack(int n){
    size = n;
    arr = new int[n];
    top1 = -1;
    top2 = size;
  }

  // method to an element in stack1
  void push1(int x){
    if (top1 < top2 -1){
      top1++;
      arr[top1] = x;
    } else {
      System.out.println("Stack Overflow!");
      return;
    }
  }

  // method to an element in stack2
  void push2(int x){
    if (top1 < top2 -1){
      top2--;
      arr[top2] = x;
    } else {
      System.out.println("Stack Overflow!");
      return;
    }
  }

  int pop1(){
    if (top1 > 0){
      int x = arr[top1];
      top1--;
      return x;
    }else {
      System.out.println("Stack Underflow");
      return 0;
    }
  }

  int pop2(){
    if (top2 < size){
      int x = arr[top2];
      top2++;
      return x;
    }else {
      System.out.println("Stack Underflow");
      return 0;
    }
  }
}
