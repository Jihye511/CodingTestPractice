import java.awt.*;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main{
    static int T,N,K,W;
    static int[] times;
    static ArrayList<Integer>[] list;
    static int[] indegrees;
    static int[] totalTime;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=0; t <T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            totalTime = new int[N+1];
            times = new int[N+1];
            list = new ArrayList[N+1];
            indegrees = new int[N+1];
            for(int i =0; i<N+1; i++){
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i =1; i<=N;i++){
                times[i] = Integer.parseInt(st.nextToken());
            }

            for(int i =0; i<K; i++){
                st= new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());

                list[pre].add(num);
                indegrees[num] ++;
            }
            W = Integer.parseInt(br.readLine());
            acm(W);
        }
    }
    public static void acm(int end){
        Queue<Integer> q= new LinkedList<>();
        for(int j =1; j<=N; j++){
            if(indegrees[j] ==0){
                totalTime[j] = times[j];
                q.offer(j);
            }
        }
        while(!q.isEmpty()) {
            //현재 건물 짓는 시간 totaltime에 더하기
            int current = q.poll();
            for(int i =0; i<list[current].size(); i++){
                int next = list[current].get(i);
                totalTime[next] = Math.max(totalTime[current] + times[next], totalTime[next]);
                indegrees[next]--;
                if(indegrees[next]==0) q.offer(next);
            }
        }

        System.out.println(totalTime[end]);
    }
}