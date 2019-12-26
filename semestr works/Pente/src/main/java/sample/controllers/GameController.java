package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import sample.protocol.SocketClient;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.Cursor.HAND;

public class GameController {
    StageController stageController = new StageController();
    SocketClient client = new SocketClient();
    Button[][] buttons;

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

        buttons = new Button[11][11];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                Button button = new Button();
                button.setLayoutX(initX + range * i);
                button.setLayoutY(initY + range * j);
                button.setText("   ");
                button.setStyle("-fx-background-color: invisible;");
                button.setCursor(HAND);
                buttons[i][j] = button;

                button.setOnAction(event -> {
                    int buttonX = (int) button.getLayoutX();
                    int buttonY = (int) button.getLayoutY();

                    // отправить сообщение на сервер

                    String color = "#42aaff";
                    button.setStyle("-fx-background-color: " + color + "; -fx-background-radius: 30px;");

                    //потом передаем ход сопернику бат хау

//                    String buttonStyle = button.getStyle().replace("-fx-background-color: ", "");
//
                    check(buttonX, buttonY, button, color);
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

    public int check(int x, int y, Button button, String color) {
        int range = 40;

        button.setLayoutX(x + range);

        //horizontal
        if ((x + range & x + range * 2) ==) {


        }
    }
}