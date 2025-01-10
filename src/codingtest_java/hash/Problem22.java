package codingtest_java.hash;

import java.util.*;

public class Problem22 {
    public String[] solution(String[] record) {
        Map<String, String> idNicknameMap = new HashMap<>();
        Map<String, String> commandMap = new HashMap<>() {{
            put("Enter", "님이 들어왔습니다.");
            put("Leave", "님이 나갔습니다.");
        }};
        List<String> resultList = new ArrayList<>();


        for(String recoerdElement : record){
            StringTokenizer st = new StringTokenizer(recoerdElement, " ");
            String command = st.nextToken();
            String Id = st.nextToken();
            if(command.equals("Enter") || command.equals("Change")){   //Leave 의 경우를 제외하고 닉네임 최신화 해주기
                String nickname = st.nextToken();
                idNicknameMap.put(Id,nickname);
            }
        }

        for (String recordElement : record){
            StringTokenizer st = new StringTokenizer(recordElement, " ");
            String command = st.nextToken();
            String Id = st.nextToken();
            if(command.equals("Enter")){
                resultList.add(idNicknameMap.get(Id) + commandMap.get(command));  // Enter 의 경우 [닉네임]님이 들어왔습니다
                continue;
            }
            if(command.equals("Leave")){
                resultList.add(idNicknameMap.get(Id) + commandMap.get(command));  // Enter 의 경우 [닉네임]님이 들어왔습니다
                continue;
            }
        }

        return resultList.stream().toArray(String[]::new);
    }
}