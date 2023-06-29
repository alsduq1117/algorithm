package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 1; i < (1 << n); i++) {       // 1부터 2의n 승 까지
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {        // i 값와 2의 j승 값을 비트 AND 연산해주면
                    sum += arr[j];
                }
            }

            if (sum == s) {
                ans += 1;
            }
        }

        System.out.println(ans);


    }
}


//문제 : 부분수열의 합 (비트마스크)
//풀이 : i 는 1 ~ 2의n승까지 반복문을 돌게되고, 밑에 이중 for 문의 j 값은 0 ~ n 자리의 비트라고 생각하면된다.
//만약 n이 5라고 가정하고 i 가 1 이라면 비트로 00001 이 되고 j = 0 일때 2의 0승이므로 00001 을 만족하여 sum 에 0번째 인덱스 값이 들어간다
//또 다른 예시로 n = 5 이고, i 가 3이라면 비트로 00011 이 되고 j = 0 일때 와 j = 1 일때 2의 0승 , 2의 1승이므로 비트 00011 을 충족한다
// 따라서 sum 에는 arr 의 0번째 index 값과 1번째 index 값이 들어가게 된다
// 이런 식으로 모든 비트에 대해 반복문을 돌며 계산하게 되고 만약 그 값이 s 와 값다면 ans += 1 을 해주어 부분수열의 개수를 구할 수 있게 된다.
//배운점 : 비트 연산을 이용하여 반복문을 만들고 이를 활용할 수 있다는것이 신기했다.