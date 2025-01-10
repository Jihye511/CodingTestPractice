import java.util.*;
import java.io.*;
public class Solution {
    public int[] solution(int []arr) {
        int before = arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(before);
        for(int i=1; i<arr.length; i++){
            if(arr[i] ==before){
                continue;
            }
            else{
                before = arr[i];
                list.add(before);
            }
        }
        int[] answer =new int[list.size()];
        int i =0;
        for(int v : list){
            answer[i] = v;
            i++;
        }
        return answer;
    }
}