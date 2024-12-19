package codingtest_java.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Problem09 {

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }

    public static String solution(int decimal) {
        Stack<Integer> stack = new Stack();
        int remain = 0;  //나머지
        while(decimal > 0){
            remain = decimal%2;   // 나머지 연산
            stack.push(remain);

            decimal = decimal/2;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}