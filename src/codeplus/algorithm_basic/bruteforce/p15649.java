package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15649 {
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());   //1부터 N 까지 자연수 중에서 중복 없이 M개를 고른 수열
        int m = Integer.parseInt(st.nextToken());

        permutation(0,n,m);
        System.out.print(sb.toString());



    }

    static void permutation(int index, int n, int m) {
        if (index == m) {  //m 개를 다 골랐으면
            for (int i=0; i<m; i++) {   //a[] 배열 안에 있는 수들을 stringBuilder 안에 집어 넣기
                sb.append(a[i]);
                if (i != m-1) sb.append(" ");  //띄어쓰기 해주기
            }
            sb.append("\n");        //줄바꿈 해주기
            return;               //배열 종료
        }
        for (int i=1; i<=n; i++) {
            if (c[i]) continue;       //이미 고른 수 라면 다시 반복문 실행
            c[i] = true;              //고를 숫자를 정했으면 true로 변경
            a[index] = i;             //index 번째에 i 삽입
            permutation(index+1, n, m);     //다음 index 의 숫자 찾기
            c[i] = false;               //다 채운 뒤에는 다시 찾아야 하니까 false로 바꿔주기
        }
    }
}

//문제 : N 과 M(1)
//알고리즘 : 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 구해야 한다. 첫째 자리에는 N 가지의 자연수가 올 수 있고, 다음 자리에는
//N-1개의 자연수가 올 수 있고, 그 다음 자리에는 N-2개의 자연수가 올 수 있다... 이런 규칙성을 토대로 재귀를 이용하여 수열을 출력해야 한다.
//재귀 알고리즘은 다음과 같다. index를 추가하여 index 가 M이 될때까지 1부터 N 까지의 수를 집어넣는데 이때 c 배열을 이용하여
//숫자가 중복인지 판단하고 중복이 아니라면 a[] 배열에 넣어준다. 그리고 index + 1 을 해서 재귀 호출하면 그 다음 자리가 a[] 배열에 채워지게 되고
// index 가 M 이 되면 a[] 배열 안에 들어간 수들을 출력해 준다.

//배운점 : 순열문제를 처음 풀게되었는데, 재귀를 잘 이용해서 풀어야 하는 것 같다. 재귀하는 방법에 익숙해져 보자!