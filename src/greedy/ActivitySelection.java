package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {


    public static void main(String[] args) {
        Activity[] activities = {new Activity(3,4),
                new Activity(6,9),
                new Activity(4,6),
                new Activity(9,14)};

        System.out.println(maxActivity(activities));
    }

    static int maxActivity(Activity[] activities) {
        Arrays.sort(activities, new MyCompare());
        System.out.println(Arrays.toString(activities));
        int res = 1;
        int prev = 0;
        for (int curr = 1; curr < activities.length; curr++) {
            if (activities[curr].start >= activities[prev].start) {
                res++;
                prev=curr;
            }
        }
        return res;
    }


}

class MyCompare implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.finish - o2.finish;
    }
}

class Activity{
    int start;
    int finish;

    Activity(int s, int f) {
        this.start = s;
        this.finish = f;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }
}
