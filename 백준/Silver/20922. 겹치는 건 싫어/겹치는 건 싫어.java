import javax.imageio.ImageTranscoder;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int num[] = new int[N];
        for(int i =0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int start =0;
        int end =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(num[start], map.getOrDefault(num[start],0)+1);
        int ans= 0;
        while(end<N-1){
            end ++;
            map.put(num[end], map.getOrDefault(num[end],0)+1);
            if(map.get(num[end])>K) {
                //K보다 작거나 같아질때까지 start 이동
                while(start<end){
                    map.put(num[start], map.getOrDefault(num[start], 0)-1);
                    start++;
                    if(map.get(num[end])==K) break;
                }
            }
            ans = Math.max(end - start +1, ans);
        }

        System.out.println(ans);
    }
}