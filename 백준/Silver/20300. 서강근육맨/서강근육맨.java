import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static long[] amount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        amount = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            amount[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(amount);
        long max =0;
        for(int i =0; i<n/2; i++){
            if(n%2 !=0){
                max = amount[n-1];
                n = n-1;
            }
            if(max < amount[i] + amount[n-1-i]){
                max = Math.max(max,amount[i] + amount[n-1-i]);
            }
        }

        System.out.println(max);
    }
}