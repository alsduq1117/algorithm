package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2529 {
    static boolean[] num = new boolean[10];  //false로 초기화
    static StringBuilder sb = new StringBuilder();
    static int[] result = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        String[] a = new String[k];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            a[i] = st.nextToken();
        }

        inequalitySign(0, k, a);

        System.out.println(sb);


    }


    static void inequalitySign(int index, int k, String[] a) {
        //다 찾은 경우
        if (index == k + 1) {
            for (int i = 0; i < k + 1; i++) {
                sb.append(result[i]);
            }
            sb.append("\n");
            return;
        }


        //숫자 집어넣기
        for (int i = 0; i <= 9; i++) {
            if (num[i]) continue;

            if (index == 0) {                          //index == 0 이면 0번째 index에 바로 넣어주기
                result[index] = i;
                num[i] = true;
                inequalitySign(index + 1, k, a);
            } else {
                if (a[index-1].equals(">")) {
                    if (result[index - 1] > i) {
                        result[index] = i;
                        num[i] = true;
                        inequalitySign(index + 1, k, a);
                        num[i] = false;
                    } else {
                        continue;
                    }
                } else {
                    if (result[index - 1] < i) {
                        result[index] = i;
                        num[i] = true;
                        inequalitySign(index + 1, k, a);
                        num[i] = false;
                    } else {
                        continue;
                    }
                }
            }
        }

    }

}

//