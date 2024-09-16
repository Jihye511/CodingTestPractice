import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static ArrayList<Integer>[] list;
    static int[] time;
    static int[] indegree;
    static int[] cost;
    static int totalTime;
    static Queue<Integer> order =  new LinkedList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        indegree = new int[N+1];
        time = new int[N+1];
        for(int i =0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            indegree[i] = Integer.parseInt(st.nextToken()); //선행 작업 수
            for(int j =0; j<indegree[i]; j++){
                int pre = Integer.parseInt(st.nextToken());
                list[pre].add(i);
            }
        }
        int result =0;
        cost = new int[N+1];
        topologySort();
        for(int i =1; i<=N; i++){
            result = Math.max(result,cost[i]);
        }
        System.out.println(result);
    }
    public static void topologySort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i =1; i<=N; i++){
            if(indegree[i] ==0){
                q.offer(i);
                cost[i] = time[i];
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();

            for(int i =0; i<list[current].size(); i++){
                int next = list[current].get(i);
                cost[next] = Math.max(cost[current] + time[next], cost[next]);
                indegree[next] --;
                if(indegree[next]==0) q.offer(next);
            }
        }
    }
}