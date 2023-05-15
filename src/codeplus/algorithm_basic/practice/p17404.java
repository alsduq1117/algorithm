package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n + 1][3]; //0 은 빨강, 1 은 초록 , 2는 파랑
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {                //빨강 ,초록 , 파랑 비용 배열
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        int ans = 99999;


        // 1번 집과 n 번집의 색깔을 다르게 하려면 어떻게 넣어야 할까?

        for (int i = 1; i <= n; i++) { // 첫번째 집이 빨강이라면
            if (i == 1) {
                dp[i][0] = a[i][0];
                dp[i][1] = 99999;
                dp[i][2] = 99999;
            } else if (i == n) {
                dp[n][0] = 99999;
                dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + a[n][1];
                dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + a[n][2];
            } else {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + a[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + a[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + a[i][2];
            }
        }

        if (ans > Arrays.stream(dp[n]).min().getAsInt()) {
            ans = Arrays.stream(dp[n]).min().getAsInt();
        }

        for (int i = 1; i <= n; i++) { // 첫번째 집이 초록이라면
            if (i == 1) {
                dp[i][0] = 99999;
                dp[i][1] = a[i][1];
                dp[i][2] = 99999;
            } else if (i == n) {
                dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + a[n][0];
                dp[n][1] = 99999;
                dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + a[n][2];
            } else {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + a[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + a[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + a[i][2];
            }
        }

        if (ans > Arrays.stream(dp[n]).min().getAsInt()) {
            ans = Arrays.stream(dp[n]).min().getAsInt();
        }

        for (int i = 1; i <= n; i++) { // 첫번째 집이 파랑이라면
            if (i == 1) {
                dp[i][0] = 99999;
                dp[i][1] = 99999;
                dp[i][2] = a[i][2];
            } else if (i == n) {
                dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + a[n][0];
                dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + a[n][1];
                dp[n][2] = 99999;
            } else {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + a[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + a[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + a[i][2];
            }
        }

        if (ans > Arrays.stream(dp[n]).min().getAsInt()) {
            ans = Arrays.stream(dp[n]).min().getAsInt();
        }


        System.out.println(ans);

    }
}


//문제 : RGB 거리 2 (dp)
//알고리즘 : 이웃집과는 색깔이 서로 달라야 하며, 추가 조건으로 첫번째 집과 마지막 집의 색깔도 같지 않아야 한다.
//이를 풀기 위해서는 첫번째 집의 색깔을 고정하고 문제를 풀어야 한다
//첫번째 집이 빨강이라면 마지막 집은 초록,파랑 집일 것이고 , 첫번째 집이 초록이라면 마지막 집은