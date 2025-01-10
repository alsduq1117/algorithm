package codingtest_java.hash;

import java.util.*;
import java.util.stream.Collectors;

public class Problem23 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlaysMap = new HashMap<>();  // 장르별 재생횟수
        Map<String, HashSet<Integer>> genreSongIdMap = new HashMap<>();  // 장르에 속하는 고유번호 취합
        Map<Integer, Integer> songIdPlaysMap = new HashMap<>();   // 고유 번호 별 재생 횟수
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];

            genrePlaysMap.put(genre,genrePlaysMap.getOrDefault(genre, 0) + play);
            genreSongIdMap.putIfAbsent(genre, new HashSet<>());
            genreSongIdMap.get(genre).add(i);                //장르별 고유번호 추가
            songIdPlaysMap.put(i,play);
        }

        List<String> genreRank = new ArrayList<>(genrePlaysMap.keySet());
        Collections.sort(genreRank, Comparator.comparing(genrePlaysMap::get).reversed());  //재생횟수 내림차순으로 장르 정렬


        for(String genre : genreRank){
            List<Integer> songIds = genreSongIdMap.get(genre).stream().collect(Collectors.toList());  //해당 장르에 속하는 곡 고유 번호 리스트

            List<Integer> topSongs = songIds.stream()
                    .sorted((a, b) -> songIdPlaysMap.get(b).compareTo(songIdPlaysMap.get(a))) // 내림차순 정렬
                    .limit(2) // 상위 2곡 선택
                    .collect(Collectors.toList());

            result.addAll(topSongs); // 결과에 추가
        }

        return result.stream().mapToInt(i -> i).toArray();

    }
}
