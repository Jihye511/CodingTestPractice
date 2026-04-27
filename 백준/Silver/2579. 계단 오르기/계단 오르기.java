import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] step = new int[301];
        for(int i =0; i<n; i++){
            step[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[301];
        dp[0] = step[0];
        dp[1] = step[0] + step[1];
        dp[2] = Math.max(step[0], step[1]) + step[2];

        for(int i =3; i<n; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3] + step[i-1]) + step[i];
        }
        System.out.println(dp[n-1]);
    }
}