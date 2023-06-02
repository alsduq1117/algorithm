package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1759 {
    static String a[] = new String[15];
    static boolean b[] = new boolean[15];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] s = br.readLine().split(" ");
        int l = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);


        st = new StringTokenizer(br.readLine(), " ");

        String[] array = new String[c];

        for (int i = 0; i < c; i++) {
            array[i] = st.nextToken();
        }

        Arrays.sort(array); //배열 정렬

        recursion(0, l, array, 0, 0, 0);
        System.out.println(sb);

    }


    public static void recursion(int index, int l, String[] array, int start, int vowel, int consonant) {
        if (index == l) {
            if (consonant >= 2 && vowel >= 1) {
                for (int i = 0; i < l; i++) {
                    sb.append(a[i]);
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = start; i < array.length; i++) {
            if (b[i]) continue;
            b[i] = true;
            a[index] = array[i];
            if (array[i].equals("a") || array[i].equals("e") || array[i].equals("i") || array[i].equals("o") || array[i].equals("u")) {
                recursion(index + 1, l, array, i + 1, vowel + 1, consonant);
            } else {
                recursion(index + 1, l, array, i + 1, vowel, consonant + 1);
            }
            b[i] = false;
        }

    }
}



