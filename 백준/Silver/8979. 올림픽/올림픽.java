import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static class Medal{
        int n;
        int g;
        int s;
        int d;
        public Medal(int n,int g, int s, int d){
            this.n =n;
            this.g=g;
            this.s = s;
            this.d = d;
        }
    }
    static Medal[] medal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        medal = new Medal[N];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            medal[i] = new Medal(n,g,s,d);
        }
        Arrays.sort(medal,(a,b)->{
            if (a.g != b.g) return b.g-a.g;
            if(a.s != b.s) return b.s - a.s;
            return b.d -a.d;
        });

        int rank = 1;
        int ans = 0;
        for(int i =0; i<N; i++){
            if(i>0){
                if(medal[i].g != medal[i-1].g || medal[i].s != medal[i-1].s || medal[i].d != medal[i-1].d) {
                    rank = i + 1;
                }
            }
            if(medal[i].n == K){
                ans = rank;
                break;
            }
        }
        System.out.println(ans);
    }

}