package codingtest_java.hash;

import java.util.*;

public class Problem21 {

    public int[] solution(String[] id_list, String[] report, int k) {
        List<Integer> mailList = new ArrayList<>();
        Map<String, Integer> reportMailCount = new HashMap<>(); // 신고 메일을 count 할 HashMap
        Map<String, HashSet<String>> reportHashMap = new HashMap<>(); //신고 이력이 담긴 HashMap <신고당한 사람 , 신고한 사람>

        for (String reportHistory : report) {
            StringTokenizer st = new StringTokenizer(reportHistory, " ");
            String reportId = st.nextToken();   //신고한 id
            String reportedId = st.nextToken();  // 신고당한 id

            reportHashMap.putIfAbsent(reportedId, new HashSet<>()); // 신고당한 사람이 처음 신고된 경우 HashSet 생성
            reportHashMap.get(reportedId).add(reportId); // 신고한 사람 추가
        }

        for (String Id : reportHashMap.keySet()) {
            if (reportHashMap.get(Id).size() >= k) {   //k 번 이상 신고당한 Id 라면?
                HashSet<String> reportIds = reportHashMap.get(Id); // 신고이력을 통해 해당 Id 를 신고한 Id들을 추출
                for (String reportId : reportIds) {
                    reportMailCount.put(reportId, reportMailCount.getOrDefault(reportId, 0) + 1);  //신고한 Id를 기반으로 메일 카운트
                }
            }
        }

        for (String id : id_list) {
            mailList.add(reportMailCount.getOrDefault(id, 0));
        }

        return mailList.stream().mapToInt(i -> i).toArray();
    }
}