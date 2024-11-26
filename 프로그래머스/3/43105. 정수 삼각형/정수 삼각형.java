import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int depth = triangle.length;
        for(int i =1; i<depth; i++){ // 깊이에 대한 for문
            for(int j =0; j<triangle[i].length; j++){ // 각 줄에 대한 for문
                if(j == triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][j-1];
                }else if( j ==0){
                     triangle[i][j] += triangle[i-1][j];
                }else{
                    int max=0;
                    for (int k = 0; k < 2; k++) {
                        max= Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                    }
                    triangle[i][j] +=max;
                }
            }
        }
        for(int val : triangle[depth-1]){
            answer = Math.max(answer,val);
        }
        return answer;
    }
}