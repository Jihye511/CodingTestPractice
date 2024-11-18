import java.util.*;
import java.io.*;
public class Solution {
    public int[] solution(int []arr) {
        
        int before= arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i =1; i<arr.length; i++){
            if(before != arr[i]){
                before= arr[i];
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        int i =0;
        for(int n :list){
            answer[i++] = n;
        }
        return answer;
    }
}