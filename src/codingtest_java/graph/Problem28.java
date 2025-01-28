package codingtest_java.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem28 {
    // 상하좌우 이동을 위한 배열 (순서대로 상, 하, 좌, 우)
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    // 큐에 저장할 노드 클래스
    private static class Node {
        int r, c; // 행(row), 열(column) 좌표

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[][] map; // 지도를 저장할 2차원 배열
    private static int N, M;    // 지도의 크기 (N: 행, M: 열)
    private static ArrayDeque<Node> virus = new ArrayDeque<>(); // 바이러스의 초기 위치를 저장할 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 지도의 행 크기 입력
        M = Integer.parseInt(st.nextToken()); // 지도의 열 크기 입력

        map = new int[N][M]; // 지도 초기화

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 지도의 각 칸 값 입력
                if (map[i][j] == 2) // 바이러스 위치(2)라면 큐에 추가
                    virus.addLast(new Node(i, j));
            }
        }

        int answer = 0; // 최대 안전 영역 크기를 저장할 변수

        // 벽 3개를 세우는 모든 경우의 수 탐색
        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue; // 빈 칸(0)이 아니면 건너뜀
            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) continue; // 빈 칸(0)이 아니면 건너뜀
                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue; // 빈 칸(0)이 아니면 건너뜀
                    // 벽을 세울 위치를 임시로 저장
                    Node[] block = new Node[3];
                    block[0] = new Node(i / M, i % M); // 첫 번째 벽 위치
                    block[1] = new Node(j / M, j % M); // 두 번째 벽 위치
                    block[2] = new Node(k / M, k % M); // 세 번째 벽 위치
                    // 현재 벽을 세운 경우의 안전 영역 크기 계산
                    answer = Math.max(answer, bfs(block));
                }
            }
        }

        System.out.println(answer); // 최대 안전 영역 크기 출력
    }

    private static int bfs(Node[] block) {
        int[][] map2 = new int[N][M]; // 지도의 복사본 생성

        // 기존 맵을 복사해둔다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map2[i][j] = map[i][j];
            }
        }

        // 벽 3개를 세운다.
        for (Node node : block) {
            map2[node.r][node.c] = 1; // 벽(1)로 표시
        }

        ArrayDeque<Node> queue = new ArrayDeque<>(); // BFS를 위한 큐

        // 초기 바이러스 위치를 큐에 추가
        for (Node node : virus) {
            queue.addLast(node);
        }

        // BFS로 바이러스 확산 시뮬레이션
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst(); // 현재 노드 꺼내기

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i]; // 새로운 행 위치
                int nc = now.c + ry[i]; // 새로운 열 위치

                // 지도 범위를 벗어나는 경우 무시
                if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;

                // 벽(1)인 경우 무시
                if (map2[nr][nc] == 1)
                    continue;

                // 빈 칸(0)인 경우 바이러스 확산
                if (map2[nr][nc] == 0) {
                    map2[nr][nc] = 2; // 바이러스(2)로 표시
                    queue.addLast(new Node(nr, nc)); // 큐에 추가
                }
            }
        }

        int cnt = 0; // 안전 영역 크기를 세기 위한 변수

        // 안전 영역(0)의 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map2[i][j] == 0) // 빈 칸(0)인 경우
                    cnt++; // 안전 영역 크기 증가
            }
        }

        return cnt; // 안전 영역 크기 반환
    }
}
