import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j});  // 익은 토마토의 좌표를 큐에 넣기
                }
            }
        }

        int result = bfs();  // BFS로 최소 날짜 계산

        // 모두 익었는지 확인
        if (!checkAll()) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static int bfs() {
        int days = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int cx = current[0];
                int cy = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = 1;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            days++;
        }
        return days - 1; // 마지막날을 빼줘야 정확한 날짜 계산
    }

    public static boolean checkAll() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {  // 안익은 토마토가 있다면
                    return false;
                }
            }
        }
        return true;
    }
}