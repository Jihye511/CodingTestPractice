import java.io.*;
import java.util.*;

public class Main {
   static int N,E;
   static ArrayList<int[]> [] node;
   static int[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        node = new ArrayList[N+1];
        for(int i =0; i<N+1; i++){
            node[i] = new ArrayList<>();
        }
        for(int i =0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            node[s].add(new int[]{e,c});
            node[e].add(new int[]{s,c});
        }
        v = new int[2];
        st = new StringTokenizer(br.readLine());
        v[0] = Integer.parseInt(st.nextToken());
        v[1] = Integer.parseInt(st.nextToken());

        //1에서 N으로 이동
        /*
        1에서 v0 + v0 에서 v1 + v1에서 N
        1 -> v1 + v1->v0 + v0 ->N
        공통적으로 v1 - v2 구하고 1-v1, 1-v0, n-v0, n-v1구하기
         */
        int v1v2 = dij(v[0], v[1]);
        if(v1v2 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        int temp1 = dij(1,v[0]);
        int temp2 = dij(v[1],N);
        int ver1;
        if(temp1== Integer.MAX_VALUE ||temp2 == Integer.MAX_VALUE) ver1 = Integer.MAX_VALUE;
        else ver1 = temp1+ temp2 +v1v2;

        temp1 = dij(1,v[1]);
        temp2 = dij(v[0], N);
        int ver2;
        if(temp1== Integer.MAX_VALUE ||temp2 == Integer.MAX_VALUE) ver2 = Integer.MAX_VALUE;
        else ver2 = temp1+ temp2 +v1v2;

        int min = Math.min(ver1, ver2);
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);

    }
    public static int dij(int start, int end){
        int[] val = new int[N+1];
        Arrays.fill(val, Integer.MAX_VALUE);
        PriorityQueue< int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        val[start] = 0;
        pq.offer(new int[]{start,0});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            if(val[cur[0]]<cur[1]) continue;
            int idx = cur[0];
            for(int i =0; i<node[idx].size(); i++){
                int[] next = node[idx].get(i);
                if(val[next[0]]> val[idx] + next[1]){
                    val[next[0]] = val[idx] + next[1];
                    pq.offer(new int[]{next[0], val[next[0]]});
                }
            }
        }
        return val[end];
    }
}