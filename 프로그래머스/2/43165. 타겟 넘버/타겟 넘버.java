import java.io.*;
import java.util.*;
class Solution {
    static int[] number;
    static int targetnum;
    static int answer = 0;
    static int sum=0;
    public int solution(int[] numbers, int target) {
        number = numbers;
        targetnum = target;
        
        dfs(0, 0);
        return answer;
    }
    public static void dfs(int num, int sum){
        if(num == number.length){
            if(sum == targetnum){
                answer +=1;
                return;
            }
            
        }else{
            dfs(num+1 , sum + number[num]);
            dfs(num+1 , sum - number[num]);
        }
        
        
    }
}