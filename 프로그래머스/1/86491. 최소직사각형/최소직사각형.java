import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        // ArrayList<Integer> list = new ArrayList<>();
        int colMax=0;
        int rowMax=0;
        for(int i =0; i<sizes.length; i++){
            if(sizes[i][1]>sizes[i][0]){
                colMax = Math.max(colMax, sizes[i][1]);
                rowMax = Math.max(rowMax, sizes[i][0]);
            }else{
                colMax = Math.max(colMax, sizes[i][0]);
                rowMax = Math.max(rowMax, sizes[i][1]);
            }
            
        }
        answer = colMax*rowMax;
        return answer;
    }
}