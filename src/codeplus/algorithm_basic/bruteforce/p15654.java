package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p15654 {
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");


        ArrayList<Integer> arrayList = new ArrayList<>(n);

        while (st.hasMoreTokens()) {
            arrayList.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(arrayList);  // 오름차순으로 정렬

        permutaiton(0,m,arrayList);

        System.out.println(sb);
    }


    public static void permutaiton(int index, int m, ArrayList arrayList) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
        }

        for(int i=0; i<arrayList.size(); i++){
            if(c[i]) continue;
            c[i] = true;
            a[index] = (int) arrayList.get(i);
            permutaiton(index + 1, m, arrayList);
            c[i] = false;
        }


    }
}

//문제 : N 과 M(5) (N 이 0부터 N 까지의 숫자가 아닌 N 개의 자연수가 주어진다)
//알고리즘 : 새로운 배열을 만들어서 숫자를 저장해 준 뒤에 기존의 0부터 N 까지가 아니라 새로 만들어서 넣어준 배열의 인덱스 0 부터 n 까지의 값을 가지고 계산하면 된다
//배운점 : st.nextToken 을 사용하기 위해서 arrayList 를 사용했는데 오름차순으로 정렬할때 다음과 같이 Collections.sort(arrayList)를 해주면 된다.
//내림차순으로 정렬하고 싶을 때는 Collections.sort(list, Collections.reverseOrder()); 이렇게 해주면 된다.