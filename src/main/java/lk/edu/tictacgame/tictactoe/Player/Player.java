package lk.edu.tictacgame.tictactoe.Player;

import lk.edu.tictacgame.tictactoe.Board.BoardImpl;
import lk.edu.tictacgame.tictactoe.Servers.Piece;

public abstract class Player {
    protected BoardImpl board;

    public Player(BoardImpl board, Piece piece) {
        this.board = board;
    }

    public abstract void move(int row, int col);
}