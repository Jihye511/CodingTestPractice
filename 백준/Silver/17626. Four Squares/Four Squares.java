import java.io.*;
import java.util.*;

public class Main {
    static int [] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        System.out.println(solve(n));
    }
    public static int solve(int num){

        for(int i =2; i<=num; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j*j<=i; j++){
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min +1;
        }
        return dp[num];
    }
}
/*
1 = 1*1
2 = 1*1 +1*1
3 = 1*1 +1*1 + 1*1
4 = 2*2
5 = 2*2 + 1*1l
6 = 2*2 + 1*1 + 1*1
7 = 2*2 + 1*1 + 1*1 + 1*1
8 = 2*2 + 2*2
9 = 3*3
10 = 3*3 + 1*1
11 = 3*3 + 1*1 + 1*1
12 = 3*3 + 1*1 + 1*1 + 1*1
13 = 3*3 + 2*2
14 = 3*3 + 2*2 + 1*1
15 = 3*3 + 2*2 + 1*1 + 1*1

점화식
 dp[i] = min(dp[i-j*j])+1


 */