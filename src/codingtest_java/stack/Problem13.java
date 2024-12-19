package codingtest_java.stack;

import java.util.Stack;


public class Problem13 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < moves.length; i++) {
            int position = moves[i] - 1;
            int doll = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][position] != 0) {   //해당 위치에 인형이 없을시 반복문 다시
                    doll = board[j][position];
                    board[j][position] = 0;
                    break;
                }
            }
            if (doll == 0) continue; //아무것도 안집힐 시에 다시 되돌아감
            if (!stack.isEmpty() && stack.peek() == doll) {
                result += 2;
                stack.pop();
            } else {
                stack.push(doll);
            }
        }
        return result;
    }

}