import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[][] student = {{1,2,3,4,5},
                           {2,1,2,3,2,4,2,5},
                           {3,3,1,1,2,2,4,4,5,5}
                           };
        int[] ans = new int[3];
        for(int i= 0; i<answers.length; i++){
            for(int j =0; j<3; j++){
                if(answers[i] == student[j][i%student[j].length]){
                    ans[j]++;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max =-1;
        for(int i: ans){
            max= Math.max(i,max);
        }
        for(int i=0; i<3; i++){
            if(max == ans[i]){
                list.add(i+1);
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int n=0; n<list.size(); n++){
            answer[n] = list.get(n);
        }
        return answer;
    }
}