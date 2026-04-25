import java.io.*;
import java.util.*;

public class Main {
    static int V,E;
    static ArrayList<int[]>[] node;
    static int start;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        node= new ArrayList[V+1];
        for(int i =0; i<V+1; i++){
            node[i] = new ArrayList<>();
        }
        start = Integer.parseInt(br.readLine());
        for(int i =0; i<E; i++){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node[s].add(new int[]{e,w});
        }
        int[] value = new int[V+1];
        Arrays.fill(value,Integer.MAX_VALUE);
        value[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] -b[1]);
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()){
            int[] cur= pq.poll();
            int idx = cur[0];
            for(int i =0; i<node[idx].size(); i++){
                int[] next = node[idx].get(i);
                if(value[next[0]] > value[idx]+next[1]){
                    value[next[0]] = value[idx]+next[1];
                    pq.offer(new int[]{next[0], value[next[0]]});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<V+1; i++){
            if( value[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else  sb.append(value[i]).append("\n");
        }
        System.out.println(sb);
    }

}