import java.io.*;
import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0, numbers,0,target);
        return answer;
    }
    public void dfs(int depth,int[] numbers, int hap, int target){
        if(depth == numbers.length){
            if(hap == target){
                answer++;
            }
            return;
        }
        dfs(depth+1, numbers, hap-numbers[depth],target);
        dfs(depth+1, numbers, hap+numbers[depth],target);
    }

}