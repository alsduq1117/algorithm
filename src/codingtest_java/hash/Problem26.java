package codingtest_java.hash;

import java.util.HashMap;
import java.util.Map;

public class Problem26 {
    public int solution(String[][] clothes) {
        Map<String, Integer> costumeTypeMap = new HashMap<>();

        for (String[] cloth : clothes) {
            String costumeType = cloth[1];
            costumeTypeMap.put(costumeType, costumeTypeMap.getOrDefault(costumeType, 0) + 1);
        }

        int answer = 1;

        for (int count : costumeTypeMap.values()) {   // 종류별 의상 수를 곱해나간다.
            answer *= (count + 1);  //착용하지 않은 경우까지 포함하므로
        }

        return answer - 1;
    }
}
