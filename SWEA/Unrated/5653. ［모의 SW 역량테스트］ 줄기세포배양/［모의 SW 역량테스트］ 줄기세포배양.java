import java.io.*;
import java.util.*;

public class Solution {
    static class Cell {
        int x, y;
        int life;
        int activeTime;
        boolean isActive;
        boolean isDead;
        int createdTime;

        public Cell(int x, int y, int life, int createdTime) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.activeTime = life;
            this.isActive = false;
            this.isDead = false;
            this.createdTime = createdTime;
        }
    }

    static int N, M, K;
    static HashMap<String, Cell> cellMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cellMap = new HashMap<>();
            int offset = K + 10;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int life = Integer.parseInt(st.nextToken());
                    if (life > 0) {
                        int x = i + offset;
                        int y = j + offset;
                        cellMap.put(x + "," + y, new Cell(x, y, life, 0));
                    }
                }
            }

            for (int time = 1; time <= K; time++) {
                simulate(time);
            }

            int alive = 0;
            for (Cell cell : cellMap.values()) {
                if (!cell.isDead) alive++;
            }

            System.out.println("#" + tc + " " + alive);
        }
    }

    private static void simulate(int time) {
        List<Cell> toSpread = new ArrayList<>();
        Map<String, Integer> newCells = new HashMap<>();

        for (Cell cell : cellMap.values()) {
            if (cell.isDead) continue;

            if (!cell.isActive) {
                if (time == cell.createdTime + cell.life) {
                    cell.isActive = true;
                }
            } else {
                if (time == cell.createdTime + cell.life + 1) {
                    toSpread.add(cell);
                }

                cell.activeTime--;
                if (cell.activeTime == 0) {
                    cell.isDead = true;
                }
            }
        }

        Collections.sort(toSpread, (a, b) -> b.life - a.life);

        for (Cell cell : toSpread) {
            for (int d = 0; d < 4; d++) {
                int nx = cell.x + dx[d];
                int ny = cell.y + dy[d];
                String key = nx + "," + ny;

                if (cellMap.containsKey(key)) continue;

                if (!newCells.containsKey(key) || newCells.get(key) < cell.life) {
                    newCells.put(key, cell.life);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : newCells.entrySet()) {
            String[] pos = entry.getKey().split(",");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            cellMap.put(entry.getKey(), new Cell(x, y, entry.getValue(), time));
        }
    }
}
