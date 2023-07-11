package linklist.gfg;

public class PalindromeList {
    public static void main(String[] args) {

        CharNode node = new CharNode('A');
        node.next = new CharNode('B');
        node.next.next = new CharNode('C');
        node.next.next.next = new CharNode('B');
        node.next.next.next.next = new CharNode('A');
        printList(node);
        boolean newNode = isPalindrome(node);
        System.out.println();
        System.out.println("Have Palindrome : " + newNode);

    }

    private static boolean isPalindrome(CharNode head) {
        if (head == null) return false;

        CharNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        CharNode rev = reverse(slow.next);
        CharNode curr = head;

        while (rev != null) {
            if (rev.data != curr.data) {
                return false;
            }
            curr = curr.next;
            rev = rev.next;
        }

        return true;
    }

    private static CharNode reverse(CharNode head) {
        if (head == null) return null;

        CharNode curr = head, prev = null;
        while (curr != null) {
            CharNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    public static void printList(CharNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

class CharNode{
    char data;
    CharNode next;
    CharNode(char x){
        data=x;
        next=null;
    }
}
