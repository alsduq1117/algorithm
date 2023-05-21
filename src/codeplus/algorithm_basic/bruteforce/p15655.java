package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15655 {
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

        int[] array_num = Arrays.stream(num).sorted().toArray();
        permutaion(0, 0, array_num, m);

        System.out.println(sb);


    }


    public static void permutaion(int index, int start, int[] num, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < num.length; i++) {
            a[index] = num[i];
            permutaion(index + 1, i + 1, num, m);
        }
    }
}

//문제 : N 과 M(6) 오름차순 조건 추가