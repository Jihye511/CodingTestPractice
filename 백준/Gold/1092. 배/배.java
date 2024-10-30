import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static Integer[]  crane;
    static Integer[] box;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        crane = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            crane[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        box = new Integer[M];
        for(int i =0; i<M;i++){
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane, (a,b)-> b - a);
        Arrays.sort(box, Comparator.reverseOrder());
        if(crane[0] <box[0]) {
            System.out.println(-1);
            return;
        }


        int time=0;
        List<Integer> boxList = new ArrayList<>(Arrays.asList(box)); // 박스를 리스트로 변환


        while(!boxList.isEmpty()){
            int boxIndex = 0;
            for(int i =0; i<N; i++){
                if(boxIndex >= boxList.size()) break; //박스를 다 옮긴 경우 중단
                if(crane[i] >= boxList.get(boxIndex)){// 크레인이 들 수 있는 무게인 경우
                    boxList.remove(boxIndex);
                }else{
                    boxIndex++;
                    i--;
                }
            }
            time++;

        }
        System.out.println(time);
    }
}
