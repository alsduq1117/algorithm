package codingtest_java.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem14 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solution(n,k);

        System.out.println(sb);
    }
    public static void solution(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            queue.add(i);  //큐에 1~n 까지 데이터 넣어주기
        }

        while(!queue.isEmpty()){
            for(int i=0; i<k-1; i++){  //k-1번
                Integer poll = queue.poll();
                queue.add(poll);
            }
            sb.append(queue.poll() + " ");
        }

    }

}
