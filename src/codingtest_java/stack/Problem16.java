package codingtest_java.stack;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem16 {

    static StringTokenizer st;

    public String solution(int n, int k, String[] cmd) {
        HashMap<Integer, Boolean> table = new HashMap<>(); //hashmap으로 table 생성
        Stack<Integer> stack = new Stack<>();
        int selection = k;  // 선택된 행의 위치
        String answer = "";

        for (int i = 0; i < n; i++) {
            table.put(i, true);  //인덱스별로 테이블에 넣고 테이블에 존재하면 true, 없으면 false 로 표시
        }


        for (int i = 0; i < cmd.length; i++) {
            String command = cmd[i];
            StringTokenizer st = new StringTokenizer(command);
            String action = st.nextToken(); //첫번째 토큰 (행동 U,  D , C , Z)
            int value = 0;
            if (st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken()); // 두 번째 토큰 (숫자)
            }

            switch (action) {
                case "U":
                    for(int j=0; j<value; j++){
                        selection -= 1;
                        while(selection >= 0 && !(table.get(selection) == true)){
                            selection -=1;
                        }
                    }
                    break;

                case "D":
                    for(int j=0; j<value; j++){
                        selection += 1;
                        while(selection < n && !(table.get(selection) == true)){
                            selection +=1;
                        }
                    }
                    break;


                case "C": {
                    stack.push(selection);
                    table.put(selection, false); //k 번째 인덱스 값 삭제
                    boolean last = true;
                    for(int j=selection+1; j<n; j++){
                        if(table.get(j) == true);
                        last = false;
                        break;
                    }
                    if(last == true) {
                        selection -=1;
                        while(!(table.get(selection) == true)){
                            selection -=1;
                        }
                    }
                    if(last == false) {
                        selection +=1;
                        while(!(table.get(selection) == true)){
                            selection +=1;
                        }
                    }
                }
                break;

                case "Z": {
                    int top = stack.pop();
                    table.put(top, true);
                }
                break;

            }
        }

        for (Boolean exist : table.values()) {
            if (exist) {
                answer += "O"; // true인 경우 "O" 추가
            } else {
                answer += "X"; // false인 경우 "X" 추가
            }
        }

        return answer;

    }
}
