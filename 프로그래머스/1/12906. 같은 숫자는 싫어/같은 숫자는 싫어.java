import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int before = arr[0];
        for(int i =1; i<arr.length; i++){
            if(before==arr[i]) continue;
            else{
                before = arr[i];
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}