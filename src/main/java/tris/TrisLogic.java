package tris;

public class TrisLogic {
    private final char[][] grid;
    private char currentPlayer;
    private boolean gameWon;
    private boolean gameDraw;

    public TrisLogic() {
        grid = new char[3][3];
        currentPlayer = 'X';
        gameWon = false;
        gameDraw = false;
        initializeGrid();
    }

    public void initializeGrid() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (!gameWon && !gameDraw && row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == ' ') {
            grid[row][col] = currentPlayer;
            checkWin(row, col);
            checkDraw();
            togglePlayer();
            return true;
        }
        return false;
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void checkWin(int row, int col) {
        if (checkRow(row) || checkColumn(col) || checkDiagonals(row, col)) {
            gameWon = true;
        }
    }

    private boolean checkRow(int row) {
        return (grid[row][0] == currentPlayer && grid[row][1] == currentPlayer && grid[row][2] == currentPlayer);
    }

    private boolean checkColumn(int col) {
        return (grid[0][col] == currentPlayer && grid[1][col] == currentPlayer && grid[2][col] == currentPlayer);
    }

    private boolean checkDiagonals(int row, int col) {
        return (row == col && checkPrimaryDiagonal()) || (row + col == 2 && checkSecondaryDiagonal());
    }

    private boolean checkPrimaryDiagonal() {
        return (grid[0][0] == currentPlayer && grid[1][1] == currentPlayer && grid[2][2] == currentPlayer);
    }

    private boolean checkSecondaryDiagonal() {
        return (grid[0][2] == currentPlayer && grid[1][1] == currentPlayer && grid[2][0] == currentPlayer);
    }

    public void checkDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col] == ' ') {
                    return;
                }
            }
        }
        gameDraw = true;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public boolean isGameDraw() {
        return gameDraw;
    }

    public char getWinner() {
        if (gameWon) {
            return currentPlayer == 'X' ? 'O' : 'X';
        }
        return ' ';
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }
}

