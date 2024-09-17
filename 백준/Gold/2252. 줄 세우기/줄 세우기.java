import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static ArrayList<Integer>[] list;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        indegree = new int[N+1];
        for(int i =0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            list[pre].add(num);
            indegree[num]++;
        }
        line();
    }

    public static void line() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(" "); //현재값 sb에 저장
            for(int j = 0; j<list[current].size(); j++){
                int next = list[current].get(j);
                indegree[next] --;
                if(indegree[next] ==0){
                    q.offer(next);
                }

            }
        }
        System.out.println(sb);
    }
}