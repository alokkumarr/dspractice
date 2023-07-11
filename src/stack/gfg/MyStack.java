package stack.gfg;

public class MyStack {

    int[] item;
    int top;
    int cap;

    MyStack(int cap) {
        this.cap = cap;
        item = new int[this.cap];
        top = -1;
    }

    void push(int data) {
        if (top == cap) {
            System.out.println("Stack Overflow");
            return;
        }

        top++;
        item[top] = data;
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return item[top];
    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int data = item[top];
        top--;
        return data;
    }

    int size() {
        return top + 1;
    }


    public static void main(String[] args) {
        MyStack st = new MyStack(12);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println(st.size());
        System.out.println(st.pop());

        st.push(45);
        System.out.println(st.size());

        System.out.println(st.peek());

        System.out.println(st.peek());
        System.out.println(st.peek());
        System.out.println(st.peek());

        System.out.println(st.size());
    }
}
