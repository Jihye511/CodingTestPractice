import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] parents;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for(int i =0; i<=n; i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        parents = new int[n+1];
        visit = new boolean[n+1];

        bfs(1);
        for(int i =2; i<=n; i++){
            System.out.println(parents[i]);
        }
    }
    public static void bfs(int node){
        visit[node] = true;
        //인접 노드 조회
        for(int n : edges.get(node)){
            if(!visit[n]){
                //인접 노드의 부모를 현재 노드로 설정
                parents[n] = node;
                //인접 노드를 현재 노드로
                bfs(n);
            }
        }
    }

}