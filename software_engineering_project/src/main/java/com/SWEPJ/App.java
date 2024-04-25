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
        Button entry = new Button("Entry");
        Button review = new Button("Review");
        Button approve = new Button("Approve");
        HBox box1 = new HBox(10);
        box1.getChildren().add(entry);
        box1.getChildren().add(review);
        box1.getChildren().add(approve);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(box1, 1, 4);
        Scene scene = new Scene(grid, 300, 275);
        entry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Entry();

            }
        });
        review.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Review();
            }
        });
        approve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Approve();
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // System.out.println(WorkflowManager.info(2));
        // Boolean[] f = DatabaseManager.fetch(1).getFail();
        // for (int i = 0; i < f.length; i++) {
        // System.out.println(f[i]);
        // }
        launch();
    }
}
