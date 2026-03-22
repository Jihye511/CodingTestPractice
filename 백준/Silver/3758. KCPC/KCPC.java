import javax.imageio.ImageTranscoder;
import java.io.*;
import java.text.CollationElementIterator;
import java.util.*;

public class Main {
    static class Team implements Comparable<Team>{
        int id;
        int sum; // 점수 합
        int cnt; // 총 제출 횟수
        int lastTime; //마지막 제출 인덱스 번호
        public Team(int id, int sum, int cnt, int lastTime){
            this.id = id;
            this.sum =sum;
            this.cnt =cnt;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(Team o) {
            if (this.sum != o.sum) return o.sum - this.sum;
            if (this.cnt != o.cnt) return this.cnt - o.cnt;
            return this.lastTime - o.lastTime;
        }
    }
   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       for(int t=0; t<T; t++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int n= Integer.parseInt(st.nextToken()); // 팀의 개수
           int k=Integer.parseInt(st.nextToken()); //문제의 개수
           int id = Integer.parseInt(st.nextToken()); // 팀 id
           int m = Integer.parseInt(st.nextToken()); //로그 엔트리 개수
           Team[] teams = new Team[n+1];
           int[][] score = new int[n + 1][k + 1];
           for(int i =1; i<=n; i++){
               teams[i]= new Team(i,0,0,-1);
           }

           for(int e =0; e<m; e++){
               st = new StringTokenizer(br.readLine());
               int idx = Integer.parseInt(st.nextToken());
               int j = Integer.parseInt(st.nextToken());
               int s = Integer.parseInt(st.nextToken());
               teams[idx].cnt++;
               teams[idx].lastTime = e;
               score[idx][j] = Math.max(score[idx][j], s);
           }
           //팀 총합 저장
           for(int i=1; i<=n; i++){
               int hap =0;
               for(int j =1; j<=k; j++){
                   hap +=score[i][j];
               }
               teams[i].sum =hap;
           }
           Arrays.sort(teams,1, n+1);
           int r=1;
           for (int i = 1; i <= n; i++) {
               if (teams[i].id == id) {
                   sb.append(i).append("\n");
                   break;
               }
           }

       }
       System.out.println(sb);
   }

}