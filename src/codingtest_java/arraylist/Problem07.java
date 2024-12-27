package codingtest_java.arraylist;

import java.util.HashMap;
import java.util.HashSet;

/*
제한사항
dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
dirs의 길이는 500 이하의 자연수입니다.

입출력 예
dirs	answer
"ULURRDLLU"	7
"LULLLLLLU"	7
 */

//
//public class Problem07 {
//
//    public int solution(String dirs){
//        int x = 5, y = 5;
//        HashSet<String> answer = new HashSet<>();      //겹치는 좌표는 처리
//
//        for(int i = 0; i< dirs.length(); i++){
//            int[] offset = location.get(dirs.charAt(i));
//            int nx = x + offset[0];
//            int ny = y + offset[1];
//            if(!isValidMove(nx, ny))
//                continue;
//
//            answer.add();
//        }
//
//    }
//
//}
