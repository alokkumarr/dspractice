package heap.gfg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArray {

    public static void main(String[] args) {
        List<List<Integer> > arr =new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);

        List<Integer> res = mergeKSortedArray(arr);
        System.out.println(res);

    }


    static List<Integer> mergeKSortedArray(List<List<Integer>> lists) {
        if (lists.isEmpty()) return null;

        List<Integer> res = new ArrayList<>();
        Queue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(Tuple::getData));

        //put first element of every array in min heap (priority queue)
        for(int i = 0; i < lists.size(); i++) {
            pq.add(new Tuple(lists.get(i).get(0), i, 0));
        }

        // now loop till pq (min heap is empty)
        while (!pq.isEmpty()) {
            Tuple temp = pq.poll();
            res.add(temp.data); // get the first element from pq add to result

            // now fetch the same poll list position and next element postion same array
            int aPos = temp.arrPos;
            int elePos = temp.arrIndex;

            if (elePos + 1 < lists.get(aPos).size()) {
                pq.add(new Tuple(lists.get(aPos).get(elePos+1), aPos, elePos+1));
            }


        }

        return res;
    }

}

class Tuple {
    int data, arrPos, arrIndex;

    Tuple(int data, int arrPos, int arrIndex) {
        this.data=data;
        this.arrPos = arrPos;
        this.arrIndex = arrIndex;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getArrPos() {
        return arrPos;
    }

    public void setArrPos(int arrPos) {
        this.arrPos = arrPos;
    }

    public int getArrIndex() {
        return arrIndex;
    }

    public void setArrIndex(int arrIndex) {
        this.arrIndex = arrIndex;
    }
}
