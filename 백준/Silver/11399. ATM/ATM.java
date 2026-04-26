import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] time;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        time = new int[N];
        for(int i =0; i<N; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        int[] wait = new int[N];
        wait[0] = time[0];
        for(int i =1; i<N; i++){
            wait[i] = wait[i-1] + time[i];
        }
        int sum =0;
        for(int i : wait){
            sum += i;
        }
        System.out.print(sum);
    }
}