package qiuzhao_2027;

import java.util.*;

public class 迷宫最短路 {

    // n 表示行数，m 表示列数
    static int n, m;

    // g 表示迷宫地图：0 表示可以走，1 表示不能走
    static int[][] g;

    // sx, sy 表示起点坐标；ex, ey 表示终点坐标
    static int sx, sy, ex, ey;

    // dist[x][y] 表示从起点走到 (x, y) 的最短步数
    // 初始值为 -1，表示该点还没有被访问过
    static int[][] dist;

    // preX[x][y], preY[x][y] 表示走到 (x, y) 之前所在的上一个点坐标
    // 用来在 BFS 结束后还原完整路径
    static int[][] preX, preY;

    // 四个方向：上、右、下、左
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    /**
     * 核心 BFS 函数
     *
     * @param x 起点行坐标
     * @param y 起点列坐标
     * @return 起点到终点的最短步数；如果无法到达，返回 -1
     */
    public static int bfs(int x, int y) {

        if (x == ex && y == ey) return 0;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            int[] t = q.poll();

            for (int i = 0; i < 4; i++) {
                int[] cur = new int[2];
                cur[0] = t[0] + dx[i];
                cur[1] = t[1] + dy[i];

                if (cur[0] < 0 || cur[0] >= n || cur[1] < 0 || cur[1] >= m) continue;
                if (g[cur[0]][cur[1]] == 1) continue;
                if (dist[cur[0]][cur[1]] != -1) continue;

                dist[cur[0]][cur[1]] = dist[t[0]][t[1]] + 1;

                preX[cur[0]][cur[1]] = t[0];
                preY[cur[0]][cur[1]] = t[1];

                if (cur[0] == ex && cur[1] == ey) {
                    return dist[cur[0]][cur[1]];
                }

                q.offer(cur);
            }
        }

        return -1;
    }

    /**
     * 根据 preX 和 preY 数组，从终点反向找到起点，然后打印完整路径
     */
    public static void printPath() {
        List<int[]> path = new ArrayList<>();

        // 从终点开始往前找
        int x = ex;
        int y = ey;

        // 一直找到起点为止
        while (!(x == sx && y == sy)) {
            path.add(new int[]{x, y});

            // 找到当前点的上一个点
            int px = preX[x][y];
            int py = preY[x][y];

            x = px;
            y = py;
        }

        // 加入起点
        path.add(new int[]{sx, sy});

        // 因为刚才是从终点往起点找，所以需要反转
        Collections.reverse(path);

        // 按顺序打印路径上的每一个点
        for (int[] p : path) {
            System.out.println(p[0] + " " + p[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入迷宫的行数和列数
        n = sc.nextInt();
        m = sc.nextInt();

        g = new int[n][m];
        dist = new int[n][m];
        preX = new int[n][m];
        preY = new int[n][m];

        // 初始化 dist 和 pre 数组
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
            Arrays.fill(preX[i], -1);
            Arrays.fill(preY[i], -1);
        }

        // 输入迷宫地图
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        // 输入起点坐标和终点坐标
        sx = sc.nextInt();
        sy = sc.nextInt();
        ex = sc.nextInt();
        ey = sc.nextInt();

        // 从起点开始 BFS
        int ans = bfs(sx, sy);

        // 先输出最短步数
        System.out.println(ans);

        // 如果可以到达终点，再输出完整路径
        if (ans != -1) {
            printPath();
        }
    }
}