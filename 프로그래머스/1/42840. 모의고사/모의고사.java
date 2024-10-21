import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
       
        int [] p1 = {1,2,3,4,5};
        int [] p2 = {2,1,2,3,2,4,2,5};
        int [] p3 = {3,3,1,1,2,2,4,4,5,5};
        int[] sum = new int [3];
        for(int i=0; i<answers.length; i++){
            if(answers[i] == p1[i%p1.length]) sum[0]++;
            if(answers[i] == p2[i%p2.length]) sum[1]++;
            if(answers[i] == p3[i%p3.length]) sum[2]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.max(sum[0],Math.max(sum[1],sum[2]));
        for(int i =0; i<3; i++){
            if(max == sum[i]){
                list.add(i+1);
            }
        }
        Collections.sort(list);
         int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}