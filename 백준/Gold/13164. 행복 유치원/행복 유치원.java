import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        students = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        // 키 차이 계산
        int[] key = new int[N - 1];
        for (int i = 1; i < N; i++) {
            key[i - 1] = students[i] - students[i - 1];
        }

        // 키 차이 정렬
        Arrays.sort(key);

        // 최소 비용 계산: 가장 큰 K-1개의 차이를 제외한 나머지 합산
        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += key[i];
        }

        System.out.println(sum);
    }
}
