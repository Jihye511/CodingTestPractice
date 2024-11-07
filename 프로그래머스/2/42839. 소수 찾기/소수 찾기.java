import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static char[] c;
    static HashSet<Integer> hash = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        c = numbers.toCharArray();
        visited = new boolean[c.length];
        // for(int i=0; i<numbers.length(); i++){
        //     int num = Integer
        // }
        dfs("",0);
        answer = hash.size();
        return answer;
    }
    public static void dfs(String str , int idx){
        int num;
        if(str !=""){
            num = Integer.parseInt(str);
            if(checkNum(num)) hash.add(num);
        }
        if(idx==c.length) return;
        for(int i =0; i<c.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs( str + c[i], idx+1);
                visited[i]=false;
            }
        }
    }
    public static boolean checkNum(int num){
        if(num==0||num==1) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i ==0) return false;
        }
        return true;
    }
}