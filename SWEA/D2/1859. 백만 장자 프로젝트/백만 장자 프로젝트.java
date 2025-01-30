
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(reader.readLine());
            int [] a = new int[n];
            String [] input = reader.readLine().split(" ");
            for(int i=0; i<n; i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            int max = a[n-1];
            long ans = 0;
            for(int i=n-2; i>=0; i--) {
                if(max>a[i]) {
                    ans += max-a[i];
                } else {
                    max = a[i];
                }
            }
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.print(sb.toString());
    }

}