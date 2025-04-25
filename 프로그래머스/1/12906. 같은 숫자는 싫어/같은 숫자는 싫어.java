import java.util.*;
import java.io.*;
public class Solution {
    public int[] solution(int []arr) {
        
        int before = arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(before);
        for(int i =1; i<arr.length; i++){
            if(arr[i] !=before){
                list.add(arr[i]);
                before = arr[i];
            }
            
        }
        int[] answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}