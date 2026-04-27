import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] item = new int[N][2];
        int[] dp = new int[K+1];
        Arrays.fill(dp, 0);
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<N; i++){
            int w = item[i][0];
            int v = item[i][1];
            for(int j = K; j>=w; j--){
                dp[j] = Math.max(dp[j], dp[j-w]+v);
            }
        }
        System.out.println(dp[K]);

    }
}