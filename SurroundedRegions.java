import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0) return;
        int m = board.length;
        int n = board[0].length;
        if(Math.min(m,n)<3) return;
        assert m<(1<<16) && n<(1<<16);
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]=='O') {
                    board[i][j]='?';
                }
            }
        }
        for(int i=0;i<m;i++) {
            if(board[i][0]=='?') {
                bfs(board, i, 0, set);
            }
            if(board[i][n-1]=='?') {
                bfs(board, i, n - 1, set);
            }
        }
        for(int j=0; j<n; j++) {
            if(board[0][j]=='?') {
                bfs(board, 0, j, set);
            }
            if(board[m-1][j]=='?') {
                bfs(board, m - 1, j, set);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]=='?') {
                    board[i][j]='X';
                }
            }
        }
    }
    private void bfs(char[][] board, int i, int j, HashSet<Integer> set) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i);
        queue.add(j);
        while(!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();
            if(set.contains((a<<16)+b)) continue;
            board[a][b] = 'O';
            set.add((a << 16) + b);
            if (a - 1 >= 0 && board[a - 1][b] == '?') {
                queue.add(a-1);
                queue.add(b);
            }
            if (a + 1 < board.length && board[a + 1][b] == '?') {
                queue.add(a+1);
                queue.add(b);
            }
            if (b - 1 >= 0 && board[a][b - 1] == '?') {
                queue.add(a);
                queue.add(b-1);
            }
            if (b + 1 < board[0].length && board[a][b + 1] == '?') {
                queue.add(a);
                queue.add(b+1);
            }
        }
    }
}
