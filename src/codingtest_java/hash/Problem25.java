package codingtest_java.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem25 {
    public int[] solution(String msg) {
        int[] answer = {};

        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        String w = "";
        for (char c : msg.toCharArray()) {
            String wc = w + c;
            if (dictionary.containsKey(wc)) {   //새로운 문자의 경우
                w = wc;
            } else {
                result.add(dictionary.get(w));
                dictionary.put(wc, dictionary.size() + 1);
                w = String.valueOf(c);    // 다음 단어부터 시작
            }
        }

        if (!w.isEmpty()) {
            result.add(dictionary.get(w));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
