package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import sample.protocol.SocketClient;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController {
    StageController stageController = new StageController();
    SocketClient client = new SocketClient();
    ButtonCheck[][] buttons;

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
        String color = "#42aaff";

        buttons = new ButtonCheck[11][11];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                ButtonCheck button = new ButtonCheck(i, j, color);
                buttons[i][j] = button;

                button.setOnAction(event -> {
                    int buttonX = (int) button.getLayoutX();
                    int buttonY = (int) button.getLayoutY();

                    // отправить сообщение на сервер

                    ((ButtonCheck) event.getTarget()).setInvisible(false);

                    //потом передаем ход сопернику

                });

                gameField.getChildren().add(button);
            }
        }

        stageController.stageControllerLogic(quitButton, "mainWindow");
    }

    public void makeAction(String json) {
        switch (json) {
            case "BUUTON":
                String redColor = "RED";
                String whiteColor = "WHITE";
                String orangeColor = "#ffa100";
                break;
        }
    }

    public void check(ButtonCheck[][] buttons) {
//        for (int i = 0; i < ; i++) {
//            for (int j = 0; j < ; j++) {
//
//            }
//
//
//        }
    }
}