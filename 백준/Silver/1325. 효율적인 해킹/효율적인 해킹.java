
import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static List<Integer>[] list;
    static int[] cnt;
    public static void bfs(int start){
        boolean[] visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int item : list[cur]){
                if(!visit[item]){
                    cnt[item] ++;
                    visit[item] =true;
                    queue.add(item);

                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //첫째 줄 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];

        for(int i = 0; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }
        cnt = new int[n+1];

        for(int i =1; i<=n; i++){
            bfs(i);
        }

        //최대값 출력
        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        for(int i =1; i<=n; i++){
            if(cnt[i] > max){
                max = cnt[i];
                ans.clear();
                ans.add(i);
            }
            else if(cnt[i] == max){
                ans.add(i);
            }
        }
        for(int a:ans){
            System.out.print(a +" ");
        }

    }
}
