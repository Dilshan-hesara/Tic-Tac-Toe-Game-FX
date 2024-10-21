package lk.edu.tictacgame.tictactoe.Board;

import lk.edu.tictacgame.tictactoe.Servers.Piece;
import lk.edu.tictacgame.tictactoe.Servers.Winner;

public class BoardImpl implements Board {

    private Piece[][] pieces = new Piece[3][3];


    @Override
    public void initializeBoard() {

    }

    @Override
    public boolean isLegalMove(int row, int col) {
        return false;
    }

    @Override
    public void placePiece(int row, int col, Piece piece) {

    }

    @Override
    public Piece getPieceAt(int row, int col) {
        return null;
    }

    @Override
    public Winner checkWinner() {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void reset() {

    }
}
