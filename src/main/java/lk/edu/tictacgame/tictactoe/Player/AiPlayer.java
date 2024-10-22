package lk.edu.tictacgame.tictactoe.Player;

import lk.edu.tictacgame.tictactoe.Board.BoardImpl;
import lk.edu.tictacgame.tictactoe.Servers.Piece;

public class AiPlayer extends Player {

    public AiPlayer(BoardImpl board) {
        super(board, Piece.O);
    }

    @Override
    public void move(int row, int col) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isLegalMove(i, j)) {
                    board.upMove(i, j, Piece.O);
                    return;
                }
            }
        }
    }
}
