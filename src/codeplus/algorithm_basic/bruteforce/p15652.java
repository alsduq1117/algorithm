package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15652 {
    static int[] a = new int[10];
    static int[] c = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation(0, n, m, 1);

        System.out.println(sb);

    }

    public static void permutation(int index, int n, int m, int k) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = k; i <= n; i++) {
            a[index] = i;
            permutation(index + 1, n, m, i);
        }
    }
}

//문제 : N과 M(4) 중복 허용, 비 내림 차순 수열이여야 한다
//알고리즘 : N개의 서로 다른 자연수 중에서 M개를 고른 수열을 모두 구하는 문제 ,k 를 추가하여 k 부터 n 까지 중에서 수를 고를수 있도록 해야한다.