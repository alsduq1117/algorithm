package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p10973 {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (prevPermutation()) {
            for (int i = 0; i < n; i++) {
                sb.append(a[i] + " ");
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);


    }

    public static boolean prevPermutation() {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] < a[i]) {  //끝에서 가장 긴 오름차순인 수열을 찾아준다.
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;    //i-1 보다 작은수의 최대값을 오름차순 수열에서 찾아준다.
        while (a[j] > a[i - 1]) {
            j--;
        }

        swap(i - 1, j);       //i-1 과 j 의 자리 바꿔주기

        j = a.length - 1;       //i ~ 끝을 내림차순 수열 (가장 큰 수열) 로 바꿔주기
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


//문제: 이전 순열
//알고리즘 : 1. 끝에서 가장 긴 오름차순 수열을 찾는다. 2.i-1 보다 작은 최대값을 오름차순 수열에서 찾는다
//3. swap(i-1, j) , 4. 오름차순 수열(최소 수열)을 내림차순(최대 수열)으로 바꿔준다.

//배운점 : StringTokenizer를 쓰지 않고 stream 을 이용하여 Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//다음과 같이 간단하게 한줄로 숫자들을 받을 수 있다는 것을 알게 되었다.