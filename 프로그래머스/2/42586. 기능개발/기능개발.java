import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> q = new LinkedList<>();
        int days = (100 - progresses[0])/speeds[0];
        if((100 - progresses[0]) %speeds[0] !=0){
            days++;
        }
        ArrayList<Integer> list= new ArrayList<>();
        int cnt =1;
        for(int i =1; i<progresses.length; i++){
            int tempDay = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i]) % speeds[i]!=0) tempDay++;
            if(tempDay <=days){
                cnt++;
            }else{
                list.add(cnt);
                cnt =1;
                days = tempDay;
            }
        }
    
        list.add(cnt);
        
        
        answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}