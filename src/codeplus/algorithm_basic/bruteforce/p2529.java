package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p2529 {
    static boolean[] num = new boolean[10];  //false로 초기화
    static StringBuilder sb = new StringBuilder();
    static List<Long> arrayList = new ArrayList();
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

        StringTokenizer st2 = new StringTokenizer(sb.toString(), "\n");

        String min = st2.nextToken();//최소값
        String max = "";


        while (st2.hasMoreTokens()) {
            max = st2.nextToken();
        }


        System.out.println(max);
        System.out.println(min);


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
                num[i] = false;
            } else {
                if (a[index - 1].equals(">")) {
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

// 문제 : 부등호
// 풀이 : k 개의 부등호가 주어지고 부등호 사이에 k+1 개의 부등호에 맞게 배치해야 한다.
// i 는 0 부터 9 까지의 반복문이고 만약 num[i] 가 false 라면 중복이 아닌거고,  num[i] 가 true 이면 중복된 숫자이기 때문에 continue 해준다
// 만약 index 가 0 일때는 i 의 값을 바로 집어넣어 주고
// i 의 값을 사용할때는 num[i] = true 를 넣어주고 재귀를 호출해준 뒤에 재귀 호출이 마무리 되면 다시 false 로 만들어주어 다른 숫자를 찾을 수 있도록 한다.
// index 가 0 이 아닐때는 부등호에 따라 > , < 를 바로 이전 값 index-1 의 값과 i 값을 비교하여 부등호가 성립하면 넣어주고 index+1 를 하여 재귀를 호출해준다.
