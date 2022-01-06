package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

    List of array [
                [3, 5, 7],
                [0, 6],
                [0, 6, 28]
        ]

   Sort this array : O/P

   [0, 0, 3, 5, 6, 6, 7, 28]

 */
public class MergeSortedArray {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(7);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(6);

        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(6);
        list3.add(28);

        List<Integer> list4 = new ArrayList<>();
        list4.add(35);
        list4.add(36);
        list4.add(248);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println(list);

        // sort the arrays
        List<Integer> sortedList = mergeArrays(list);
        System.out.println(sortedList);
    }

    private static List<Integer> mergeArrays(List<List<Integer>> list) {
        List<Integer> result = new ArrayList<>();

        // will use the priority queue to use the min heap data structure
        PriorityQueue<Triplets> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // add all the first element from the list of list in pq
        for (int i = 0; i < list.size(); i++) {
            Triplets pair = new Triplets(i, 0, list.get(i).get(0));
            pq.add(pair);
        }

        // now process the priority queue
        while (!pq.isEmpty()) {
            Triplets pair = pq.poll();
            result.add(pair.val);
            pair.dataIndex++;

            if (pair.dataIndex < list.get(pair.listIndex).size()) {
                pair.val = list.get(pair.listIndex).get(pair.dataIndex);
                pq.add(pair);
            }
        }
        return result;
    }
}

/*
    This class will work as a node of the min heap which
     I will pass in the Priority queue.
 */
class Triplets {
    int listIndex;
    int dataIndex;
    int val;

    Triplets(int listIndex, int dataIndex, int val) {
         this.val = val;
         this.listIndex = listIndex;
         this.dataIndex = dataIndex;
     }
}