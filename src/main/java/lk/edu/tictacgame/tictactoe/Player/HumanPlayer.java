package lk.edu.tictacgame.tictactoe.Player;

import lk.edu.tictacgame.tictactoe.Board.BoardImpl;
import lk.edu.tictacgame.tictactoe.Servers.Piece;

public class HumanPlayer extends Player {
    public HumanPlayer(BoardImpl board) {
        super(board, Piece.X); //human player pavichi karanne  x
    }

    @Override
    public void move(int row, int col) {
        if (board.isLegalMove(row, col)) {
            board.upMove(row,col,Piece.X);
        }

    }
}
