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
                if (pieces[i][j] == Piece.EMPTY) { // piece ekek his teyena tanaqk blanava o daganna
                    pieces[i][j] = Piece.O; // ekata o daganna va
                    int moveValue = minimax(pieces, 0, false); // dan  minmax algo ekta call karanava hoda move ek illagannava    // me adima hodainam  danata moveValuve ekta daganova
                    pieces[i][j] = Piece.EMPTY; // essla dagatta o move eka  emty kragannava

                    if (moveValue > bestValue) { // moveValue eka  > bestValuve nam "o" ge adima bestRow,bestCol ekatai dagannava
                        bestValue = moveValue; // gatta vlave eka danata teyena ekta vada vdi nam eka daganna va
                        bestRow = i; //ee val ekta adala row ekda dagannava
                        bestCol = j;//ee val ekta adala col  ekda dagannava
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
        if (winner != null) { // kauru hari dinnd keyl balano
            if (winner.getWinningPiece() == Piece.O) {
                return +depth;// ai eka puluwan tharam ikmanata dinanna balanava
            } else if (winner.getWinningPiece() == Piece.X) {
                return - depth; // ai eka puluwan tharam pahuwela paradenna balanava
            }
        }


        if (board.isFull()) {
            return 0;// draw venava
        }

        if (isMaximizing) { // ai ge dinna chanace ek maxzimaize karanava
            int bestValue = Integer.MIN_VALUE; // hodama val ekata danata aduma vllue eka dagannava
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY) {
                        pieces[i][j] = Piece.O; // board eke piece eka empty nan ekata danata O danava
                        bestValue = Math.max(bestValue, minimax(pieces, depth + 1, false));// minimax eka call karala depth ekak wadi karala eelaga recursion eke human dinana chance eka minimize karanava
                        pieces[i][j] = Piece.EMPTY;// dapu pice eka ain karano
                    }
                }
            }
            return bestValue; //valuve eka return karano

        } else {// human ge dinana chane eka adu kranava
            int bestValue = Integer.MAX_VALUE;// adu karaddi aduma score eka daganna one hinda danata wadima score eka danava
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY) {
                        pieces[i][j] = Piece.X;// kalin wage piece eka empty nan X dagannava
                        bestValue = Math.min(bestValue, minimax(pieces, depth + 1, true)); //minimax ekata call karala ai depth eka ekakin wadi karala eelaga recursion eke ai ge dinana chance eka maximize karanava
                        pieces[i][j] = Piece.EMPTY;// dapu pice eka ain karano
                    }
                }
            }
            return bestValue; // dapu valu eka return karanava
        }
    }
}

