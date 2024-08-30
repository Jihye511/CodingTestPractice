import java.util.*;
import java.io.*;

public class Main{
    static int n,k;
    static int[] card;
    static HashSet<String> map = new HashSet<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }
        dfs("",0);
        System.out.println(map.size());
    }
    static void dfs(String s, int d){
        if(d==k){
            map.add(s);
            return;
        }

        for(int i =0; i<n; i++){
            if(!visited[i]){
                visited[i] =true;
                dfs(s+card[i],d+1);
                visited[i]=false;
            }
        }
    }
}