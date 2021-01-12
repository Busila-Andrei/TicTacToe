package org.example.domain;

public class Result {

    public boolean gameResult(char[][] board,char userCharacter) {

        if (win(board,userCharacter))
        if (userCharacter == 'X'){
            System.out.println("X wins");
            return true;
        } else if (userCharacter == 'O') {
            System.out.println("O wins");
            return  true;
        }
        else  if (draw(board)) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public boolean win(char[][] board, char userCharacter) {
        int i, j;

        j = 1;
        for (i = 0; i < 3; i++){
            if (board[i][j-1] == userCharacter && board[i][j] == userCharacter && board[i][j+1] == userCharacter){
                return true;
            }
        }

        i = 1;
        for (j = 0; j < 3; j++){
            if (board[i-1][j] == userCharacter && board[i][j] == userCharacter && board[i+1][j] == userCharacter){
                return true;
            }
        }

        i = 1;
        j = 1;
        if (board[i-1][j-1] == userCharacter && board[i][j] == userCharacter && board[i+1][j+1] == userCharacter){
            return true;
        }else return board[i + 1][j - 1] == userCharacter && board[i][j] == userCharacter && board[i - 1][j + 1] == userCharacter;
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
