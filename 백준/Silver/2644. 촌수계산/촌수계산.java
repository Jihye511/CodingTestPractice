import java.util.*;
import java.io.*;

public class Main {
    static int n,start,end,m,count;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n =Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        count=0;
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(start, 0);
        if(count ==0){
            System.out.println("-1");
        }else {
            System.out.println(count);
        }

    }
    public static void dfs( int point, int cnt){
        visited[point] = true;
        for(int x : graph.get(point)){
            if(!visited[x]){
                if(x==end){
                    count = cnt+1;
                    return;
                }
                dfs(x, cnt+1);
            }
        }


    }
}
