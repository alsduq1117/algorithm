package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        long[][] dp = new long[101][11];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        long result = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i][j] = 0;
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j + 1 <= 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] = dp[i][j]% 1000000000;
            }
        }
        for(int i=0; i<=9; i++){
            result += dp[N][i];
        }

        System.out.println(result % 1000000000);
    }
}

//분류 : 쉬운 계단 수(dp)
//알고리즘 : 45656이란 수를 보자. 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.N이 주어질 때,  길이가 N인 계단 수가 총 몇 개 있는지 구해보자
//dp[N(계단수)][마지막 수] 인 2차 배열을 만들어준다.  계단 수가 1일때 1,2,3,4,5,6,7,8,9 가 올 수 있으므로 값은 1로 초기화를 시켜주고
//현재 계단 i일때 j 는 (i-1) 번째 계단 에서 마지막 수가 [j+1] 혹은 [j-1] 일때 j 의 값이 들어갈 수 있다. 허나 j가 0일때는 j-1 이 불가능하고
//j가 9일때는 j+1이 불가능하기 때문에 이를 예외처리 하여 점화식 dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] 을 처리해 주면 된다.
//배운점(느낀점) : dp 알고리즘을 풀려면 어떻게든 점화식을 도출해내면 쉽게 해결될 줄로만 알았는데 이런 예외처리도 생각을 해주어야 한다는 것을 배우게 되었다.
