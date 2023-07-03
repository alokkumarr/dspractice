package hashing.gfg;

import java.util.ArrayList;
import java.util.LinkedList;

public class ImplementChaining {

    int BUCKET;
    ArrayList<LinkedList<Integer>> table;

    ImplementChaining(int b) {
        BUCKET = b;
        table = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            table.add(new LinkedList<Integer>());
        }
    }

    void insert(int key) {
        int i = key % BUCKET;
        table.get(i).add(key);
    }

    void remove(int key) {
        int i = key % BUCKET;
        table.get(i).remove((Integer) key);
    }

     boolean search(int key) {
        int i = key % BUCKET;
        return table.get(i).contains(key);
    }

    public static void main(String[] args) {

    }
}
