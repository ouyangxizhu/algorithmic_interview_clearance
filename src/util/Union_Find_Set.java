package util;

import java.util.ArrayList;

public class Union_Find_Set {
    ArrayList<Integer> father = new ArrayList<>();
    int SIZE = 0;
    public Union_Find_Set(int size){
        this.SIZE = size;
        for(int i = 0; i < size; i++){
            father.add(i);
        }
    }

    public int find(int x) {
        // 递归版本
        if (x == father.get(x)) {
            return father.get(x);
        }
        // 递归寻找父节点
        int ans = find(father.get(x));
        // 找到结点之后，顺手把路径压缩一下，把根·父节点更新为这条链上所有结点的父节点，
        //免得后面还要这样递归来查
        father.set(x, ans);
        return ans;
    }

    // 非递归版本用的比较少，所以设置为private
    private int Find(int x){
        // 非递归版本
        while (father.get(x) != x){
            // 如果当前结点的父节点不是自己的话，就去查询他的父节点
            x = father.get(x);
        }
        // 当当前节点的父节点就是自己，说明找到了
        return x;
    }

    public void union(int a, int b){
        // 把两个不相交的集合合并为同一个集合
        // 这里把默认a小于b，这样可以避免形成环，
        // 不然可能形成a的父节点是b，b的父节点是a的情况，然后find的时候陷入死循环
        // 这里可能还存在没考虑到的情况，请提出，
        // 但是对于这道题没问题
        int father_a = find(a);
        int father_b = find(b);
        father.set(father_b, father_a);
    }

    public boolean isInSameSet(int a, int b){
        return find(a) == find(b);
    }

    public int NumOfSet(){
        // 返回整个集合中现有的不相交的集合个数
        int ans = 0;
        for(int i =0; i < this.SIZE; i++){
            if(father.get(i) == i){
                ans++;
            }
        }
        return ans;
    }
}
