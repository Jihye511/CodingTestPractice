import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer_list = new ArrayList<>();
        
        //장르별 총 갯수
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<genres.length; i++){
             map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> keys = new ArrayList<>(map.keySet());
    
		Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1)))); 
        
        //큰 앨범 순으로 반복문(pop- classic)
        for (String genre : keys) {
            // 해당 장르의 노래들 중에서 idx와 plays 저장
            HashMap<Integer, Integer> partMap = new HashMap<>();
            for (int j = 0; j < genres.length; j++) {
                if (genres[j].equals(genre)) {
                    partMap.put(j, plays[j]);  // 인덱스와 재생 횟수 저장
                }
            }
            // partMap에서 값이 큰 상위 2개의 인덱스 찾기
            if(partMap.size()==1){
                answer_list.add(partMap.keySet().iterator().next());
            }else{
                partMap.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue() - e1.getValue())  // value 값을 기준으로 내림차순 정렬
                    .limit(2)  // 상위 2개의 요소만 선택
                    .forEach(e -> answer_list.add(e.getKey()));  // 인덱스(키)를 ArrayList에 추가
            }
            
        }
        
        int[] answer = new int[answer_list.size()];
        for (int i = 0; i < answer_list.size(); i++) {
            answer[i] = answer_list.get(i);
        }
        return answer;
    }
}