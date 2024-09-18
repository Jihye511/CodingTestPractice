import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            for (int j = 1; j < g; j++) {
                int num = Integer.parseInt(st.nextToken());
                list[pre].add(num);
                indegree[num]++;

                pre = num;
            }
        }
        topologicalSort();
        //topologicalSort를 돌렸는데도 indegree가 0이 아닌게 있다면 출력 불가능임
        boolean flag = false;
        for(int i=1; i<N+1; i++) {
            if(indegree[i] !=0) {
                flag=true;
                break;
            }
        }
        if(flag) System.out.println(0);

        System.out.println(sb);
    }

    public static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<N+1; i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append("\n");
            for(int next : list[current]){
                indegree[next] --;
                if(indegree[next] ==0) {
                    q.add(next);
                }
            }
        }
    }
}