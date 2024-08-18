import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int com;
    static int connect;
    static int[][] arr;
    static boolean[] visit;
    static int count =0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        com = Integer.parseInt(br.readLine());
        connect = Integer.parseInt(br.readLine());
        arr = new int[com +1][com+1];
        visit = new boolean[com+1];

        //연결노드 설정
        for(int i =0; i<connect; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);

        System.out.println(count-1);
    }
    public static void dfs(int start){
        visit[start] =true;
        count ++;

        for(int i =0; i<=com; i++){
            if(arr[start][i] == 1 && !visit[i])
                dfs(i);
        }
    }
}