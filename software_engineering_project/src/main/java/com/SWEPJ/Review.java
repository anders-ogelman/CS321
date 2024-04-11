package com.SWEPJ;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class Review {
    public Review() {
        // System.out.println("Hello World!");
        Stage secondStage = new Stage();
        GridPane grid = new GridPane();
        Button next = new Button("Next");
        TextField fullName = new TextField();
        TextField PID = new TextField();
        Label field1 = new Label("Full Name:");
        Label field2 = new Label("PID:");
        Label in1 = new Label("");
        Label in2 = new Label("");
        Label out1 = new Label("Set Full Name:");
        Label out2 = new Label("Set PID:");
        fullName.setPromptText("first middle last");
        PID.setPromptText("111-11-1111");
        GridPane.setConstraints(next, 0, 0);
        GridPane.setConstraints(field1, 0, 1);
        GridPane.setConstraints(in1, 1, 1);
        GridPane.setConstraints(out1, 2, 1);
        GridPane.setConstraints(fullName, 3, 1);
        GridPane.setConstraints(field2, 0, 2);
        GridPane.setConstraints(in2, 1, 2);
        GridPane.setConstraints(out2, 2, 2);
        GridPane.setConstraints(PID, 3, 2);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.getChildren().addAll(next);
        grid.getChildren().addAll(field1, in1, out1, fullName);
        grid.getChildren().addAll(field2, in2, out2, PID);
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                in1.setText("Accepted");
            }
        });
        // in1.setText("test");

        // grid.setPadding(new Insets(10, 10, 10, 10));
        // grid.setVgap(5);
        // grid.setHgap(5);

        // Label in1 = new Label("");

        // fullName.setPromptText("Testing");
        // fullName.setPrefColumnCount(15);
        // fullName.getText();
        // GridPane.setConstraints(fullName, 0, 1);
        // grid.getChildren().add(fullName);
        secondStage.setScene(new Scene(grid, 800, 600));

        secondStage.show();
    }
}