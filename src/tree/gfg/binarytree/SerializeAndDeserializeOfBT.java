package tree.gfg.binarytree;

import tree.gfg.Node;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeOfBT {

    public static void main(String[] args) {
        /*
         *      10
         *     /  \
         *    20   70
         *   /  \
         *  40   90
         *      /
         *     21
         *      \
         *       87
         *
         *  O/P Serialized - > {10, 20, 40, -1, -1, 90, 21, -1, 87, -1, -1, -1, 70, -1, -1}
         *
         *  Deserialized : 10 20 40 90 21 87 70
         *
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(70);
        root.left.left = new Node(40);
        root.left.right = new Node(90);
        root.left.right.left = new Node(21);
        root.left.right.left.right = new Node(87);

        List<Integer> al = new ArrayList<>();
        serialize(root, al);
        System.out.println("Serialized Array : " + al);

        root = deserialized(al);
        TreeTraversal.preOrderTraversal(root);;
    }

    static int index = 0;
    private static Node deserialized(List<Integer> al) {
        if (al.size() == index)
            return null;

        int val = al.get(index);
        index++;

        if (val == EMPTY)
            return null;

        Node root = new Node(val);

        root.left = deserialized(al);
        root.right = deserialized(al);

        return root;
    }

    /* O(n) */
    static final int EMPTY = -1;
    private static void serialize(Node root, List<Integer> list) {
        if (root == null) {
            list.add(EMPTY);
            return;
        }

        // pre order traversal
        list.add(root.key);
        serialize(root.left, list);
        serialize(root.right, list);
    }


}
