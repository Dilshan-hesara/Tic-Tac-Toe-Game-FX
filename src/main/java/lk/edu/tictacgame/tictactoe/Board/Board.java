package lk.edu.tictacgame.tictactoe.Board;

import lk.edu.tictacgame.tictactoe.Servers.Piece;
import lk.edu.tictacgame.tictactoe.Servers.Winner;

public interface Board {

    void initializeBoard();

    boolean isLegalMove(int row, int col);

    void upMove(int row, int col, Piece piece);

    Winner checkWinner();

    boolean isFull();

    void reset();
}
