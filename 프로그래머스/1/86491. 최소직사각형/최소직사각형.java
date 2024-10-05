import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_X=0;
        int max_Y=0;
        for(int i =0;i<sizes.length; i++){
            if(sizes[i][0]< sizes[i][1]){
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
            max_X = Math.max(max_X,sizes[i][0]);
            max_Y = Math.max(max_Y, sizes[i][1]);
        }
        answer = max_X * max_Y;
        
        return answer;
    }
}