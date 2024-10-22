/*
 * Copyright (c) 2024 Dilshan Hesara
 * Author: Dilshan Hesara
 * GitHub: https://github.com/Dilshan-hesara
 *
 * All Rights Reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to use
 * the Software for **personal or educational purposes only**, subject to the following conditions:
 *
 * - The Software may **not be sold** for commercial purposes.
 * - The Software may **not be modified** or altered in any way.
 * - Redistribution of this Software is permitted, provided that the original
 *   copyright notice and this permission notice appear in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES, OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT, OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package lk.edu.tictacgame.tictactoe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.edu.tictacgame.tictactoe.Board.BoardImpl;
import lk.edu.tictacgame.tictactoe.Board.BoardUi;
import lk.edu.tictacgame.tictactoe.Player.AiPlayer;
import lk.edu.tictacgame.tictactoe.Player.HumanPlayer;
import lk.edu.tictacgame.tictactoe.Servers.Piece;

import java.io.IOException;

public class dashBoadController implements BoardUi {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text winnerText;
    @FXML
    private AnchorPane anDash;

    BoardImpl boardGame;
    HumanPlayer humanPlayer;
    AiPlayer aiPlayer;

    public dashBoadController() {
        boardGame = new BoardImpl();
        aiPlayer = new AiPlayer(boardGame);
        humanPlayer = new HumanPlayer(boardGame);
    }



    @FXML
    void homePage(ActionEvent event) throws IOException {

        anDash.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/logingPage.fxml"));
        anDash.getChildren().add(load);
    }

    @FXML
    void onButtClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        int row = -1, col = -1;
        switch (buttonId) {
            case "button1": row = 0; col = 0; break;
            case "button2": row = 0; col = 1; break;
            case "button3": row = 0; col = 2; break;
            case "button4": row = 1; col = 0; break;
            case "button5": row = 1; col = 1; break;
            case "button6": row = 1; col = 2; break;
            case "button7": row = 2; col = 0; break;
            case "button8": row = 2; col = 1; break;
            case "button9": row = 2; col = 2; break;
        }

        if (boardGame.isLegalMove(row, col)) {
            humanPlayer.move(row, col);
            updateUi();

            if (boardGame.checkWinner() != null) {
                winnerText.setText(boardGame.checkWinner().getWinningPiece());
            } else if (boardGame.isFull()) {
                showAlt("Tie");
            } else {

                aiPlayer.move(row, col);
                updateUi();
                if (boardGame.checkWinner() != null) {
                    winnerText.setText(boardGame.checkWinner().getWinningPiece());
                }
            }
        } else {
            showAlt("Illegal move! Try again.");
        }
    }


    @Override
    public void updateBoard(int row, int col, Piece piece) {
        String pieceText = (piece != null) ? piece.toString() : "";
        if (row == 0 && col == 0) button1.setText(pieceText);
        else if (row == 0 && col == 1) button2.setText(pieceText);
        else if (row == 0 && col == 2) button3.setText(pieceText);
        else if (row == 1 && col == 0) button4.setText(pieceText);
        else if (row == 1 && col == 1) button5.setText(pieceText);
        else if (row == 1 && col == 2) button6.setText(pieceText);
        else if (row == 2 && col == 0) button7.setText(pieceText);
        else if (row == 2 && col == 1) button8.setText(pieceText);
        else if (row == 2 && col == 2) button9.setText(pieceText);
    }


    @FXML
    void restartGame(ActionEvent event) {
        boardGame.reset();
        winnerText.setText("Play Again!");
        resetBoardUi();
    }

    private void resetBoardUi() {
        button1.setDisable(false); button1.setText("");
        button2.setDisable(false); button2.setText("");
        button3.setDisable(false); button3.setText("");
        button4.setDisable(false); button4.setText("");
        button5.setDisable(false); button5.setText("");
        button6.setDisable(false); button6.setText("");
        button7.setDisable(false); button7.setText("");
        button8.setDisable(false); button8.setText("");
        button9.setDisable(false); button9.setText("");
    }

    private void disableAllButt() {
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
    }


    public void updateUi() {
        for (int i = 0; i < boardGame.getPieces().length; i++) {
            for (int j = 0; j < boardGame.getPieces()[i].length; j++) {
                Piece piece = boardGame.getPieces()[i][j];
                if (piece != null) {
                    updateBoard(i, j, piece);
                } else {
                    updateBoard(i, j, Piece.EMPTY);
                }
            }
        }
    }


    private void showAlt(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.setOnCloseRequest((DialogEvent event) -> {
            boardGame.initializeBoard();
            updateUi();
        });
        alert.showAndWait();
    }
}

