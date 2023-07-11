package stack.gfg;

import linklist.gfg.Node;

public class LinkedListStack {

    Node head;
    int top;

    public  LinkedListStack() {
        head = new Node(-1);
        top = -1;
    }

    void push(int data) {
        if (head.data < 0) {
            head.data = data;
        } else {
            Node curr = new Node(data);
            curr.next = head;
            head = curr;
        }
        top++;
    }

    int size() {
        return top+1;
    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow !");
            return -1;
        }

        return head.data;
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow !");
            return -1;
        }

        int data = head.data;
        head = head.next;
        top--;
        return data;
    }

    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();
        st.push(10);
        st.push(15);
        st.push(16);
        st.push(18);

        System.out.println(st.size());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

    }
}
