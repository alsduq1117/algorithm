package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15988 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long[] dp = new long[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            if(n >= 2){
                dp[2] = 2;
            }


            for (int i = 3; i <= n; i++) {
                if (i == 1 || i == 2) {
                    break;
                }
                if (i == 3) {
                    dp[i] = dp[i - 2] + dp[i - 1] + 1;
                } else {
                    dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;
                }
            }

            sb.append(dp[n] + "\n");
        }

        System.out.println(sb);
    }
}


//문제 : 1,2,3 더하기 3 (dp)
//풀이 : 1,2,3의 합으로 정수 n을 나타내는 방법의 수를 구해야 한다. 마지막에 3 을 더하는 dp[i-3] 2를 더하는 dp[i-2] 1을 더하는 dp[i-1] 의 개수를
//다 합한 것이 dp[i] 의 갯수 이다. 따라서 이를 점화식으로 나타내면 dp[i] = dp[i-3] + dp[i-2] + dp[i-1] 이다.
//배운점 : 점화식을 도출하는 과정은 그렇게 어렵지 않았지만 결과 값을 1000000009로 나눠 줘야 하는데 이것을 맨 마지막에 나눠주면 long 데이터 형을 넘어가게 되버려서
//이상한 값이 출력되게 된다. 따라서 점화식에 1000000009를 해주어도 결과값을 1000000009로 나눈것과 같다는 것을 알아야한다는 것이 쉽지 않았고
//n 이 <1000000 보다 작은 양수이기 때문에 dp[1] 과 dp[2]의 값을 초기화 할때 arrayIndexOutOfBounds 예외가 떠버렸는데 예외처리를 잘 해줘야 했다.