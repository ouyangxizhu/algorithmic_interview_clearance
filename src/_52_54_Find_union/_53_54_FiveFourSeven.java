package _52_54_Find_union;

import util.Union_Find_Set;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class _53_54_FiveFourSeven {
    /**
     * 深度优先搜索
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        //使用深度优先搜索，类似岛屿个数的题目
        int length = M.length;
        // 二维数组长度，即所有人的个数
        int count = 0;
        // 统计朋友圈个数
        boolean[] flag = new boolean[length];
        // 访问标志
        for (int i = 0; i < length; i++) {
            // 对于每个人
            if(flag[i] == false){
                // 如果未被访问
                DFS(i, M, flag);// 深度优先搜索，访问
                count++;// 朋友圈个数+1
            }
        }
        return count;
    }
    public void DFS(int i,int[][] M,boolean[] flag){
        flag[i] = true;

        for(int j = 0;j < M[i].length;j++){
            if(flag[j] == false && M[i][j] == 1){
                DFS(j,M,flag);
            }
        }
    }

    /**
     * 并查集
     */
    public int findCircleNum1(int[][] M) {
        int N = M.length;
        Union_Find_Set set = new Union_Find_Set(N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(M[i][j] == 1 && !set.isInSameSet(i,j)){
                    set.union(i, j);
                }
            }
        }
        return set.NumOfSet();
    }


}
