package org.cr.leetcode.dfs;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/31
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCB'
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class _79WordSearch {
    boolean[][] used;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && check(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int i, int j, int index) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)
                || used[i][j]) {
            return false;
        }
        if (index == word.length() - 1 && board[i][j] == word.charAt(index)) {
            return true;
        }

        used[i][j] = true;
        boolean res= check(board, word, i + 1, j, index + 1) ||
                check(board, word, i - 1, j, index + 1) ||
                check(board, word, i, j - 1, index + 1) ||
                check(board, word, i, j + 1, index + 1);
        used[i][j] = false;
        return res;
    }


    public boolean exist2(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist2(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist2(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
//        board[y][x] ^= 256;
        board[y][x] = '*'; // 进递归前将值替换为特殊值，如果方向往回退，则会return false，跟上行代码同理
        boolean exist = exist2(board, y, x+1, word, i+1)
                || exist2(board, y, x-1, word, i+1)
                || exist2(board, y+1, x, word, i+1)
                || exist2(board, y-1, x, word, i+1);
//        board[y][x] ^= 256;
        board[y][x] = word[i];
        return exist;
    }

    public static void main(String[] args) {
        _79WordSearch obj = new _79WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(obj.exist(board, "ABCB"));
    }
}
