package codingtest_java.hash;

import java.util.HashMap;

public class Problem21 {

    public static void main(String[] args) {
        String[] want = {"kim", "min", "yeob"};
        int[] number = {3, 2, 2};
        String[] discount = {
                "kim", "kim", "kim", "min", "min",
                "yeob", "yeob"
        };

        int result = solution(want, number, discount);
        System.out.println("결과: " + result); // 결과 출력

    }

    public static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantHashMap = new HashMap<>();
        int answer = 0;
        int numberSum = 0;   // 원하는 물품의 갯수의 함

        for(int i=0; i<want.length; i++){
            wantHashMap.put(want[i], number[i]);
        }

        for(int i=0; i< number.length; i++){
            numberSum += number[i];
        }


        for(int i=0; i<= discount.length - numberSum; i++){
            HashMap<String, Integer> discountHashMap = new HashMap<>();
            for(int j=i; j < i + numberSum; j++){
                discountHashMap.put(discount[j],discountHashMap.getOrDefault(discount[j],0) + 1);
            }

            if(wantHashMap.equals(discountHashMap)){
                answer += 1;
            }
        }

        return answer;
    }
}