package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int MAX_NUM = 1000000;


        boolean[] check = new boolean[MAX_NUM + 1];
        Arrays.fill(check, false);   // true면 지워진거고 false면 안지워진것
        check[0] = true;   // 0은 소수가 아님
        check[1] = true;   // 1은 소수가 아님

        for (int i = 2; i <= MAX_NUM; i++) {
            if (check[i] == false) {
                for (int j = i * 2; j <= MAX_NUM; j += i) {
                    check[j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            boolean result = false;
            for(int i=n-1; i>=3; i--){
                if(check[i] == false && check[n-i] == false){
                    sb.append(n + " = " + (n-i) + " + " + i + "\n");
                    result = true;
                    break;
                }
            }
            if(result == false) {
                sb.append("Goldbach's conjecture is wrong.");
            }
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }
}


//분류 : 골드 바흐의 추측(수학)
//알고리즘 : 골드 바흐의 추측이 무엇이냐면 "4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다." 이다. 예를 들어 8은 3 + 5로 나타낼 수 있고,
//3 과 5는 모두 홀수인 소수이다. 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
//따라서 풀이 방법은 에라토스테네스의 체를 사용하여 소수들만 남긴 배열을 만들어 준 뒤, n = i + (n-i) 이기 때문에 check[i] 도 false 이고 check[n-i] 도 false
//이면 두개의 소수의 합으로 나타낼 수 있다.
//배운점: Arrays.fill 사용하는게 익숙해졌고, 에라토스테네스의 체 알고리즘을 정확히 숙지한 것 같다.또한 자바 상수 final을 사용해 보는 문제가 되었다.