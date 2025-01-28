package codingtest_java.graph;

import java.util.*;

public class Problem29 {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> roadList = new ArrayList<>();     // [[],[],[],[]]
        for (int i = 0; i <= n; i++) {
            roadList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int road1 = road[0];
            int road2 = road[1];
            roadList.get(road1).add(road2);     //2->1 , 2->3 의 경우 [[],[2],[1,3],[2]]  양방향 연결
            roadList.get(road2).add(road1);
        }


        int[] dist = new int[n + 1];  // 거리 배열 추가
        Arrays.fill(dist, -1); // 모든 지역의 거리를 -1로 초기화
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(destination); // 시작점은 destination
        dist[destination] = 0; // 본부 지역의 거리는 0

        // BFS 수행
        while (!queue.isEmpty()) {
            int now = queue.pollFirst(); // 현재 지역
            for (int neighbor : roadList.get(now)) { // 현재 지역과 연결된 모든 지역을 순회  ex) 목적지 1 의 경우 neighbor은 2
                if (dist[neighbor] == -1) { // dist[2] 까지의 거리가 -1 이라면
                    dist[neighbor] = dist[now] + 1; // 1 + 1 로 거리 2로 갱신
                    queue.addLast(neighbor); // 2에 갈 수 있는 인접한 경로를 찾기 위해 큐에 추가
                }
            }
        }


        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = dist[sources[i]]; // 각 source의 거리를 결과에 추가
        }

        return result;
    }

}
