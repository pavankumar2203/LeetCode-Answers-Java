import java.util.*;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0 || board[0].length==0) return false;
        boolean found = false;
        assert board.length<10000 && board[0].length<10000;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                Set<Integer> used = new HashSet<Integer>();
                used.add(i*10000+j);
                if(dfs(board, i, j, word, used)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, Set<Integer> used) {
        if(word.isEmpty()) return true;
        if(word.charAt(word.length()-1) != board[i][j]) return false;
        for(int[] ij : new int[][]{{i-1, j}, {i, j-1}, {i+1, j}, {i, j+1}}) {
            int a = ij[0];
            int b = ij[1];
            if(a>=0 && b>=0 && a<board.length && b<board[0].length && !used.contains(a*10000+b)) {
                used.add(a*10000+b);
                if(dfs(board, a, b, word.substring(0, word.length()-1), used)) return true;
                else used.remove(Integer.valueOf(a*10000+b));
            }
        }
        return false;
    }
}
