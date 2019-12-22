package sample.controllers;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameController {
    StageController stageController = new StageController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button quitButton;

    @FXML
    private AnchorPane gameField;

    @FXML
    void initialize() {
        stageController.stageControllerLogic(quitButton, "mainWindow");
        gameField.setOnMouseMoved(e -> {
            double x = e.getX();
            double y = e.getY();
            if (x % 10 != 0) {
                return;
            } else {
                System.out.println(x);
            }

//            gameField.setOnMouseClicked(e -> {
//                if (x % 10 != 0) {
//
//                }
//            });
        });
    }
}