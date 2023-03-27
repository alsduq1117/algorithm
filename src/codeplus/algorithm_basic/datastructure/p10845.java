package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10845 {
    static int[] queue = new int[10000];
    static int begin = 0;
    static int end = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String m = br.readLine();
            st = new StringTokenizer(m, " ");
            String m1 = st.nextToken();
            switch (m1) {
                case "push":
                    int m2 = Integer.parseInt(st.nextToken());
                    push(m2);
                    break;

                case "pop":
                    sb.append(pop() + "\n");
                    break;
                case "size":
                    sb.append(size() + "\n");
                    break;

                case "empty":
                    sb.append(empty() + "\n");
                    break;

                case "front":
                    sb.append(front() + "\n");
                    break;

                case "back":
                    sb.append(back() + "\n");
                    break;

            }
        }
        System.out.println(sb);

    }


    public static void push(int n) {
        queue[end] = n;
        end += 1;
    }

    public static int pop() {
        if (begin < end) {
            int n = queue[begin];
            begin += 1;
            return n;
        } else {
            return -1;
        }
    }

    public static int size() {
        return end - begin;
    }

    public static int empty() {
        if (end == begin) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() {
        if (end == begin) {
            return -1;
        } else {
            return queue[begin];
        }
    }

    public static int back() {
        if (end == begin) {
            return -1;
        } else {
            return queue[end-1];
        }
    }
}

// 분류 : 큐 구현 문제
// 알고리즘 : queue는 한쪽 끝에서만 자료를 넣고 한쪽 끝에서만 자료를 뺄 수 있는 구조이다.또한 [begin, end) 이다.
// 배운점 : 일단 후위연산자 ++과 += 1 이 솔직히 배열 안에서도 똑같이 동작하나? 먼저 변수를 더해주고 그 인덱스를 가져오는거 아니야?
// 라는 의심이 있었지만 둘다 end 인덱스에 있는 값을 가져온뒤 end+1이 되었다. 다음에는 까먹지 않도록 하자
// 또한, 메인메서드는 정적으로 선언되었기 때문에 객체를 사용하지 않고 메서드를 사용하려면 변수,메서드들이 모두 static으로 선언
// 되어야 사용 가능하다는 것이다. 또한 static 키워드를 보는 순간 객체가 생성되지 않아도 항상!! 메모리를 할당해준다.
//  new를 통해 객체를 생성하면 각 인스턴스는 서로 독립적이지만  static 키워드가 붙은 멤버들은 모든 객체가 메모리 영역을 공유

