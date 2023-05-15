package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = 3 * dp[i - 2];

            for (int j = 4; j <= i; j += 2) {
                dp[i] += 2 * dp[i - j];
            }
        }

        System.out.println(dp[n]);
    }
}


//문제 : 3 x n 타일링 (dp)
//알고리즘 : 3 x n 에서 n 이 홀수 일때는 2x1, 1x2 블록으로 채워줄 수 없다. 따라서 이 문제에서는 짝수 n 에 대한 결과값만 도출하면 된다
// n = i 일때  i-2 상태 에서 3x2 만큼의 블록을 채우는 경우의 수를 더해주면된다
//3 x 2 를 채우는 경우의 수는 3가지 이다 따라서 점화식은 d[i] = d[i-2] * 3 이다. 하지만 여기서 중요한 점은 n이 4가 넘어가는 짝수 일때는
//추가적인 경우의 수가 2개가 더 나오게 된다. 따라서 d[i] 에다가 d[i-4] * 2 + d[i-6] * 2 ... 을 더해줘야 한다.
// 그래서 최종적으로 점화식은 dp[i] = 3 * dp[i-2] + 2 * dp[i-4] + 2 * dp[i-6] .... 이다.

//배운점 : 2 x n  타일링 문제를 풀었던 경험을 살려서 처음에 d[i] = d[i-2] * 3 의 점화식을 도출하는건 쉬웠다. 하지만 n 이 4 이상 부터는
//추가적인 경우의 수가 나온다는 것을 생각하기는 너무 어려웠던 것 같다. 이와 같은 도형 문제를 풀때는 눈에 보이는 점화식을 도출하고 추가적인 경우의
//수가 있는지 생각해봐야겠다. 또한 입력에는 홀수가 있지만 홀수를 취급하지 않아도 되는 문제를 처음만나 봐서 처음에 당황 했지만 그냥 짝수만 취급해서
//풀어주면 된다는 것을 알게되었다.