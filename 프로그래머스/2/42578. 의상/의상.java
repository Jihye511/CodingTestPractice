import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i =0;i<clothes.length; i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
            set.add(clothes[i][1]);
        }
        int cnt=1;
        for (String key : set) {
            int n = map.get(key);
            cnt *= (n + 1);
        }
        answer = cnt-1;
        return answer;
    }
}