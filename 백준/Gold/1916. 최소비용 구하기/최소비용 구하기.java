import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<int[]>[] node;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        node= new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            node[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node[s].add(new int[]{e,w});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] val = new int[N+1];
        Arrays.fill(val, Integer.MAX_VALUE);
        pq.offer(new int[]{start, 0});
        val[start] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int idx = cur[0];
            if(val[idx]<cur[1]) continue;
            for(int i =0; i<node[idx].size(); i++){
                int[] next = node[idx].get(i);

                if(val[next[0]]>val[idx]+next[1]){
                    val[next[0]] = val[idx]+next[1];
                    pq.offer(new int[]{next[0],val[next[0]]});
                }
            }
        }
        System.out.println(val[end]);
    }

}