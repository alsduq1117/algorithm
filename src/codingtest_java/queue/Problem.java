package codingtest_java.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> onBridge = new ArrayDeque<>();
        int answer = 0; // 경과 시간
        int weightSum = 0; // 다리 위의 총 무게
        int idx = 0; // truck_weights 인덱스


        for (int i = 0; i < bridge_length; i++) { //다리 위의 길이만큼 0 으로 초기화 한다    0 0 0 0 0 0
            onBridge.add(0);
        }

        while (idx < truck_weights.length) {
            answer++; // 1초 증가

            weightSum -= onBridge.poll(); //다리를 다 건넌 트럭 빼주기

            if (weight >= weightSum + truck_weights[idx]) { // 다음 트럭이 다리에 올라갈 수 있는지 확인
                onBridge.add(truck_weights[idx]);
                weightSum += truck_weights[idx];
                idx++; // 트럭 인덱스 최신화
                continue;
            }
            onBridge.add(0);  //더이상 다리위에 트럭이 못 올라가면 0 추가

        }

        answer += bridge_length;  //마지막 트럭

        return answer;
    }
}
