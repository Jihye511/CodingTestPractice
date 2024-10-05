import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[] arr;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        num = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);


        dfs(0,0);
        System.out.println(sb);
    }

    public static void dfs(int start,int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                if (before != num[i]) {
                    before = num[i];
                    visited[i] = true;
                    arr[depth] = num[i];
                    dfs(i+1,depth + 1);
                    visited[i] = false;
                }


            }
        }
    }
}

