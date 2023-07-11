package stack.gfg;

public class TwoStackWithArray {
    int[] arr;
    int cap;
    int top1;
    int top2;

    public TwoStackWithArray(int cap) {
        this.cap = cap;
        arr = new int[cap];
        top1 = -1;
        top2 = cap;
    }

    boolean push1(int data) {
        if (top1 < top2-1) {
            arr[++top1] = data;
            return true;
        } else {
            System.out.println("Stack Overflow !");
            return false;
        }
    }

    boolean push2(int data) {
        if (top1 < top2-1) {
            arr[--top2] = data;
            return true;
        } else {
            System.out.println("Stack Overflow !");
            return false;
        }
    }

    int peek1() {
        if (top1 >= 0) {
            return arr[top1];
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int peek2() {
        if (top2 < cap) {
            return arr[top2];
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int pop2() {
        if (top2 < cap) {
            int x = arr[top2];
            top2++;
            return x;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int size1() {
        return top1+1;
    }

    int size2() {
        return cap-top2;
    }


    public static void main(String[] args) {
        TwoStackWithArray st = new TwoStackWithArray(5);

        st.push1(10);
        st.push1(11);
        st.push1(12);
        st.push1(13);
        st.push1(14);
        System.out.println(st.size1());
       // st.push1(15);
        st.pop1();
        st.push2(20);
        System.out.println(st.size1());
        System.out.println(st.peek2());
    }
}
