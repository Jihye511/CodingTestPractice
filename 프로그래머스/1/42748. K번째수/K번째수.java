import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i =0; i<commands.length; i++){
            int[] cur = commands[i];
            ArrayList<Integer> list = new ArrayList<>();
            for(int j =cur[0]-1; j<cur[1]; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(cur[2]-1);
        }
        return answer;
    }
}