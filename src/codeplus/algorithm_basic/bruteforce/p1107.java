package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());  //이동하려는 채널

        int m = Integer.parseInt(br.readLine());  //고장난 버튼의 개수

        st = new StringTokenizer(br.readLine(), " ");

        int[] num_pad = new int[10];
        for (int i = 0; i < 10; i++) {
            num_pad[i] = i;
        }
        int[] channel_change = new int[2];  // + - 버튼

        for (int i = 0; i < m; i++) {
            num_pad[Integer.parseInt(st.nextToken())] = 0;  //고장난 버튼 제거
        }


    }
    public static void Solution(String s, int N){
        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            arr[i] = s.charAt(i)-'0';
        }
    }
}





//문제 : 리모컨
//알고리즘 : 못 풀었음