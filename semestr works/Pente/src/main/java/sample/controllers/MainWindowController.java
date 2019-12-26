package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainWindowController {
    StageController stageController = new StageController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private Button rulesButton;

    @FXML
    private Button gameButton;

    @FXML
    private Button profileButton;

    @FXML
    private Label label;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        stageController.stageControllerLogic(gameButton, "choose");
        stageController.stageControllerLogic(rulesButton, "rules");
        stageController.stageControllerLogic(exitButton, "sample");
    }
}
