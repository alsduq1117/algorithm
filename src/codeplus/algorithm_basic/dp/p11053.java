package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001]; // 숫자를 넣는 배열
        int[] d = new int[1001]; // 최대 수열의 길이를 넣는 배열

        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            dp[i] = a;
            d[i] = 1;

            for (int j = 0; j < i; j++) {
                if (d[j] + 1 > d[i] && dp[j] < dp[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max,d[i]);
        }
        System.out.println(max);
    }
}


//분류 : 가장 긴 증가하는 부분 수열(dp)
//알고리즘 : 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
//이때 문제를 푸는 방법은 숫자를 넣을 배열 dp 와 최대 수열을 저장하는 d 배열을 만들어주고, d[i] 를 구하는 방법은 d[0]~ d[i-1] 까지 dp[i]의 값보다
// dp[0]~dp[i-1]안 j번째에 더 작은 수가 있다고 가정하면, 이때의 d[j]+1 값이 d[i] 값보다 크면 dp[i] 입장에선 dp[j]는 나보다 작은 값인데 최대 수열 값이 나보다 크네?
// 하면서 값을 d[i]에다가 d[j]+1 값을 넣어줌으로써 최대 수열의 길이를 구해나갈 수 있다.
// 배운점: 마지막 수가 제일 크지않으면 당연히 d[]배열을 돌면서 max 값을 찾아야하는데, 생각을 못했다.. 처음에 d[j]값이랑 d[i] 값이랑 비교를 해서
//자꾸 엉뚱한 답이 나왔는데 잘못생각했던 것 같다.dp[j]와dp[i]가 값이 같다면, dp[j]가 dp[i]보다 크면 d[i] = d[j]+1 을 해줘야 하는데 d[j]>d[i]를
//비교해주면 같은 d[] 배열 값에 대한 처리를 해주지 못한다.