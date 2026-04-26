import java.util.*;
import java.io.*;
public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        int before =-1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(arr[i] != before){
                before = arr[i];
                list.add(arr[i]);
            }
        }
        answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}