package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 1; i < (1 << n); i++) {   // 1 부터 2의n 승까지
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) != 0) {
                    sum += a[k];
                }
            }

            if(sum == s){
                ans += 1;
            }
        }

        System.out.println(ans);

    }
}


//문제 : 부분수열의 합
//알고리즘 : 다시 풀어보기