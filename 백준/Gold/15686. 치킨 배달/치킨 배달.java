import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x= x;
        this.y= y;
    }
}

public class Main {
    static int N,M;
    static int[][] map;

    static ArrayList<Pair> list = new ArrayList<>();
    static ArrayList<Pair> house = new ArrayList<>();// 치킨집 m개 찾을때 사용
    static boolean[] checkChicken; // 치킨집 m개 찾을때 사용
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==2){
                    list.add(new Pair(i,j)); //현재 치킨집 좌표 저장
                }else if(map[i][j] ==1){
                    house.add(new Pair(i,j));
                }
            }
        }

        //치킨집 개수 M보다 작거나 같으면 바로 치킨 거리 최소값 구하기
        //M보다 크다면 치킨집 M개로 만들어준 다음 치킨 거리 최소값 구하기

            checkChicken = new boolean[list.size()];
            pickChicken(0,0);

        System.out.println(min);

    }
    public static void pickChicken(int start,int depth){
        if(depth == M){
            //치킨 거리 최솟값 구하기
            int total = 0;
            for(int i =0; i<house.size(); i++){
                int sum = Integer.MAX_VALUE; //현재 집에서 치킨집까지의 거리 최소
                for(int j =0; j<list.size(); j++){
                    if(checkChicken[j]){
                        int dist = Math.abs(house.get(i).x-list.get(j).x) + Math.abs(house.get(i).y - list.get(j).y);
                        sum = Math.min(sum,dist);
                    }
                }
                total +=sum;
            }
            min = Math.min(min,total); //M개 조합의 치킨 집 중 최소 거리 저장
        }
        for(int i =start; i<list.size(); i++){
            if(!checkChicken[i]){
                checkChicken[i] = true;
                pickChicken(i+1,depth+1);
                checkChicken[i] = false;
            }

        }
    }

}