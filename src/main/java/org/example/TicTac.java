package org.example;

import java.util.Scanner;

public class TicTac {
    Scanner scanner = new Scanner(System.in);
    char[][] tic = new char[9][9];

    public TicTac() {
        initializare();
        board();
        iaGame();

    }

    public void iaGame() {
        int player = 1;
        for(;;) {


            coodinates(player);
            board();
            if(gameResult())
                break;
            player++;
        }
    }

    public void initializare() {
        int i, j ;
        for (j = 3; j > 0; j--)
            for (i = 1; i < 4; i++) {
                this.tic[i][j] = ' ';
            }
    }

    public boolean winX() {
        int i, j, sum;
        for (j = 3; j > 0; j--) {
            sum = 0;
            for (i = 1; i < 4; i++) {
                sum = sum + tic[i][j];
            }
            if (sum == 264) {
                return true;
            }
        }

        for (i = 1; i < 4; i++) {
            sum = 0;
            for (j = 3; j > 0; j--) {
                sum = sum + tic[i][j];
            }
            if (sum == 264) {
                return true;
            }
        }
        sum = 0;
        for (j = 3; j > 0; j--) {

            for (i = 1; i < 4; i++) {
                if (i == j) {
                    sum = sum + tic[i][j];
                }
            }
            if (sum == 264) {
                return true;
            }
        }
        sum = 0;
        for (j = 3; j > 0; j--) {
            for (i = 1; i < 4; i++) {
                if (i + j == 3) {
                    sum = sum + tic[i][j];
                }
            }
            if (sum == 264) {
                return true;
            }
        }

        return false;
    }

    public boolean winO() {
        int i, j, sum;
        for (j = 3; j > 0; j--) {
            sum = 0;
            for (i = 1; i < 4; i++) {
                sum = sum + tic[i][j];
            }
            if (sum == 237) {
                return true;
            }
        }

        for (i = 1; i < 4; i++) {
            sum = 0;
            for (j = 3; j > 0; j--) {
                sum = sum + tic[i][j];
            }
            if (sum == 237) {
                return true;
            }
        }
        sum = 0;
        for (j = 3; j > 0; j--) {

            for (i = 1; i < 4; i++) {
                if (i == j) {
                    sum = sum + tic[i][j];
                }
            }
            if (sum == 237) {
                return true;
            }
        }
        sum = 0;
        for (j = 3; j > 0; j--) {
            for (i = 1; i < 4; i++) {
                if (i + j == 3) {
                    sum = sum + tic[i][j];
                }
            }
            if (sum == 237) {
                return true;
            }
        }

        return false;
    }

    public boolean draw(){
        int i, j, nr1 = 0, nr2 = 0;
        for (j = 3; j > 0; j--) {
            for (i = 1; i < 4; i++) {
                if (tic[i][j] == 'X')
                    nr1++;
                else if (tic[i][j] == 'O')
                    nr2++;
            }
        }
        return (nr1 + 1 == nr2 || nr2 + 1 == nr1) & (nr1 + nr2 == 9);

    }

    public void coodinates(int player) {
        int first = 0, second = 0;


        for (; ; ) {
            System.out.print("Enter the coordinates: ");
            try {
                String[] pieces = scanner.nextLine().split(" ");
                first = Integer.parseInt(pieces[0]);
                second = Integer.parseInt(pieces[1]);

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
            if (first > 3 || second > 3)
                System.out.println("Coordinates should be from 1 to 3!");
            else if (tic[first][second] == ' '& player % 2 == 0) {
                tic[first][second] = 'O';
                break;
            } else if (tic[first][second] == ' '& player % 2 != 0) {
                tic[first][second] = 'X';
                break;
            }
            else System.out.println("This cell is occupied! Choose another one!");
        }

    }

    public boolean gameResult() {

        if (winX()) {
            System.out.println("X wins");
            return true;
        }
        else if (winO()) {
            System.out.println("O wins");
            return  true;
        }
        else  if (draw()) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public void board() {
        int i, j;
        System.out.println("---------");
        for (j = 3; j >= 1; j--) {
            System.out.print("| ");
            for (i = 1; i <= 3; i++)
                System.out.print(tic[i][j] + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
