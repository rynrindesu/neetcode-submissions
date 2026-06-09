class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colsMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {

            Set<Integer> rowSet = rowMap.get(i);

            if (rowSet == null) {
                rowSet = new HashSet<>();
            }

            for (int j = 0; j < board[i].length; j++) {
                Set<Integer> colSet = colsMap.get(j);

                if (colSet == null) {
                    colSet = new HashSet<>();
                }

                if (board[i][j] == '.') {
                    continue;
                }

                int current = board[i][j] - '0';

                if (rowSet.contains(current) || colSet.contains(current)) {
                    return false;
                }

                if (!rowSet.contains(current)) {
                    rowSet.add(current);
                    rowMap.put(i, rowSet);
                }

                if (!colSet.contains(current)) {
                    colSet.add(current);
                    colsMap.put(j, colSet);
                }
            }

        }

        return check(0, 0, board) && check(3, 0, board) && check(6, 0, board)
                && check(0, 3, board) && check(3, 3, board) && check(6, 3, board)
                && check(0, 6, board) && check(3, 6, board) && check(6, 6, board);

    }

    public boolean check(int row, int col, char[][] board) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[row + i][col + j] == '.') {
                    continue;
                }

                int current = board[row + i][col + j] - '0';

                if (set.contains(current)) {
                    return false;
                } else {
                    set.add(current);
                }

            }
        }

        return true;
    }
}
