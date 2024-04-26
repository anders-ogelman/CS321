package com.SWEPJ;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.EventHandler;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Button entry = new Button("Entry");// declare buttons
        Button review = new Button("Review");
        Button approve = new Button("Approve");
        HBox box1 = new HBox(10);// make hbox
        box1.getChildren().add(entry);// add buttons to hbox
        box1.getChildren().add(review);
        box1.getChildren().add(approve);
        GridPane grid = new GridPane();// elements rest on a gridpane
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(box1, 0, 0);// add hbbox to gridpane
        Scene scene = new Scene(grid, 300, 275);
        entry.setOnAction(new EventHandler<ActionEvent>() {// start entry on press
            @Override
            public void handle(ActionEvent event) {
                new Entry();
            }
        });
        review.setOnAction(new EventHandler<ActionEvent>() {// start review on press
            @Override
            public void handle(ActionEvent event) {
                new Review();
            }
        });
        approve.setOnAction(new EventHandler<ActionEvent>() {// start approve on press
            @Override
            public void handle(ActionEvent event) {
                new Approve();
            }
        });

        stage.setScene(scene);// set the stage and show it
        stage.show();
    }

    public static void main(String[] args) {
        launch();// start the gui
    }
}
