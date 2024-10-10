package lk.edu.tictacgame.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/logingPage.fxml")));
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);

        stage.setTitle("Tic-Tac-Toe-Game");

        stage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}

