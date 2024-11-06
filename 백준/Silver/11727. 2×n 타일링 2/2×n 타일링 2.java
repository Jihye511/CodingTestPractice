import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[0]=0;
        dp[1] = 1;
        dp[2] = 3;
        for(int i =3; i<=n; i++){
            dp[i] = (dp[i-2]*2 +dp[i-1]) %10007;
        }
        System.out.println(dp[n]);
    }
}