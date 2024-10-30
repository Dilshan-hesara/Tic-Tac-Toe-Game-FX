package lk.edu.tictacgame.tictactoe.Player;

import lk.edu.tictacgame.tictactoe.Board.BoardImpl;
import lk.edu.tictacgame.tictactoe.Servers.Piece;
import lk.edu.tictacgame.tictactoe.Servers.Winner;

public class AiPlayer extends Player {

    public AiPlayer(BoardImpl board) {
        super(board, Piece.O);
    }

    @Override
    public void move(int row, int col) {
        findBestMove();
    }

    public void findBestMove() {
        int bestValue = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;
        Piece[][] pieces = board.getPieces();

        for (int i = 0; i < pieces.length; i++) { //row
            for (int j = 0; j < pieces[i].length; j++) { // col
                if (pieces[i][j] == Piece.EMPTY) { // deken ekkk  emty nam
                    pieces[i][j] = Piece.O; // ekata o daganna va
                    int moveValue = minimax(pieces, 0, false); // dan  minmax algo ekta call karanava    // me adima hodainam  danata moveValuve ekta daganova
                    pieces[i][j] = Piece.EMPTY; // essla dagatta o move eka  emty kragannava

                    if (moveValue > bestValue) { // moveValue eka  > bestValuve nam "o" ge adima bestRow,bestCol ekatai dagannava
                        bestRow = i;
                        bestCol = j;
                        bestValue = moveValue;
                    }
                }
            }
        }

        if (bestRow != -1 && bestCol != -1) { // bestRow-1,bestCol -1 eka tama evidihanam  danata dagena tiyena bestRow ,bestCol boadeke ui ekta update karaganna va
            board.upMove(bestRow, bestCol, Piece.O); // boad eka update kragannava
        }
    }

    private int minimax(Piece[][] pieces, int depth, boolean isMaximizing) { //minMax Algo ekta
        Winner winner = board.checkWinner();
        if (winner != null) {
            if (winner.getWinningPiece() == Piece.O) {
                return 10 - depth;
            } else if (winner.getWinningPiece() == Piece.X) {
                return depth - 10;
            }
        }


        if (board.isFull()) {
            return 0;
        }

        if (isMaximizing) {
            int bestValue = Integer.MIN_VALUE;
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY) {
                        pieces[i][j] = Piece.O;
                        bestValue = Math.max(bestValue, minimax(pieces, depth + 1, false));
                        pieces[i][j] = Piece.EMPTY;
                    }
                }
            }
            return bestValue;
        } else {
            int bestValue = Integer.MAX_VALUE;
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY) {
                        pieces[i][j] = Piece.X;
                        bestValue = Math.min(bestValue, minimax(pieces, depth + 1, true));
                        pieces[i][j] = Piece.EMPTY;
                    }
                }
            }
            return bestValue;
        }
    }
}

