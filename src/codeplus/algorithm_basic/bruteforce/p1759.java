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


//문제 : 암호 만들기
//알고리즘 : 최소 한개의 모음과 최소 두개의 자음으로 구성된 암호 만들어야 한다. 암호는 알파벳이 증가하는 순서로 배열되어있고 L(암호 자릿 수) C(주어진 알파벳 갯수) 이다.
//재귀를 이용하여 모음일 경우에는 vowel + 1을하여 재귀 recursion 을 호출하고  , 자음일 경우에는 consonant + 1 을 하여 recursion을 호출한다.
//index가 L 자릿수가 되면 모음이 1보다 큰이 자음이 2보다 큰지 if 문을 통해 확인하고 맞다면 StringBuilder 에 집어 넣는다.
//배운점 :



