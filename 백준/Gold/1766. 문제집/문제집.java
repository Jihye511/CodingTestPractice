import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static ArrayList<Integer>[] list;
    static int[] indegree;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        list = new ArrayList[N+1];
        result = new int[N+1];
        for(int i =1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        //입력받기
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            list[pre].add(num);
            indegree[num]++;
        }
        topologicalSort();
        System.out.println(sb);
    }
    public static void topologicalSort(){
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<N+1; i++){
            if(indegree[i] ==0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(" ");
            for(int next : list[current]){
                indegree[next] --;
                if(indegree[next] ==0) {
                    q.add(next);

                }
            }
        }
    }
}