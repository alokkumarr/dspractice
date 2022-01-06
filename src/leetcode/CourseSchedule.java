package leetcode;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[1];
            int dependent = prerequisite[0];

            List<Integer> dependentList = map.get(course);
            dependentList.add(dependent);

            inDegree[dependent] ++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int val = q.poll();
            count++;
            for (int dependent : map.get(val)) {
                inDegree[dependent] --;
                if (inDegree[dependent] == 0) q.offer(dependent);
            }
        }

        return count == numCourses;
    }
}
