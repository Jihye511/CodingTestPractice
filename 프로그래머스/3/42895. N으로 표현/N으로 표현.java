import java.io.*;
import java.util.*;
class Solution {
    static HashSet<Integer>[] dp;
    public int solution(int N, int number) {
        int answer = -1;
        dp = new HashSet[9];
        for(int i =0; i<9; i++){
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        if(N == number ) return 1;
        
        for(int i =2; i<9; i++){
            for(int j =1; j<i; j++){
                //j랑 i-j랑 이렇게 두개 더하기
                for(int p : dp[j]){
                    for(int t : dp[i-j]){
                        //이어붙이기
                        String s = "";
                        for(int q =1; q<=i; q++){
                            s +=N;
                        }
                        dp[i].add(Integer.parseInt(s));
                        //더하기
                        dp[i].add(p+t);
                        //곱하기
                        dp[i].add(p*t);
                        //나누기
                        if(p%t==0 && p/t>0){
                            dp[i].add(p/t);
                        }
                    
                        //빼기
                        if(p-t>0){
                            dp[i].add(p-t);
                        }
                    }
                }
            }
            if(dp[i].contains(number)){
                answer = i;
                break;
            }
        }
    
        return answer;
    }
}