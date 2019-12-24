package sample.controllers;


import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

import static javafx.scene.Cursor.HAND;

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
        int initX = 27;
        int initY = 28;
        int range = 40;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                Button button = new Button();
                button.setLayoutX(initX + range* i);
                button.setLayoutY(initY + range * j);
                button.setText("   ");
                button.setStyle("-fx-background-color: invisible;");
                button.setCursor(HAND);

                button.setOnAction(event -> {
                    int buttonX = (int) button.getLayoutX();
                    int buttonY = (int) button.getLayoutY();
                    button.setStyle("-fx-background-color: #42aaff; -fx-background-radius: 30px;");
                    //потом передаем ход сопернику бат хау
                });

                gameField.getChildren().add(button);
            }
        }



        stageController.stageControllerLogic(quitButton, "mainWindow");
    }
}