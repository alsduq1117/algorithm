package codingtest_java.stack;

import java.util.Stack;

public class Problem11 {

    public static void main(String[] args) {

    }
    public int solution(String s)
    {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == stack.peek()){   //문자열 쌍이라면 pop
                stack.pop();
            } else {
                stack.push(s.charAt(i));   //문자열 쌍이 아니라면 스택에 집어넣기
            }
        }

        if(stack.isEmpty()){
            result = 1;
        }

        return result;
    }



}
