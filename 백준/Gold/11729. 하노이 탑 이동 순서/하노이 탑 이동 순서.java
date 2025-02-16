import java.io.*;
import java.util.*;

public class Main {
//    static Queue<Integer> q1 = new LinkedList<>();
//    static Queue<Integer> q2 = new LinkedList<>();
//    static Queue<Integer> q3 = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //재귀
        dfs(N,1,2,3);
        System.out.println(cnt);
        System.out.println(sb);
    }
    public static void dfs(int N, int start, int mid, int end){ //현재 옮기는 넘버
        if(N == 1){
            cnt++;
            sb.append(start+" " +end).append("\n");
            return;
        }

        // A -> C로 옮긴다고 가정할 떄,
        // STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.) //1 -> 2
        dfs(N-1, start,end,mid);

        // STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
        sb.append(start +" " + end).append("\n");
        cnt++;

        // STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
        dfs(N-1, mid,start,end);
    }
}