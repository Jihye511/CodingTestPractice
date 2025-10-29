import java.io.*;
import java.util.*;
    
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> list = new HashSet<>();
        for(int i =0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
            list.add(clothes[i][1]);
        }
        for(String key : list){
            int n = map.get(key);
            answer *= (n+1);
        }
        return answer-1;
    }
}