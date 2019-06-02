package _26_30_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class _30_TwoTwo {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        generateOneByOne("", list, n, n);
        return list;
    }

    public static void generateOneByOne(String sublist, List<String> list, int left, int right) {
        if (left > right) {
            return;
        }

        if (left > 0) {
            generateOneByOne(sublist + "(", list, left - 1, right);
        }

        if (right > 0) {
            generateOneByOne(sublist + ")", list, left, right - 1);
        }

        if (left == 0 && right == 0) {
            list.add(sublist);
        }
    }
}
