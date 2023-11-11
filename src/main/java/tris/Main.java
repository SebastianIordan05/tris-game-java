package tris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JavaRender trisRender = new JavaRender();
        TrisLogic trisLogic = new TrisLogic();
        Scanner scanner = new Scanner(System.in);

        trisRender.printGrid();

        while (true) {
            System.out.print("Giocatore " + trisLogic.getCurrentPlayer() + ", inserisci la riga (0, 1, o 2): ");
            int currentPlayerRow = scanner.nextInt();

            System.out.print("Giocatore " + trisLogic.getCurrentPlayer() + ", inserisci la colonna (0, 1, o 2): ");
            int currentPlayerCol = scanner.nextInt();

            if (trisLogic.makeMove(currentPlayerRow, currentPlayerCol)) {
                trisRender.setCell(currentPlayerRow, currentPlayerCol, trisLogic.getCurrentPlayer());
                trisRender.printGrid();

                if (trisLogic.isGameWon()) {
                    System.out.println("Il giocatore " + trisLogic.getWinner() + " ha vinto!");
                    break;
                } else if (trisLogic.isGameDraw()) {
                    System.out.println("Pareggio!");
                    break;
                }
            } else {
                System.out.println("Mossa non valida. Riprova.");
            }
        }
    }
}