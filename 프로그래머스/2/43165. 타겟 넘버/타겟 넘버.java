import java.io.*;
import java.util.*;
class Solution {
    static int answer =0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    public static void dfs(int[] numbers, int target, int val, int idx){
        if(idx ==numbers.length){
            if(val == target){
                answer++;
            }
            return;
        }
        dfs(numbers, target, val+numbers[idx], idx+1);
        dfs(numbers, target, val-numbers[idx], idx+1);
    }
}