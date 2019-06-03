package util;

/**
 * 并查集
 */
public class QuickUnionUF {
    private int[] roots;
    // 初始化，自己的老大就是自己
    public QuickUnionUF(int N){
        roots = new int[N];
        for (int i = 0; i < N; i++){
            roots[i] = i;
        }
    }

    private int findRoot(int i){
        int root = i;
        while (root != roots[root])
            root = roots[root];
        //路径压缩
        while (i != roots[i]){
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    public boolean connected(int p, int q){
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q){
        int qroot = findRoot(q);
        int proot = findRoot(p);
        roots[proot] = qroot;
    }
}
