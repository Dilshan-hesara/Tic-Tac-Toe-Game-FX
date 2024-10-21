package lk.edu.tictacgame.tictactoe.Board;

import lk.edu.tictacgame.tictactoe.Servers.Piece;
import lk.edu.tictacgame.tictactoe.Servers.Winner;

public class BoardImpl implements Board {

    private Piece[][] pieces = new Piece[3][3];
    public Piece[][] getPieces() {return pieces;};

    @Override
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    @Override
    public boolean isLegalMove(int row, int col) {
        return pieces[row][col] == Piece.EMPTY;
    }

    @Override
    public void upMove(int row, int col, Piece piece) {
        pieces[row][col] = piece;
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
