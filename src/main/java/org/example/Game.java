package org.example;

import org.example.utils.ScannerUtils;

public class Game {

    private final Board board = new Board();
    private final User user1 = new User('X');
    private final User user2 = new User('O');
    private final Result result = new Result();

    public void start(){
        board.printBoard();
        logicGame();
    }

    public void logicGame(){
        for(;;){
            input(user1.getCharacter());
            board.printBoard();
            if (result.gameResult(board.getBoard())){
                break;
            }
            input(user2.getCharacter());
            board.printBoard();
            if (result.gameResult(board.getBoard())){
                break;
            }

        }
    }

    public void input(char character){
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
            if (i > 3 || j > 3)
                System.out.println("Coordinates should be from 1 to 3!");
            else if (board.getCordBoard(i-1,j-1) == ' ') {
                board.setBoard(i-1,j-1,character);
                break;
            }
            else System.out.println("This cell is occupied! Choose another one!");
        }
    }
}
