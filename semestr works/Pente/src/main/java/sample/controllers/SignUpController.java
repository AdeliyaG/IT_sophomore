package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SignUpController {
    StageController stageController = new StageController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameInputField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton waterRadioButton;

    @FXML
    private ToggleGroup choose;

    @FXML
    private RadioButton earthRadioButton;

    @FXML
    private RadioButton fireRadioButton;

    @FXML
    private RadioButton airRadioButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        stageController.stageControllerLogic(signUpButton, "mainWindow");
        stageController.stageControllerLogic(backButton, "login");

    }
}

