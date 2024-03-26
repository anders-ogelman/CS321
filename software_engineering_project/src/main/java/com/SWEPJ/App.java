package com.SWEPJ;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Hello world!
 *
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Button Entry = new Button("Entry");
        Button Review = new Button("Review");
        Button Approve = new Button("Approve");
        HBox box1 = new HBox(10);
        // box1.setAlignment(Pos.BOTTOM_RIGHT);
        box1.getChildren().add(Entry);
        box1.getChildren().add(Review);
        box1.getChildren().add(Approve);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        // grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(box1, 1, 4);
        Scene scene = new Scene(grid, 300, 275); // Scene scene = new Scene(new StackPane(l), 640, 480);
        Entry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("testing Entry");
                Entry entry = new Entry();
                entry.start();

            }
        });
        Review.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("testing Review");
                Review review = new Review();
                review.start();

            }
        });
        Approve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("testing Approve");
                Approve approve = new Approve();
                approve.start();
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // System.out.println(args[0]);
        launch();
    }
}
