import java.util.*;
import java.io.*;

public class Main{
    static int K,N;
    static int[] rope;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        rope = new int[K];
        for(int i =0; i<K; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        System.out.println(bSearch());
    }
    public static long bSearch(){
        long start = 1;
        long end = rope[K-1];
        long result =0;

        while(start<=end){
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += rope[i] / mid;
            }

            if (cnt < N) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        return result;
    }
}