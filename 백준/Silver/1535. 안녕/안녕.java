import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static ArrayList<Integer> arr;
    static int[] tired;
    static int[] happy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        tired = new int[n];
        happy = new int[n];
        for(int i=0;i<n;i++){
            tired[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            happy[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,100,0);
        Collections.sort(arr);
        System.out.println(arr.get(arr.size()-1));

    }
    public static void dfs(int idx, int life, int fun){
        if(life<=0) return;
        arr.add(fun);
        if(idx==n) return;

        dfs(idx+1, life - tired[idx], fun + happy[idx]);
        dfs(idx +1, life, fun);
    }
}
