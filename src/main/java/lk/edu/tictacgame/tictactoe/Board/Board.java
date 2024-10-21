package lk.edu.tictacgame.tictactoe.Board;

import lk.edu.tictacgame.tictactoe.Servers.Piece;
import lk.edu.tictacgame.tictactoe.Servers.Winner;

public interface Board {

    void initializeBoard();

    boolean isLegalMove(int row, int col);

    void placePiece(int row, int col, Piece piece);

    Piece getPieceAt(int row, int col);

    Winner checkWinner();

    boolean isFull();

    void reset();
}