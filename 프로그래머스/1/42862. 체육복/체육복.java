import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //여벌 체육복 있는애가 도둑맞음
        for(int i =0; i<lost.length; i++){
            for(int j =0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer ++;
                    lost[i] =-1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        //자기번호 +1, -1인 번호에게만 대여가능
        for(int i =0; i<lost.length; i++){
            for(int j = 0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j] ) || (lost[i] +1 ==reserve[j])){
                    answer ++;
                    reserve[j] = - 1;
                    break;
                } 
            }
        }
        
        // ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<Integer> lostList = new ArrayList<>();
        // for(int i =0; i<reserve.length;i++){
        //     list.add(reserve[i]);
        // }
        // for(int i =0; i<lost.length;i++){
        //     lostList.add(lost[i]);
        // }
        // for(int i=0; i<lost.length;i++){
        //     int current = lostList.get(i);
        //     for(int j=0; j<lost.length; j++){
        //         if(currnet -1 == lostList.get(j)){
        //             lost.remove()
        //         }
        //     }
        // }
        return answer;
    }
}