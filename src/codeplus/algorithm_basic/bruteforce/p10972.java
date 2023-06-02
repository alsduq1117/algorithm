package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10972 {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation()) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            System.out.println(-1);
        }


    }

    public static boolean nextPermutation() {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] > a[i]) {    //1. 끝에서 가장 큰 감소하는 수열 찾기
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] < a[i - 1]) {    //2. 끝에서 부터 a[i-1] 보다 큰 최소값 찾아주기
            j--;
        }
        swap(i - 1, j);  //내림차순으로 그 다음 수가 없기 때문에 처음으로 내림차순이 꺾이는 지점인 i-1을 j 와 swap

        j = a.length - 1;
        while (i < j) {     //i부터 끝까지 내림차순이였던 배열을 다시 오름차순으로 바꿔준다.예시: 7 6 3 1 -> 1 3 6 7  그래야 최소값인 다음 차례의 수열이 나오니까
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


//문제 : 다음 순열
//알고리즘 : 1. 끝에서 부터 가장 큰 감소하는 수열찾기 , 2. 끝에서 부터 꺾이는 부분인 a[i-1] 보다 큰 최소값 인덱스 j 찾기
//3. swap (i-1, j) 해주기 , 4. i ~ 끝부분 까지 다시 오름차순으로 수열 정렬하기(최소값)

//배운점 : 순열 알고리즘의 기본적인 구현방법에 대해 알게 되었고, 1~4번까지 적은 순서들이 왜 동작하는지에 대해 잘 알고 있어야 까먹지 않을 것 같으니
//왜 그런지에 대해 완벽히 이해하고 넘어가야 겠다.