package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;

        str = br.readLine();
        st = new StringTokenizer(str," ");
        sb.append("<");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        //queue 만들기
        for(int i=1; i<= n; i++){
            queue.offer(i);
        }

        while(n-- > 1){
            for(int i=0; i<k-1; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()+", ");
        }

        sb.append(queue.poll()+">");
        System.out.println(sb);

    }
}

// 분류 : 요세푸스 문제(큐)
// 알고리즘 : 7 3을 입력하게되면 7명의 사람이 둥글게 있고 1부터 시작하여 3만큼 간 자리에 있는 사람을 빼서 모든 사람의 순서를 출력한다.{3 6 2 7 5 1 4}
// 배운점 : Queue<Integer> queue = new LinkedList<>(); 를 사용하여 큐를 선언하는 법을 배웠고, 출력하는 중간중간에 있는 구분자를 어떻게 넣을지 고민했는데
// 큐의 마지막에 남은것은 반복문에서 처리하지말고 반복문을 나와서 처리해줌으로써 구분자가 마지막에는 안들어가도록 처리 하는법을 배웠다. 또한 브레이크 포인트를
// 여백에 클릭하여 만들고 디버깅하는 것을 알게되었다..