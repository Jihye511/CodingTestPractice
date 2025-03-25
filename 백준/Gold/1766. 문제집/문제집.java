import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] list;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N+1];
        list = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<M; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            list[a].add(b);
            num[b]++;

        }
        bfs();
        System.out.println(sb);

    }
    public static void bfs(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i =1; i<=N; i++){
            if(num[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int i =0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                num[next]--;
                if(num[next] ==0){
                    q.offer(next);
                }
            }
        }
    }
}