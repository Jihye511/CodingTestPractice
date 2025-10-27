import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static class Node{
        int w,v;
        public Node(int w,int v){
            this.w=w;
            this.v=v;
        }
    }
    static Node[] node;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        node = new Node[N];
        int[] value = new int[K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for (int w = K; w >= W; w--) {
                value[w] = Math.max(value[w], value[w - W] + V);
            }
        }
        System.out.println(value[K]);
    }
}
