package org.example.service;

import org.example.controller.utils.ScannerUtils;
import org.example.domain.Board;
import org.example.domain.Result;

public class Menu {

    private final Board board;
    char user1;
    char user2;
    private final Result result = new Result();


    public Menu(){
        this.user1 = 'X';
        this.user2 = 'O';
        this.board = new Board();
        board.printBoard();
        logicApp();
    }

    public void logicApp(){
        for(;;){
            inputUser(user1);
            board.printBoard();
            if (result.gameResult(board.getBoard(),user1)){
                break;
            }
            inputUser(user2);
            board.printBoard();
            if (result.gameResult(board.getBoard(),user2)){
                break;
            }

        }
    }

    public void inputUser(char character){
        int i = 0, j = 0;
        for (; ; ) {
            System.out.print("Enter the coordinates: ");
            try {
                String[] pieces = ScannerUtils.nextLine().split(" ");
                i = Integer.parseInt(pieces[0]);
                j = Integer.parseInt(pieces[1]);

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
            if (i > 3 || j > 3 || i < 1 || j < 1)
                System.out.println("Coordinates should be from 1 to 3!");
            else if (board.getCordBoard(i-1,j-1) == ' ') {
                board.setBoard(i-1,j-1,character);
                break;
            }
            else System.out.println("This cell is occupied! Choose another one!");
        }
    }
}
