import java.io.*;
import java.util.*;
public class Main{
    static int T, N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            LinkedList<int[]> q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int val = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i, val});
            }

            int count = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll(); //첫 원소
                boolean isMax = true; //현재 원소가 가장 큰 원소인지 판단하는 변수
                for (int i = 0; i < q.size(); i++) {
                    if (now[1] < q.get(i)[1]) {
                        q.offer(now);
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;

                    }
                }
                if (!isMax) {
                    continue;
                }
                count++;
                if (now[0] == M) {
                    break;
                }

            }
            sb.append(count).append("\n");


        }
        System.out.println(sb);
    }

}