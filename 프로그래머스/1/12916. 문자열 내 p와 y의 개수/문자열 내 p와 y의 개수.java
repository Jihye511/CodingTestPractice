import java.io.*;
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toLowerCase().toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        if(map.get('p') != map.get('y')) return false;
        return answer;
    }
}