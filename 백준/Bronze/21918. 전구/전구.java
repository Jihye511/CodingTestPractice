import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //N 전구, M 명령어 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr =new int[N+1];

        //전구 배열에 넣는 for문
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //명령 실행 for문
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            switch (a){
                case 1:
                    arr[b]=c;
                    break;
                case 2:
                    for(int j=b; j<=c; j++){
                        if(arr[j]==0){
                            arr[j]=1;
                        }else arr[j]=0;
                    }
                    break;
                case 3:
                    for (int j=b; j<=c; j++){
                        arr[j]=0;
                    }
                    break;
                case 4:
                    for (int j=b; j<=c; j++){
                        arr[j]=1;
                    }
                    break;
            }
        }
        for(int i =1; i<=N; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);

    }


}