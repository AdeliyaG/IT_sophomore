package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ChooseController {
    StageController stageController = new StageController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private RadioButton waterRadioButton;

    @FXML
    private ToggleGroup chooseColor;

    @FXML
    private RadioButton fireRadioButton;

    @FXML
    private RadioButton airRadioButton;

    @FXML
    private RadioButton earthRadioButton1;

    @FXML
    private Button beginButton;

    @FXML
    void initialize() {
        stageController.stageControllerLogic(beginButton, "game");

    }
}
