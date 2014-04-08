import java.util.HashSet;
import java.util.Set;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row
        for(int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') {
                    continue;
                } else if(!set.contains(c)) {
                    set.add(c);
                }
                else {
                    return false;
                }
            }
        }
        //col
        for(int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for(int j = 0; j < 9; j++) {
                char c = board[j][i];
                if(c == '.') {
                    continue;
                } else if(!set.contains(c)) {
                    set.add(c);
                }
                else {
                    return false;
                }
            }
        }
        //3x3
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Set<Character> set = new HashSet<Character>();
                for(int m = 0; m < 3; m++) {
                    for(int n = 0; n < 3; n++) {
                        char c = board[i * 3 + m][j * 3 + n];
                        if(c == '.') {
                            continue;
                        } else if(!set.contains(c)) {
                            set.add(c);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
