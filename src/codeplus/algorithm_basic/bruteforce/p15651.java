package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15651 {
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation(0,n,m);

        System.out.println(sb);

    }

    public static void permutation(int index, int n, int m){
        if(index == m){
            for(int i=0; i<m; i++){
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            a[index] = i;
            permutation(index + 1 , n , m);
        }
    }
}
