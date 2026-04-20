import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] dish = new int[N];
        for(int i =0; i<N; i++){
            dish[i] = Integer.parseInt(br.readLine());
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //0부터 k-1까지에서 먹은 종류 & 개수
        for(int i =0; i<k; i++){
            map.put(dish[i], map.getOrDefault(dish[i], 0)+1);
        }
        int max = map.size();
        if(!map.containsKey(c)) max++;

        //슬라이딩 윈도우
        int end =k;
        int start = 0;
        while(true){
            if(end == k-1) break;

            map.put(dish[end], map.getOrDefault(dish[end],0)+1);
            map.put(dish[start], map.getOrDefault(dish[start],0)-1);
            if(map.get(dish[start])==0) map.remove(dish[start]);
            int temp = map.size();
            if(!map.containsKey(c)) temp++;
            max = Math.max(max, temp);
            end = (end+1)%N;
            start = (start+1)%N;

        }
        System.out.println(max);
    }
}