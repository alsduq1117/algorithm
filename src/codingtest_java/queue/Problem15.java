package codingtest_java.queue;

import java.util.*;

public class Problem15 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){
            queue.add(progresses[i]);
        }

        ArrayList<Integer> arrayList =  new ArrayList<>();
        int complete = 0;  // 완료된 작업 갯수
        int progressSize = progresses.length;  //작업 총 갯수

        while(!queue.isEmpty()) {
            int result = 0;

            for (int i = complete; i < progressSize; i++) {
                Integer poll = queue.poll();
                queue.add(poll + speeds[i]);
            }
            while (!queue.isEmpty() && queue.peek() >= 100) {   //진도가 100이 넘은 progress 들은 queue 에서 빼주기
                queue.poll();
                result += 1;
                complete += 1;
            }
            if (result != 0) {
                arrayList.add(result);
            }
        }

        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
