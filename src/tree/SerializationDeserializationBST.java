package tree;

import java.util.ArrayList;

public class SerializationDeserializationBST {

    static final int EMPTY = -1;
    void serializationBST(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            arr.add(EMPTY);
            return;
        }
        arr.add(root.data);
        serializationBST(root.left, arr);
        serializationBST(root.right, arr);
    }

    int index = 0;
    Node deSerializationBST(ArrayList<Integer> arr) {
        if (index == arr.size()) return null;
        int val = arr.get(index);
        index++;
        if (val == EMPTY) return null;

        Node root = new Node(val);
        root.left = deSerializationBST(arr);
        root.right = deSerializationBST(arr);
        return root;
    }
}
