package codingtest_java.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem12 {

    public static void main(String[] args) {

    }


    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(); //시점, 가격

        for (int i = 1; i <= prices.length; i++) {
            map.put(i, prices[i - 1]);   //시점, 가격 초기화
        }

        for (int i = 1; i <= prices.length; i++) {   // 1초 ~ n초
            while (!stack.isEmpty() && map.get(stack.peek()) > map.get(i)) {  //스택이 비어있지 않으면 상단과 비교
                Integer entryTime = stack.pop();  // 만약 스택의 상단이 현재 들어갈 가격보다 큰 경우 가격이 떨어졌으므로 추출
                result[entryTime - 1] = i - entryTime;   //해당 시점 - 진입 시점 값을 결과 배열에 넣어준다.
            }
            stack.push(i);
        }

        //끝날때까지 가격이 떨어지지 않아서 스택에 남아있는 것들
        while (!stack.isEmpty()) {
            Integer entryTime = stack.pop();
            result[entryTime - 1] = prices.length - entryTime;
        }

        return result;
    }


}
