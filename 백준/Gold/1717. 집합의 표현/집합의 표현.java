import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;
    public static int find(int x){
        if(x == parent[x]) return x;

        return parent[x] =find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(x<y) parent[y] =x;
        else parent[x] =y;
    }
    public static boolean isUnion(int x, int y){
        x = find(x);
        y = find(y);
        return (x==y);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(int i =0; i<m; i++){
            st =new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());

            if(num ==0){
                union(a,b);
            }else if(num == 1){
                if(isUnion(a,b)){
                    sb.append("YES").append('\n');

                }else{
                    sb.append("NO").append('\n');
                }
            }
        }
        System.out.println(sb);
    }


}