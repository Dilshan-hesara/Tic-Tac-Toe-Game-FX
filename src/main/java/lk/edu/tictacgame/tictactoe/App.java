package lk.edu.tictacgame.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/logingPage.fxml")));
        Scene scene = new Scene(root, 642, 439);

        Image image = new Image(getClass().getResourceAsStream("/images/app_icon.png"));
        stage.getIcons().add(image);

        stage.setTitle("Tic-Tac-Toe-Game");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}

