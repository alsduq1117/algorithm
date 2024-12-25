package codingtest_java.stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem16 {

    static StringTokenizer st;

    public String solution(int n, int k, String[] cmd) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            arrayList.add(i);   // 0~n-1 까지
        }
        Stack<Integer> stack = new Stack<>();



        for(int i=0; i<cmd.length; i++){
            String command = cmd[i];
            StringTokenizer st = new StringTokenizer(command);
            String action = st.nextToken();
            int value = 0;
            if (st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken()); // 두 번째 토큰 (숫자)
            }

            switch (action){
                case "U" : k -= value;
                break;

                case "D" : k += value;
                break;


                case "C" : {
                    if(k == arrayList.size()) k -= 1;
                    stack.push(k);
                    arrayList.remove(k); //k 번째 인덱스 값 삭제
                }
                break;

                case "Z" : {
                    int top = stack.pop().intValue();
                    arrayList.add(top,top);
                }
                break;

            }
        }

        return;
    }
}
