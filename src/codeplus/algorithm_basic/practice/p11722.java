package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if(a[j] > a[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());


    }
}


//문제 : 가장 긴 감소하는 부분 수열 (dp)
//알고리즘 : 배열이 주어졌을때 감소하는 수열 중 가장 큰 부분 수열을 구하는 문제이다.
//i 번째에 최소 길이 1을 넣어 초기화 시켜주고
//i보다 작은 인덱스 j 값들을 비교하여 j일때의 값이 i 일때의 값보다 더 크고 j 일때의 길이의 최대값 + 1 이 i 일때의 길이 보다 커지면
//i번째 값에 j의 최대값 + 1 을 넣어 준다. 여기서 + 1 은 i 를 추가해서 넣어 주는 것이다.
//배운점 : 가장 큰 증가하는 부분 수열에서 힌트를 많이 얻었는데 다음에 풀때도 생각 나도록 머릿속에 박아놔야겠고, Arrays.stream.max() 를 통해
//배열에서 최대값을 출력하는 방법을 알게 되었다.