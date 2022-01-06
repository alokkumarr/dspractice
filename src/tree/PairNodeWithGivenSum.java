package tree;

import java.util.HashSet;
import java.util.Set;

public class PairNodeWithGivenSum {

    /**
     *      10
     *     /  \
     *    20   30
     *   /  \
     *  40   50
     */
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.right = new Node(50);

        Set<Integer>  set = new HashSet<>();
        System.out.println(isPairSum(root, set,500));
    }

    static boolean isPairSum(Node root, Set<Integer> set, int target) {
        if (root == null) return false;

        // base
        if (set.contains(target - root.data)) {
            return true;
        } else {
            set.add(root.data);
        }

        /**if (isPairSum(root.left, set, target)) {
            return true;
        }**/

        return isPairSum(root.left, set, target) ?
                isPairSum(root.left, set, target) : isPairSum(root.right, set, target);
    }
}