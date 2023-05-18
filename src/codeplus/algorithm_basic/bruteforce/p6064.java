package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            boolean find = false;
            int[] arr = new int[4]; // 인덱스 0 : M , 1: N , 2 : x , 3 : y
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < 4; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = arr[2]; i < Integer.MAX_VALUE; i += arr[0]) {
                if (i % arr[1] == arr[3]) {
                    sb.append(i + "\n");
                    find = true;
                    break;
                }
            }

            if (find == false) {
                sb.append(-1 + "\n");
            }

        }

        System.out.println(sb);
    }
}
