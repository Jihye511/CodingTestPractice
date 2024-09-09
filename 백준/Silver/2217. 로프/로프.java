import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] rope;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        rope = new int[n];
        for(int i =0; i<n; i++){
            rope[i] =Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        int total =0;
        for(int i =n-1; i>-1; i--){
            total = Math.max(total, rope[i]*(n-i));
        }
        System.out.println(total);
    }
}