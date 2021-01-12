package org.example.domain;

public class Board {

    private final char[][] board = new char[3][3];

    public Board(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard(){
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }



    public char[][] getBoard() {
        return board;
    }

    public char getCordBoard(int i, int j) {
        return board[i][j];
    }

    public void setBoard(int i, int j, char character) {
        this.board[i][j] = character;
    }
}
