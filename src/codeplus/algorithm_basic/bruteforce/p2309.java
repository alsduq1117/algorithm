package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int[] a = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
            total += a[i];
        }


        int over_height = total - 100;

        Loop1 :
        for (int i = 0; i < 9; i++) {
            Loop2 :
            for (int j = i + 1; j < 9; j++) {
                if (over_height == a[i] + a[j]) {
                    a[i] = 0;
                    a[j] = 0;
                    break Loop1;
                }
            }
        }

        int[] sorted_array = Arrays.stream(a).sorted().toArray();


        for (int i = 0; i < 9; i++) {
            if (sorted_array[i] != 0) {
                sb.append(sorted_array[i] + "\n");
            }
        }

        System.out.println(sb);


    }
}

//문제 : 일곱 난쟁이 (bruteforce)
//알고리즘 : 브루트 포스이기때문에 크게 알고리즘은 없고 9명의 사람중에서 난쟁이가 아닌 2명을 찾아주면 되기 때문에
//키의 합에서 두명을 키를 뺐을때 100이 되면 출력해주면된다.
//배운점 : 처음에는 break; 문을 써서 뺏을때 100이 되는 2명을 찾으면 바로 반복문을 종료시키려 했는데 break 문은 중첩 반복문에서는 전체 반복문을
//종료시키는게 아닌 break 문이 쓰여진 for 문만 벗어날 수 있었다.. 따라서 중첩 반복문을 한번에 종료 시키려면 어떻게 해야하는지 고민했는데
//Loop1 : , Loop2 : 를 사용해서 break Loop1;을 하게 되면 중첩 반복문을 한번에 빠져나올 수 있게 된다는 것을 알게되었다!!