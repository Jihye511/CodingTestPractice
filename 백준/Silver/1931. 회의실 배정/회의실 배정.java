import javax.management.Query;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] time;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N][2];
        for(int i =0; i<N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(time, (a,b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }); //종료시점기준으로 오름차순
        int end =0;
        for(int i =0; i<N; i++){
            if(time[i][0] >= end){
                max++;
                end = time[i][1];
            }
        }

        System.out.println(max);
    }

}