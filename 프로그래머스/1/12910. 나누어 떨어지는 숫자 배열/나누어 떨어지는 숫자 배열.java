import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(num % divisor ==0) list.add(num);
        }
        
        Collections.sort(list);
        int size = list.size();
        if(size ==0){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[size];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}