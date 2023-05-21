package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15657 {
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted_num = Arrays.stream(num).sorted().toArray();

        permutation(0,0,sorted_num,m);

        System.out.println(sb);
    }

    public static void permutation(int index, int start, int[] arr, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            a[index] = arr[i];
            permutation(index + 1, i, arr, m);
        }
    }

}
//문제 : N 과 M(8) 중복 허용, 비내림차순 수열