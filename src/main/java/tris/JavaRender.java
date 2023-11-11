package tris;

public class JavaRender {
    private char[][] grid;

    public JavaRender() {
        grid = new char[3][3];
        initializeGrid();
    }

    public void initializeGrid() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    public void setCell(int row, int col, char symbol) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == ' ') {
            grid[row][col] = symbol;
        } else {
            System.out.println("Mossa non valida. La cella è già occupata o le coordinate non sono valide.");
        }
    }

    public void printGrid() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(grid[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}
