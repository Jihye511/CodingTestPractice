import java.io.*;
import java.util.*;
class Cctv implements Comparable<Cctv>{
    int x,y,num;
    public Cctv(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Cctv o) { //내림차순 정렬
        return o.num - this.num;
    }
}
public class Main {
    static int N,M;
    static int[][] map;
    static int minValue = Integer.MAX_VALUE;
    static ArrayList<Cctv> cctvs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j]<6) cctvs.add(new Cctv(i,j,map[i][j]));
            }
        }
        Collections.sort(cctvs,Collections.reverseOrder());
        simulation(0,copymMap(map));

        System.out.println(minValue);

    }
    public static int[][] copymMap(int[][] original) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = original[i].clone();
        }
        return newMap;
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void simulation(int idx,int[][] tempMap){
        if(idx == cctvs.size()){
            //사각지대 개수 세기
            int hap = countArea(tempMap);
            minValue = Math.min(minValue, hap);
            return;
        }

        Cctv cur=cctvs.get(idx);
        int[][] backupMap;

        switch (cur.num){
            case  1 :
                for(int d =0; d<4; d++){
                    backupMap = copymMap(tempMap);
                    observe(backupMap, cur.x, cur.y, d);
                    simulation(idx+1, backupMap);
                }
                break;
            case 2:
                for(int[] dir : new int[][]{{0,1} , {2,3}}){
                    backupMap = copymMap(tempMap);
                    for(int d : dir) {
                        observe(backupMap, cur.x, cur.y, d);
                    }
                    simulation(idx+1, backupMap);
                }
                break;
            case 3:
                for(int[] dir : new int[][]{{0,2} , {0,3},{1,3},{1,2}}){
                    backupMap = copymMap(tempMap);
                    for(int d : dir) {
                        observe(backupMap, cur.x, cur.y, d);
                    }
                    simulation(idx+1, backupMap);
                }
                break;
            case 4:
                for(int[] dir : new int[][]{{0,1,2} , {0,1,3}, {0,2,3},{1,2,3}}){
                    backupMap = copymMap(tempMap);
                    for(int d : dir) {
                        observe(backupMap, cur.x, cur.y, d);
                    }
                    simulation(idx+1, backupMap);
                }
                break;
            case 5:
                    backupMap = copymMap(tempMap);
                    for(int d =0; d<4; d++) {
                        observe(backupMap, cur.x, cur.y, d);
                    }
                    simulation(idx+1, backupMap);
                    break;

        }

    }
    public static void observe(int[][] tempMap, int x, int y, int dir ){
        int nx = x;
        int ny =y;

        while(true){
            nx += dx[dir];
            ny += dy[dir];
            if(nx<0 || nx>=N || ny<0 || ny>=M || tempMap[nx][ny]==6) break;
            if(tempMap[nx][ny] ==0 ) tempMap[nx][ny] =-1;
        }
    }

    public static int countArea(int[][] tempMap){
        int cnt =0;
        for(int i =0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
