package codingtest_java.hash;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Problem19 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> participantHashMap = new HashMap<>();

            for(String name : participant){
                participantHashMap.put(name, participantHashMap.getOrDefault(name,0) + 1);
            }

            for(String name : completion) {
                participantHashMap.put(name, participantHashMap.get(name) - 1);
            }

            String answer = "";

            for (String name : participantHashMap.keySet()) {
                if (participantHashMap.get(name) == 1) {
                    answer = name; // 값이 1인 선수의 이름을 answer에 저장
                    break;
                }
            }
            return answer;
        }
    }
}
