import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;

public class Main {
    public static class Road{
        int start;
        int end;
        int shortLoad;
        public Road(int start, int end, int shortLoad){
            this.start = start;
            this.end = end;
            this.shortLoad = shortLoad;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] distance = new int[D+1]; // 도착위치까지 온 거리
        for(int i =0; i<D+1; i++){
            distance[i] = i;
        }
        ArrayList<Road> list = new ArrayList<>();
        for(int i =0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortLoad = Integer.parseInt(st.nextToken());
            list.add(new Road(start, end, shortLoad));
        }
        Collections.sort(list, (a,b)->{
            if(a.start==b.start && a.end == b.end) return a.shortLoad - b.shortLoad;
            return a.start - b.start;
        });

        for(int i =1;i<=D;i++){

                distance[i] = Math.min(distance[i], distance[i-1]+1);

                // 지금 도착지점까지 저장되어 있는 거리와 해당 지름길을 통한 거리 비교 후 짧은 거 저장
                for(int j =0; j<N; j++){
                    if(list.get(j).end == i){
                        distance[i] = Math.min(distance[i], distance[list.get(j).start]+list.get(j).shortLoad);
                    }
                }

        }
        System.out.println(distance[D]);

    }
}