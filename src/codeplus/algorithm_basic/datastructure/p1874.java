package codeplus.algorithm_basic.datastructure;

import java.io.*;
import java.util.Stack;

public class p1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int m = 0;

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x > m) {
                while (x > m) {
                    stack.push(++m);
                    sb.append("+"+"\n");
                }
                stack.pop();
                sb.append("-"+"\n");
            }
            else if (x == stack.peek()){
                stack.pop();
                sb.append("-"+"\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
// 분류 : 스택 수열(스택)
// 알고리즘 : 일단 1부터 N까지 차례대로 숫자를 push 하거나 pop하여 주어진 수열을 만들수 있느냐? 없느냐? 하는 문제이다. 가령 4 3 6 8 7... 이 있다면 +(1) +(2) +(3) +(4) -(4) -(3) +(5) +(6) -(6)...
// 이런식으로 만들어야 한다. 넣어야 하는 숫자 = m , 입력 받는 숫자 = x 라고 할때 x > m 이라면  m 은 x 가 될때까지 push 를 해준 뒤 pop을 해준다.
// 그리고 x 가 stack의 top에 있는 값과 같다면 바로 pop을 해준다. 그외에 경우는 수열이 만들어지지 않기때문에 NO를 출력해준다.
// 배운점 : BufferWriter를 이용해서 처음에 문제를 풀려했는데 버퍼의 크기를 초과하게 되면 버퍼를 자동으로 flush 하게 되어 출력초과가 발생했다. 따라서 StringBuilder를 사용하여 해결하였고,
// return 문을 사용하여 메서드를 중간에 종료시키고 원하는 출력문만 나올수 있도록 할수있다는 것을 알게되었다.