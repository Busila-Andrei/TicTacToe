package org.example;

public class Result {

    public boolean gameResult(char[][] board) {

        if (winX(board)) {
            System.out.println("X wins");
            return true;
        }
        else if (winO(board)) {
            System.out.println("O wins");
            return  true;
        }
        else  if (draw(board)) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public boolean winX(char[][] board) {
        int i, j;

        j = 1;
        for (i = 0; i < 3; i++){
            if (board[i][j-1] == 'X' && board[i][j] == 'X' && board[i][j+1] == 'X'){
                return true;
            }
        }

        i = 1;
        for (j = 0; j < 3; j++){
            if (board[i-1][j] == 'X' && board[i][j] == 'X' && board[i+1][j] == 'X'){
                return true;
            }
        }

        i = 1;
        j = 1;
        if (board[i-1][j-1] == 'X' && board[i][j] == 'X' && board[i+1][j+1] == 'X'){
            return true;
        }else return board[i + 1][j - 1] == 'X' && board[i][j] == 'X' && board[i - 1][j + 1] == 'X';
    }

    public boolean winO(char[][] board) {
        int i, j;

        j = 1;
        for (i = 0; i < 3; i++){
            if (board[i][j-1] == 'O' && board[i][j] == 'O' && board[i][j+1] == 'O'){
                return true;
            }
        }

        i = 1;
        for (j = 0; j < 3; j++){
            if (board[i-1][j] == 'O' && board[i][j] == 'O' && board[i+1][j] == 'O'){
                return true;
            }
        }

        i = 1;
        j = 1;
        if (board[i-1][j-1] == 'O' && board[i][j] == 'O' && board[i+1][j+1] == 'O'){
            return true;
        }else return board[i + 1][j - 1] == 'O' && board[i][j] == 'O' && board[i - 1][j + 1] == 'O';
    }

    public boolean draw(char[][] board){
        int i, j, nr1 = 0, nr2 = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (board[i][j] == 'X')
                    nr1++;
                else if (board[i][j] == 'O')
                    nr2++;
            }
        }
        return (nr1 + 1 == nr2 || nr2 + 1 == nr1) & (nr1 + nr2 == 9);

    }
}
