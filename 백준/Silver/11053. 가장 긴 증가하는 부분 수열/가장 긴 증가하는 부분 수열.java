import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] num = new int[A];
        int[] dp = new int[A];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i =0; i<A; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);
        for(int i =0; i<A; i++){
            for(int j =i+1; j<A; j++){
                if(num[i]<num[j]){
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                }

            }
        }
        Arrays.sort(dp);
        System.out.println(dp[A-1]);
    }


}