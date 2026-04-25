import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] num = new int[100001];
        Arrays.fill(num, Integer.MAX_VALUE);
        num[N] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{N,0});
        int ans = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[0];
            if(idx==K) {
                ans = cur[1];
                break;
            }
            if (num[idx] < cur[1]) continue;
            if (idx > 0 && num[idx - 1] > num[idx] + 1) {
                num[idx - 1] = num[idx] + 1;
                pq.offer(new int[]{idx - 1, num[idx - 1]});
            }
            if (idx < 99999 && num[idx + 1] > num[idx] + 1) {
                num[idx + 1] = num[idx] + 1;
                pq.offer(new int[]{idx + 1, num[idx + 1]});
            }
            if(idx *2<=100000 && num[idx*2]>num[idx]){
                num[idx*2] = num[idx];
                pq.offer(new int[]{idx*2, num[idx*2]});
            }
        }
        System.out.println(ans);
    }
}