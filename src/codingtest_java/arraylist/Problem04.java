package codingtest_java.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem04 {

    public static void main(String[] args){

    }

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] pattern1 = new int[]{1,2,3,4,5};
        int[] pattern2 = new int[]{2,1,2,3,2,4,2,5};
        int[] pattern3 = new int[]{3,3,1,1,2,2,4,4,5,5};

        int[] sum = new int[]{0,0,0};

        for(int i =0; i<answers.length; i++){
            if(pattern1[i%5] == answers[i]) sum[0]++;
            if(pattern2[i%8] == answers[i]) sum[1]++;
            if(pattern3[i%10] == answers[i]) sum[2]++;
        }

        int max = Arrays.stream(sum)        // 최댓값 찾기
                .max()
                .getAsInt();


        ArrayList<Integer> arrayList = new ArrayList<>();   //배열에 바로 집어 넣을수가 없어서 리스트에 넣어서 배열로 변환 해줘야 함

        for(int i=0; i<3; i++){
            if(sum[i] == max){
                arrayList.add(i+1);
            }
        }

        answer = arrayList.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
