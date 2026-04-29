import java.io.*;
import java.util.*;
class Solution {
    static int n;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        n=0;
        dfs(numbers, target, 0, 0);
        answer = n;
        return answer;
    }
    public static void dfs(int[] numbers, int target, int val, int depth){
        if(depth == numbers.length){
            if(val == target) n++;
        
            return;
        }
        
        dfs(numbers, target, val + numbers[depth], depth+1);
        dfs(numbers, target, val - numbers[depth], depth+1);
        
    }
}