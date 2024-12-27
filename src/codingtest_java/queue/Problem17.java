package codingtest_java.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem17 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> cards1Queue = new ArrayDeque<>();
        Queue<String> cards2Queue = new ArrayDeque<>();
        String answer = "Yes";

        for(String card : cards1){
            cards1Queue.add(card);
        }
        for(String card : cards2){
            cards2Queue.add(card);
        }

        for(int i=0; i<goal.length; i++){
            if(!cards1Queue.isEmpty() && cards1Queue.peek().equals(goal[i])){
                cards1Queue.poll();
                continue;
            }
            if(!cards2Queue.isEmpty() && cards2Queue.peek().equals(goal[i])){
                cards2Queue.poll();
                continue;
            }
            answer = "No";
            break;
        }

        return answer;
    }

}
