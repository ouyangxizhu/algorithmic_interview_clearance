package _36_38_trie;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class _212_TwoOneTwo {
    /**
     * enhanced TrieTree + DFS.
     */

    private TrieNode root = new TrieNode(' '); // initialize a TrieTree structure
    private boolean[][] used;
    private int board_width, board_length;
    private Set<String> res = new TreeSet<>(); //use treeSet sort word

    private static class TrieNode {
        static final int CHAR_NUM = 26;
        private char val;
        private boolean isWord = false;
        private TrieNode[] children = new TrieNode[CHAR_NUM];

        private TrieNode() {
        }

        private TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    /**
     * Inserts a word into the trie.
     */
    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode(c);
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (words.length == 0)
            return new LinkedList<String>();

        for (String word : words)
            insert(word);
        board_length = board.length;
        board_width = board[0].length;
        used = new boolean[board_length][board_width];

        for (int i = 0; i < board_length; i++)
            for (int j = 0; j < board_width; j++)
                dfs(i, j, board, new StringBuilder(), root, used);
        return new LinkedList<String>(res);
    }

    private void dfs(int line, int row, char[][] board, StringBuilder sb,
                     TrieNode currNode, boolean[][] used) {

        if (line < 0 || line >= board_length || row < 0 || row >= board_width)
            return;
        if (used[line][row])
            return;
        if (currNode.children[board[line][row] - 'a'] == null)
            return;
        sb.append(board[line][row]);
        currNode = currNode.children[board[line][row] - 'a'];
        if (currNode.isWord)
            res.add(sb.toString());

        used[line][row] = true;
        dfs(line - 1, row, board, sb, currNode, used);
        dfs(line + 1, row, board, sb, currNode, used);
        dfs(line, row - 1, board, sb, currNode, used);
        dfs(line, row + 1, board, sb, currNode, used);
        sb.deleteCharAt(sb.length() - 1);  // recover StringBuilder for next dfs
        used[line][row] = false;    // recover boolean[][] used for next dfs
    }

}
