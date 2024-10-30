import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int [] map;
    static long [] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N];
        distance = new long[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        //거리 차 저장
        for(int i =1; i<N; i++){
            distance[i-1] = map[i]-map[i-1];
        }
        Arrays.sort(distance);
        long sum=0;
        for(int i =0; i<N-K; i++){
            sum += distance[i];
        }
        System.out.println(sum);
    }
}
