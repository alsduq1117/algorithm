package codingtest_java.arraylist;

import java.util.Stack;

public class Problem10 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {  // 회전
            String rotatedString = leftRotate(s,i);  //회전 메소드
            Stack<Character> stack = new Stack<>();
            boolean correct = true;


            for (int j = 0; j < s.length(); j++) {  //올바른 괄호인지 판별
                if (rotatedString.charAt(j) == '{' || rotatedString.charAt(j) == '(' || rotatedString.charAt(j) == '[') {  //열린 괄호의 경우 스택에 집어넣어 주기
                    stack.push(rotatedString.charAt(j));
                }
                if (rotatedString.charAt(j) == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {  // 스택이 비어있거나 짝이 안맞으면
                        correct = false;
                        break;
                    } else {        // 스택이 비어 있거나 스택의 top이 다른 괄호일 경우
                        stack.pop();
                    }
                }
                if (rotatedString.charAt(j) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {  // 스택이 비어있거나 짝이 안맞으면
                        correct = false;
                        break;
                    } else {        // 스택이 비어 있거나 스택의 top이 다른 괄호일 경우
                        stack.pop();
                    }
                }
                if (rotatedString.charAt(j) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {  // 스택이 비어있거나 짝이 안맞으면
                        correct = false;
                        break;
                    } else {        // 스택이 비어 있거나 스택의 top이 다른 괄호일 경우
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty() && correct == true) {  //반복문을 다 끝내고 스택이 비어있으면 올바른 괄호이다!
                result += 1;
            }
        }

        return result;
    }

    public static String leftRotate(String s, int n){
        System.out.println(s.substring(n) + s.substring(0,n));
        return s.substring(n) + s.substring(0,n);
    }


}
