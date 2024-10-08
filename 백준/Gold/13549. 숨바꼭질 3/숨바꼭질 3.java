import java.io.*;
import java.util.*;
class Node{
    int node,time;
    public Node(int node, int time){
        this.node = node;
        this.time = time;
    }
}
public class Main {
    static int K,C;
    static int time = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs(K);
        System.out.println(time);
    }
    public static void bfs(int start){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start,0));
        visited[start]=true;
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.node ==C){
                time = Math.min(time, n.time);
            }
            if(n.node*2 <100001 && !visited[n.node*2]){
                visited[n.node*2]=true;
                q.offer(new Node(n.node*2,n.time));
            }
            if(n.node-1 >=0&& !visited[n.node-1]){
                visited[n.node-1] = true;
                q.offer(new Node(n.node-1,n.time+1));
            }
            if(n.node+1 <100001&& !visited[n.node+1]){
                visited[n.node+1] = true;
                q.offer(new Node(n.node+1,n.time+1));
            }
        }
    }
}