import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i =0; i<N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new int[]{s, e});
        }
        Collections.sort(list, (a,b)->{
            if(a[1]==b[1]) return a[0]- b[0];
            else return a[1]-b[1];
        });
        int end =-1;
        int cnt =0;
        for(int i =0; i<list.size(); i++){
            int[] cur= list.get(i);
            if(end<=cur[0]){
                end = cur[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}