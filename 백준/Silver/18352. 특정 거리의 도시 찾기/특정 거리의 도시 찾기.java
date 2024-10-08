import java.util.*;
import java.lang.Comparable;
import java.io.*;
public class Main {
    static int N,M,K,X;
    static int[] distance;
    static ArrayList<Integer>[] map;
    static StringBuilder sb= new StringBuilder();
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance= new int[N+1];
        Arrays.fill(distance,300000);
        map = new ArrayList[N+1];
        for(int i =0; i<N+1; i++){
            map[i] = new ArrayList<>();
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start].add(end);
        }
        distance[X] =0;
        bfs(X);
        if(answer.isEmpty()){
            System.out.println(-1);
            return;
        }
        Collections.sort(answer);
        for(int ans : answer){

            System.out.println(ans);
        }
    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int node = q.poll();
            if(distance[node]>K) break;
            if(distance[node] == K) answer.add(node);
            for(int i =0; i<map[node].size(); i++){
                int next = map[node].get(i);
                if(distance[next] != 300000) continue;
                distance[next] = distance[node]+1;
                q.offer(next);
            }
        }
    }
}