package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        long[][] dp = new long[N + 2][3];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1; //첫번째 수는 항상 1이고 10 일때만 가능하므로 1로 초기화
        dp[2][1] = 0; //첫번째 수에 0이 올 수 없음

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);


    }
}

//분류: 이친수(dp)
//알고리즘 : 이친수는 0으로 시작하지 않는다.이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
//예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 이친수를 만들기 위해선
//i번째 수가 0 이면 i-1번째 수는 0,1 둘다 올 수 있다. i번째 수가 1이라면 i-1 번째 수는 0만 올 수 있다 따라서 점화식을 써보면
//dp[i][0] = dp[i - 1][1] + dp[i - 1][0]; , dp[i][1] = dp[i - 1][0]; 이다
//배운점 : 처음에 int 형으로 놓았을 때 답이 자꾸 틀렸는데, 가장 마지막 수인 90을 넣어보니 음수가 나와서 long 타입으로 선언해줘야 한다는 것을 알게 되었다.
