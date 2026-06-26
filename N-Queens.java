1import java.util.ArrayList;
2import java.util.List;
3//learn from kunal kushwaha playlist he explained better
4
5class Solution {
6    public List<List<String>> solveNQueens(int n) {
7        List<List<String>> result = new ArrayList<>();
8        char[][] board = new char[n][n];
9        
10        for (int i = 0; i < n; i++) {
11            for (int j = 0; j < n; j++) {
12                board[i][j] = '.';
13            }
14        }
15        
16        boolean[] cols = new boolean[n];
17        boolean[] diag1 = new boolean[2 * n]; // r + c
18        boolean[] diag2 = new boolean[2 * n]; // r - c + n
19        
20        backtrack(0, n, board, result, cols, diag1, diag2);
21        return result;
22    }
23    
24    private void backtrack(int row, int n, char[][] board, List<List<String>> result, 
25                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
26        if (row == n) {
27            result.add(construct(board));
28            return;
29        }
30        
31        for (int col = 0; col < n; col++) {
32            int d1 = row + col;
33            int d2 = row - col + n;
34            
35            if (cols[col] || diag1[d1] || diag2[d2]) {
36                continue;
37            }
38            
39            board[row][col] = 'Q';
40            cols[col] = true;
41            diag1[d1] = true;
42            diag2[d2] = true;
43            
44            backtrack(row + 1, n, board, result, cols, diag1, diag2);
45            
46            board[row][col] = '.';
47            cols[col] = false;
48            diag1[d1] = false;
49            diag2[d2] = false;
50        }
51    }
52    
53    private List<String> construct(char[][] board) {
54        List<String> path = new ArrayList<>();
55        for (int i = 0; i < board.length; i++) {
56            path.add(new String(board[i]));
57        }
58        return path;
59    }
60}