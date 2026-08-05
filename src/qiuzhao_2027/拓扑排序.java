package qiuzhao_2027;

import java.util.*;

public class 拓扑排序 {

    /**
     * 拓扑排序核心函数
     *
     * @param n     点的数量，编号为 1 ~ n
     * @param edges 邻接表，edges.get(u) 表示 u 指向的所有点
     * @param indeg 入度数组，indeg[i] 表示点 i 的入度
     * @return 拓扑序列；如果有环，则返回空列表
     */
    public static List<Integer> res=new ArrayList<>();

    public static void solve(List<List<Integer>> edges,int[] indeg,int n){
        Queue<Integer> q=new LinkedList<>();//如果需要字典序最小的拓扑序的话 用小根堆PriorityQueue即可
        // 先把所有入度为 0 的点加入队列
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int t=q.poll();//将头节点拿出来
            res.add(t);
            //枚举头节点的所有边 并出边元素的入度-- 然后判断是否为0 为0加入队列
            for(int to:edges.get(t)){
                indeg[to]--;
                if(indeg[to]==0){
                    q.offer(to);
                }
            }
        }
        if (res.size() == n) {
            for (int x : res) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        //构建邻接表
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges.get(x).add(y);
            indeg[y]++;
        }
        solve(edges, indeg, n);
    }
}