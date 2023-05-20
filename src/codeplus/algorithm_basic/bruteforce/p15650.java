package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15650 {
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열(오름 차순)
        int m = Integer.parseInt(st.nextToken());
        int s = 1;

        permutation(0,s,n,m);

        System.out.println(sb);



    }

    static void permutation(int index, int s , int n, int m){   //s 는 시작 수
        if(index == m) {
            for(int i=0; i<m; i++){
                sb.append(a[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=s; i<=n; i++){      // s값 부터 시작해야 오름차순 진행 가능
            if(c[i]) continue;  // c[i] == true 면 반복문 다시 진행
            c[i] = true; // 중복 체크
            a[index] = i;
            permutation(index+1,i+1,n,m);
            c[i] = false;
        }

    }
}
