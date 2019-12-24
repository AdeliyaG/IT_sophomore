package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import sample.Main;

public class StartWindowController {
    StageController stageController = new StageController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private ImageView startImage;

    @FXML
    private Button loginButton;

    @FXML
    void initialize() {
        stageController.stageControllerLogic(loginButton, "login");
    }
}
