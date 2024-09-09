import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] p;
    static int time;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        p = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);
        int time=0;
        int total=0;
        for(int i=0;i<n;i++){
            time += p[i];
            total += time;
        }
        System.out.println(total);
    }
}