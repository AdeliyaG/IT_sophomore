package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class StartWindowController {

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
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'sample.fxml'.";
        assert startImage != null : "fx:id=\"startImage\" was not injected: check your FXML file 'sample.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'sample.fxml'.";

    }

}
