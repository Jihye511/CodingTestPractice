import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] arr;
    static int[] value;
    static HashSet<Integer> hash = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        value = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int depth){
        if(depth==m){
            for(int s : arr){
                sb.append(s).append(" ");
            }
            sb.append('\n');
            return;
        }
        int before=0;
        for(int i =0; i<n; i++){
            if(before !=value[i]){
                arr[depth] = value[i];
                before= value[i];
                dfs(depth+1);
            }
        }
    }
}