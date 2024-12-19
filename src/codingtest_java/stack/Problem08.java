package codingtest_java.stack;

import java.util.Stack;

public class Problem08 {

    public static void main(String[] args) {
    }


    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push("(");
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }

}
