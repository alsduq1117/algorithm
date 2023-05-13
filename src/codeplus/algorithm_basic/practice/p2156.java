package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];    //0 안마시기 ,1: 1번 연속 2: 2번 연속
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[1][0] = 0;
        dp[1][1] = arr[1];
        dp[1][2] = arr[1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = dp[i - 1][0] + arr[i];      //그 전에 안마시고 i 번째 마셨기 때문에 1번 연속
            dp[i][2] = dp[i - 1][1] + arr[i];      //i-1 번째에도 마시고 i번째도 마셨기 때문에 2번 연속
        }

        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));


    }

}


//문제 : 포도주 시식(dp)
//알고리즘 : 포도잔을 연속 3잔 이상 마실 수 없고 최대로 마실 때의 값을 구해야 한다.
//i 번째의 경우의 수는 다음과 같다.
//포도주를 안마시거나 , 포도주를 i-1 번째에서 안마시고 i번째 마시거나 , 포도주를 i-1 번째에도 마시고 i번째 에서도 마시거나
//포도주를 안마실때는 i-1 번째의 모든 경우의 수 중 가장 큰 값을 더해주고
//포도주를 i-1 번째에서 안마시고 i 번째에서 마실때는 하나의 경우의 수이다.
//포도주를 i-1 번째에서 마시고 i 번째에서 마실때도 하나의 경우의 수이다.
//배운점 : 처음 문제를 풀때는 i 번째에서 마시거나 안마시거나로 경우를 나누어 문제를 풀려고 했는데, 쉽지않았다.. 어떻게 훈련해야 바로
//이러한 알고리즘을 생각하는지 어렵다..