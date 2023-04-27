package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            dp[i] = i;  // 1의 제곱으로만 나타냈을때의 수(최대값이라고 볼 수 있음)
            int min = 999999;
            for(int j=1; (j*j)<=i; j++){
                if(min > dp[i-(j*j)] + 1){
                    min = dp[i-(j*j)] + 1;
                }
            }
            dp[i] = min;
        }

        System.out.println(dp[n]);
        
    }
}


//문제 : 제곱수의 합(dp)
//알고리즘 : n 을 제곱수의 합으로 나타낸다고 가정할때 n이라는 값은 n-i^2 + i^2 으로 나타낼 수 있다. 따라서 [n-i^2] 까지의 최소합에 i^2을
// 즉 +1 을 더해주면 제곱수의 최소 합이 된다. 따라서 bottom-up 방식으로 차곡차곡 쌓인 최소합을 통해 n까지의 제곱수의 합의 최소 갯수를 구할 수 있다.
