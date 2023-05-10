package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());


        long[][] dp = new long[N+1][3];    //[][0] 아무것도 안넣음 ,  [][1] 왼쪽에 배치 [][2], 오른쪽에 배치
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for(int i=2; i<N+1; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901) ;

    }
}

//문제 : 동물원
//알고리즘 : 가로로 두칸 , 세로로 N 칸이 있을때 가로, 세로로 겹치지 않아야 한다. 경우의 수가 3가지 있는데 N번째에 아무것도 넣지 않는 경우,
// N번째에 왼쪽에 배치하는 경우, N번째에 오른쪽에 배치하는 경우이다. N번째에 아무것도 넣지 않는 경우 N-1 번째에는 아무것도 넣지 않는경우, 왼쪽에 배치한 경우, 오른쪽에 배치한 경우
// 모두 다 올 수 있다 따라서 점화식은 dp[N][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] 이다. N번째에 왼쪽에 배치하는 경우는 N-1번째에 아무것도 넣지 않는 경우 , 오른쪽에 배치한 경우가 올 수 있다
// 따라서 점화식은 dp[N][1] = dp[N-1][0] + dp[N-1][2] 이다. 오른쪽도 이와같은 방식으로 풀면 된다
//배운점 : 처음 풀때는 마지막에 9901을 나눠주기에는 너무 값이 클 것 같아서 점화식 도중에 9901을 나눠 줬는데 나중에 세개의 식을 합치는 과정에서 한번 더 9901로 나눠 줘야 한다는 것을 빼먹게 되었다...