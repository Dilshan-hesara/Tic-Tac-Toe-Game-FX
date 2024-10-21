package lk.edu.tictacgame.tictactoe.Player;

import lk.edu.tictacgame.tictactoe.Board.BoardImpl;

public abstract class Player {
    protected BoardImpl board;

    public Player(BoardImpl board) {
        this.board = board;

    }

    public abstract void move(int row, int col);

}
