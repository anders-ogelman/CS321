package com.SWEPJ;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Approve {
    public Approve() {
        System.out.println("Hello World!");
        Stage secondStage = new Stage();

        secondStage.setScene(new Scene(new HBox(4, new Label("Approve window"))));
        secondStage.show();
    }
}