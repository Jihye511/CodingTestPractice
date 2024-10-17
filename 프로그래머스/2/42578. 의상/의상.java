import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        //HashMap 넣기
        HashMap<String,Integer> pair = new HashMap<>();
       
        for(int i =0; i<clothes.length; i++){
            pair.put(clothes[i][1], pair.getOrDefault(clothes[i][1],1)+1);
        }
        for(Integer val : pair.values()){
            answer = answer *val;
        }
        return answer-1;
    }
}