module lk.edu.tictacgame.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.edu.tictacgame.tictactoe to javafx.fxml;
    exports lk.edu.tictacgame.tictactoe;
}