package codingtest_java.graph;

import java.util.ArrayDeque;

public class Problem27 {

    // 상하좌우 이동을 위한 배열 (순서대로 상, 하, 좌, 우)
    private static final int[] rx = {-1, 1, 0, 0};
    private static final int[] ry = {0, 0, -1, 1};

    // 큐에 저장할 노드 클래스
    private static class Node {
        int r, c; // 행(row), 열(column) 좌표

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] maps) {
        int N = maps.length;      // 맵의 행(가로 줄) 개수
        int M = maps[0].length;   // 맵의 열(세로 줄) 개수

        // BFS 탐색을 위한 큐
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 방문 여부를 저장하는 2차원 배열
        boolean[][] visited = new boolean[N][M];
        // 시작점으로부터의 최단 거리를 저장하는 2차원 배열
        int[][] dist = new int[N][M];

        // 시작 지점 (0, 0)을 큐에 추가하고 방문 처리, 거리 1로 초기화
        queue.addLast(new Node(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 현재 노드(위치)를 꺼냄
            Node now = queue.pollFirst();

            // 현재 위치에서 상하좌우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                // 다음 이동할 좌표 계산
                int nr = now.r + rx[i]; // 다음 행 좌표
                int nc = now.c + ry[i]; // 다음 열 좌표 (이전 코드에서 오류가 있던 부분)

                // 맵 범위를 벗어나는 경우 건너뜀
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                // 이동할 수 없는 칸(벽, 값이 0인 칸)인 경우 건너뜀
                if (maps[nr][nc] == 0) {
                    continue;
                }

                // 아직 방문하지 않은 칸인 경우
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;       // 방문 처리
                    queue.addLast(new Node(nr, nc)); // 큐에 추가
                    dist[nr][nc] = dist[now.r][now.c] + 1; // 최단 거리 갱신 (현재 위치까지의 거리 + 1)
                }
            }
        }

        // 도착 지점(N-1, M-1)까지의 최단 거리를 반환
        // 도착 지점에 도달하지 못한 경우(dist 값이 0인 경우) -1 반환
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }

}
