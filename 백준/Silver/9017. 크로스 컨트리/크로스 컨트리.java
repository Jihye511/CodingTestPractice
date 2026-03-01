import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st =new StringTokenizer(br.readLine());
            int[] team = new int[N+1];
            HashMap<Integer, Integer>map = new HashMap<>();
            for(int i =1; i<=N; i++){
                int n = Integer.parseInt(st.nextToken());
                team[i] = n;
                map.put(n, map.getOrDefault(n,0)+1);
            }
            ArrayList<Integer> list= new ArrayList<>();
            for(int key: map.keySet()) {
                int count = map.get(key);
                if(count==6) list.add(key);
            }
            int[] total = new int[201];
            Arrays.fill(total,0);
            int[] score  = new int[201]; // 점수
            int[] cnt = new int[201]; //팀별 인원 카운트
            //점수 부여
            int curS=1;
            for(int i =1; i<=N; i++){
                int cur = team[i];
                if(!list.contains(cur)) continue;

                cnt[cur]++;
                if(cnt[cur]<=4){
                    total[cur] +=curS;
                }
                if(cnt[cur] ==5){
                    score[cur] = curS;
                }
                curS++;
            }
            int min = Integer.MAX_VALUE;
            for(int i : list){
                min = Math.min(min, total[i]);
            }

            //1등팀 확인
            ArrayList<Integer> first = new ArrayList<>();
            for(int i : list){
                if(total[i] == min){
                    first.add(i);
                }
            }
            if(first.size()==1){
                System.out.println(first.get(0));
            }else{
                //1등팀이 여러개
                int minTeam =0;
                int minValue =Integer.MAX_VALUE;
                for(int i : first){
                    if(minValue > score[i]){
                        minValue = score[i];
                        minTeam = i;
                    }
                }
                System.out.println(minTeam);
            }
        }
    }

}