package codingtest_java.arraylist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Problem06 {


    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        int[] stoppedStage = new int[N]; // 1~501 까지 담길 수 있음. 0번째 인덱스에는 1스테이지에서 멈춘사람, 1번째 인덱스에는 2스테이지에서 멈춘사람 .....
        double[] failure = new double[N];

        int people = stages.length;
        Map<Integer, Double> hashMap = new HashMap<>();

        for (int stage : stages) {
            if (stage >= 1 && stage <= N) {
                stoppedStage[stage - 1]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (people != 0) {
                failure[i] = (double) stoppedStage[i] / people;
            }
            people -= stoppedStage[i];           // 남은 사람의 수 계산
        }

        for(int i = 0; i < N; i++){
            hashMap.put(i+1, failure[i]);  // 스테이지와 실패율을 Map으로 묶어준다.
        }

        answer = hashMap.entrySet().stream()
                .sorted((a1, a2) -> Double.compare(a2.getValue(), a1.getValue()))
                .mapToInt(Map.Entry::getKey)
                .toArray();

        return answer;
    }

}
