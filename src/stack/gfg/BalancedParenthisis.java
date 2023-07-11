package stack.gfg;

import java.util.Stack;

public class BalancedParenthisis {
    public static void main(String[] args) {
        String bracket = "()<>";
        boolean isBalanced = solution(bracket);
        System.out.println("Is balanced : " + isBalanced);
    }

    private static boolean solution(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (ch.equals('[') || ch.equals('(') || ch.equals('{') || ch.equals('<')) {
                st.push(ch);
                System.out.println("Stack : " + st);
            } else {
                if (st.isEmpty())
                    return false;
                else if (!findMatch(st.peek(), ch))
                    return false;
                else
                    st.pop();
            }
        }
        return st.isEmpty();
    }

    private static boolean findMatch(Character ch1, Character ch2) {
        return (ch1 == '[' && ch2 == ']')
                || (ch1 == '(' && ch2 == ')')
                || (ch1 == '{' && ch2 == '}')
                || (ch1 == '<' && ch2 == '>');
    }
}
