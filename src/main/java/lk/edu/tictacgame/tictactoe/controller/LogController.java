package lk.edu.tictacgame.tictactoe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import lk.edu.tictacgame.tictactoe.Board.BoardImpl;

import java.io.IOException;

public class LogController {



    @FXML
    private AnchorPane anlog;
    @FXML
    void logButten(ActionEvent event) throws IOException {

        anlog.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/dashBoad.fxml"));
        anlog.getChildren().add(load);

    }

    public void buttonOnClick(ActionEvent actionEvent) {

    }
}
