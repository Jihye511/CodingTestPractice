import java.io.*;
import java.util.*;

public class Main {
   static int N,M,X;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] node = new ArrayList[N+1];
        ArrayList<int[]>[] reverseNode = new ArrayList[N+1];
        for(int i =0; i<N+1; i++){
            node[i] = new ArrayList<>();
            reverseNode[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            node[s].add(new int[]{e,t});
            reverseNode[e].add(new int[]{s,t});
        }
        //도착지에서 각 도시별 최단거리(공통)
        int[] toHome = shortestTime(reverseNode,X);
        int[] toParty = shortestTime(node, X);
        int time = 0;
        for(int i =1; i<N+1; i++){
            time = Math.max(time, toHome[i]+ toParty[i]);
        }

        System.out.println(time);

    }
    public static int[] shortestTime(ArrayList<int[]>[] node, int start){
        int[] route = new int[N+1];
        Arrays.fill(route, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        route[start] = 0;
        pq.offer(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int idx = cur[0];
            if(route[idx]<cur[1]) continue;
            for(int i =0; i<node[idx].size(); i++){
                int[] next = node[idx].get(i);
                if(route[next[0]]> route[idx]+next[1]){
                    route[next[0]] = route[idx]+next[1];
                    pq.offer(new int[]{next[0], route[next[0]]});
                }
            }
        }
        return route;
    }
}