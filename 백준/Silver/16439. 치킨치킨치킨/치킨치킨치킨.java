import java.util.*;
import java.io.*;

public class Main {
    static int N, M, max = 0;
    static int[][] member;
    static boolean[] check;

    public static void dfs(int depth, int start) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int num = 0;
                for (int j = 0; j < M; j++) {
                    if (check[j]) {
                        num = Math.max(num, member[i][j]);
                    }
                }
                sum += num;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i < M; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(depth + 1, start + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        member = new int[N][M];
        check = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                member[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);

    }
}