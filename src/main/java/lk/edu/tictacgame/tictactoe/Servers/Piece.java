package lk.edu.tictacgame.tictactoe.Servers;

public enum Piece {
    X, O, EMPTY;

    @Override
    public String toString() {
        switch (this) {
            case X: return "X";
            case O: return "O";
            case EMPTY: return "";
        }
        return "";
    }
}
