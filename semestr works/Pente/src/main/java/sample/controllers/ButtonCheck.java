package sample.controllers;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import static javafx.scene.Cursor.HAND;

public class ButtonCheck extends Button {
    int initX = 27;
    int initY = 28;
    int range = 40;
    int x, y;
    boolean isInvisible = false;

    public void setX(int x) {
        this.x = x;
        setLayoutX(initX + range * x);
    }

    public void setY(int y) {
        this.y = y;
        setLayoutY(initY + range * y);
    }

    public void setColor(String color) {
        this.color = color;
        setStyle("-fx-background-color: "+color+";");
    }

    public void setInvisible(boolean isInvisible) {
        if(!isInvisible) {
            setColor(color);
        } else {
            setStyle("-fx-background-color: invisible");
        }
    }

    String color;

    public ButtonCheck(int x, int y, String color) {
        setX(x);
        setY(y);
        setColor(color);
        setText("   ");
        setCursor(HAND);
        setStyle("-fx-background-radius: 30px");
        setInvisible(true);
    }
}
