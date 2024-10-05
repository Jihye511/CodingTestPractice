import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int k = commands.length;
        answer = new int[k];
        
        for(int i =0; i<k; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int v = commands[i][2]-1;
            for(int j=0; j<array.length; j++){
                if(start <= j && end>=j){
                    list.add(array[j]);
                }
            }
            Collections.sort(list);
            answer[i]=list.get(v);
        }
        return answer;
    }
}