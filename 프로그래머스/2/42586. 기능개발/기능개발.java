import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            day[i] = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0){
                day[i] ++;
            }
        }
        int cnt=1;
        int max;
        max = day[0];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =1; i<progresses.length; i++){
            if(max>=day[i]){
                cnt++;
            }else{
                list.add(cnt);
                max = day[i];
                cnt=1;
            }
            if(i == progresses.length-1){
                list.add(cnt);
            }
        }
        int[] answer = new int[list.size()];
        for(int i =0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}