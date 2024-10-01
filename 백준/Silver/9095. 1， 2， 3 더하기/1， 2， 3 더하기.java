import java.io.*;
import java.util.*;

public class Main{
    static int T,n;
    static int[] dp=new int[11];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T= Integer.parseInt(br.readLine());
        while (T-->0){
            n = Integer.parseInt(br.readLine());
            dp[0]=0;
            dp[1]=1;
            dp[2]=2;
            dp[3]=4;
            for(int i =4;i<11;i++){
                dp[i]= dp[i-3]+dp[i-2]+dp[i-1];
            }
            System.out.println(dp[n]);
        }
    }
}