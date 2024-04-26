package com.SWEPJ;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class Review {
    private Form form = null;
    private Boolean started = false;

    public Review() {
        Stage secondStage = new Stage();// general field/label/text field/button setup in a grid pane
        GridPane grid = new GridPane();
        Button next = new Button("Next");
        Button submit = new Button("Submit");
        TextField fullName = new TextField();
        TextField PID = new TextField();
        TextField DOB = new TextField();
        TextField relation = new TextField();
        TextField email = new TextField();
        TextField DOD = new TextField();
        TextField relatedPID = new TextField();
        fullName.setStyle("-fx-background-color: white;");
        PID.setStyle("-fx-background-color: white;");
        DOB.setStyle("-fx-background-color: white;");
        relation.setStyle("-fx-background-color: white;");
        email.setStyle("-fx-background-color: white;");
        DOD.setStyle("-fx-background-color: white;");
        relatedPID.setStyle("-fx-background-color: white;");
        Label field1 = new Label("Full Name:");
        Label field2 = new Label("PID:");
        Label field3 = new Label("DOB:");
        Label field4 = new Label("Relation:");
        Label field5 = new Label("email:");
        Label field6 = new Label("DOD:");
        Label field7 = new Label("relatedPID:");
        Label in1 = new Label("");
        Label in2 = new Label("");
        Label in3 = new Label("");
        Label in4 = new Label("");
        Label in5 = new Label("");
        Label in6 = new Label("");
        Label in7 = new Label("");
        Label out1 = new Label("Set Full Name:");
        Label out2 = new Label("Set PID:");
        Label out3 = new Label("Set DOB:");
        Label out4 = new Label("Set Relation:");
        Label out5 = new Label("Set email:");
        Label out6 = new Label("Set DOD:");
        Label out7 = new Label("Set relatedPID:");
        fullName.setPromptText("first middle last");
        PID.setPromptText("111111111");
        DOB.setPromptText("month/day/year");
        relation.setPromptText("relation");
        email.setPromptText("example@domain.com");
        DOD.setPromptText("month/day/year");
        relatedPID.setPromptText("222222222");
        GridPane.setConstraints(next, 0, 0);
        GridPane.setConstraints(next, 1, 0);
        GridPane.setConstraints(field1, 0, 1);
        GridPane.setConstraints(in1, 1, 1);
        GridPane.setConstraints(out1, 2, 1);
        GridPane.setConstraints(fullName, 3, 1);
        GridPane.setConstraints(field2, 0, 2);
        GridPane.setConstraints(in2, 1, 2);
        GridPane.setConstraints(out2, 2, 2);
        GridPane.setConstraints(PID, 3, 2);
        GridPane.setConstraints(field3, 0, 3);
        GridPane.setConstraints(in3, 1, 3);
        GridPane.setConstraints(out3, 2, 3);
        GridPane.setConstraints(DOB, 3, 3);
        GridPane.setConstraints(field4, 0, 4);
        GridPane.setConstraints(in4, 1, 4);
        GridPane.setConstraints(out4, 2, 4);
        GridPane.setConstraints(relation, 3, 4);
        GridPane.setConstraints(field5, 0, 5);
        GridPane.setConstraints(in5, 1, 5);
        GridPane.setConstraints(out5, 2, 5);
        GridPane.setConstraints(email, 3, 5);
        GridPane.setConstraints(field6, 0, 6);
        GridPane.setConstraints(in6, 1, 6);
        GridPane.setConstraints(out6, 2, 6);
        GridPane.setConstraints(DOD, 3, 6);
        GridPane.setConstraints(field7, 0, 7);
        GridPane.setConstraints(in7, 1, 7);
        GridPane.setConstraints(out7, 2, 7);
        GridPane.setConstraints(relatedPID, 3, 7);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.getChildren().addAll(next);
        grid.getChildren().addAll(field1, in1, out1, fullName);// add everything to the grid
        grid.getChildren().addAll(field2, in2, out2, PID);
        grid.getChildren().addAll(field3, in3, out3, DOB);
        grid.getChildren().addAll(field4, in4, out4, relation);
        grid.getChildren().addAll(field5, in5, out5, email);
        grid.getChildren().addAll(field6, in6, out6, DOD);
        grid.getChildren().addAll(field7, in7, out7, relatedPID);
        next.setOnAction(new EventHandler<ActionEvent>() {// next button actions
            @Override
            public void handle(ActionEvent e) {
                if (in1.getText().equals("waiting for new task") || in1.getText().equals("Accepted!") || !started) {
                    // form = new Form(111111111, "1/1/2000", "1/1/2023", "mother",
                    // "john",
                    // "", "doe", "e@mail.com",
                    // 222222222); // will be read from workflow/database once thats ready
                    form = DatabaseManager.fetch(WorkflowManager.info(1));// grab next form in the workflow
                    if (form != null) {
                        if (form.getMiddleName().equals(""))// display all the fields for the reviewer
                            in1.setText(form.getFirstName() + " " + form.getLastName());
                        else
                            in1.setText(form.getFirstName() + " " + form.getMiddleName() + " " + form.getLastName());
                        in2.setText(Long.toString(form.getPID()));
                        in3.setText(form.getDOB());
                        in4.setText(form.getRelation());
                        in5.setText(form.getEmail());
                        in6.setText(form.getDOD());
                        in7.setText(Long.toString(form.getRelatedPID()));
                        if (!started) {
                            grid.getChildren().add(submit);
                            started = true;
                        }
                        fullName.setText("");// reset text fields
                        PID.setText("");
                        DOB.setText("");
                        relation.setText("");
                        email.setText("");
                        DOD.setText("");
                        relatedPID.setText("");
                    } else {// if there is no next form, then wait for next form
                        in1.setText("waiting for new task");
                        in2.setText("waiting for new task");
                        in3.setText("waiting for new task");
                        in4.setText("waiting for new task");
                        in5.setText("waiting for new task");
                        in6.setText("waiting for new task");
                        in7.setText("waiting for new task");
                    }

                }
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {// submit button actions
            @Override
            public void handle(ActionEvent e) {
                if (form != null) {
                    form.isValid();
                    fullName.setStyle("-fx-background-color: white;");// reset field colors
                    PID.setStyle("-fx-background-color: white;");
                    DOB.setStyle("-fx-background-color: white;");
                    relation.setStyle("-fx-background-color: white;");
                    email.setStyle("-fx-background-color: white;");
                    DOD.setStyle("-fx-background-color: white;");
                    relatedPID.setStyle("-fx-background-color: white;");
                    if (fullName.getCharacters().length() != 0) {// code to break down the full name
                        String split[] = fullName.getCharacters().toString().split(" ");
                        switch (split.length) {
                            case 2:
                                form.setFirstName(split[0]);
                                form.setLastName("");
                                form.setLastName(split[1]);
                                break;
                            case 3:
                                form.setFirstName(split[0]);
                                form.setMiddleName(split[1]);
                                form.setLastName(split[2]);
                                break;
                            default:
                                form.setFirstName("");// if invalid input
                        }
                    }
                    if (PID.getCharacters().length() != 0) {// set the pid, make it fail if the input is bad
                        try {
                            form.setPID(Long.parseLong(PID.getCharacters().toString()));
                        } catch (Exception e2) {
                            form.setPID(-1);
                        }
                    }
                    if (DOB.getCharacters().length() != 0) {// split up the date of birth, make it invalid if improperly
                                                            // formatted
                        try {
                            String split2[] = DOB.getCharacters().toString().split("/");
                            Integer.valueOf(split2[0]);
                            Integer.valueOf(split2[1]);
                            Integer.valueOf(split2[2]);
                            form.setDOB(DOB.getCharacters().toString());
                        } catch (Exception e3) {
                            form.setDOB("0/0/0000");
                        }
                    }
                    if (relation.getCharacters().length() != 0) {// set relation
                        form.setRelation(relation.getCharacters().toString());
                    }
                    if (email.getCharacters().length() != 0) {// set email
                        form.setEmail(email.getCharacters().toString());
                    }
                    if (DOD.getCharacters().length() != 0) {// set the date of death
                        try {
                            String split2[] = DOD.getCharacters().toString().split("/");
                            Integer.valueOf(split2[0]);
                            Integer.valueOf(split2[1]);
                            Integer.valueOf(split2[2]);
                            form.setDOD(DOD.getCharacters().toString());
                        } catch (Exception e4) {
                            form.setDOD("0/0/0000");
                        }
                    }
                    if (relatedPID.getCharacters().length() != 0) {// set the related pid
                        try {
                            form.setRelatedPID(Long.parseLong(relatedPID.getCharacters().toString()));
                        } catch (Exception e2) {
                            form.setRelatedPID(-1);
                        }
                    }
                    // System.out.println(Long.parseLong("test"));
                    Boolean lock = false;
                    Boolean fails[] = form.getFail();// fail = [PID, DOB, relation, firstname, middlename, lastname,
                                                     // email,
                                                     // relatedPID, DOD]
                    for (int i = 0; i < 9; i++) {// if any of the fields are invalid, change the field background to red
                                                 // to indicate that they need changed
                        switch (i) {
                            case 0:
                                if (fails[i]) {
                                    lock = true;
                                    PID.setStyle("-fx-background-color: red;");
                                }
                                break;
                            case 1:
                                if (fails[i]) {
                                    lock = true;
                                    DOB.setStyle("-fx-background-color: red;");
                                }
                                break;
                            case 2:
                                if (fails[i]) {
                                    lock = true;
                                    relation.setStyle("-fx-background-color: red;");
                                }
                                break;
                            case 3:
                            case 4:
                            case 5:
                                if (fails[i]) {
                                    lock = true;
                                    fullName.setStyle("-fx-background-color: red;");
                                }
                                break;
                            case 6:
                                if (fails[i]) {
                                    lock = true;
                                    email.setStyle("-fx-background-color: red;");
                                }
                                break;
                            case 7:
                                if (fails[i]) {
                                    lock = true;
                                    relatedPID.setStyle("-fx-background-color: red;");
                                }
                                break;
                            case 8:
                                if (fails[i]) {
                                    lock = true;
                                    DOD.setStyle("-fx-background-color: red;");
                                }
                                break;
                        }
                    }
                    if (!lock) {// if everything is valid accept the form
                        in1.setText("Accepted!");
                        in2.setText("Accepted!");
                        in3.setText("Accepted!");
                        in4.setText("Accepted!");
                        in5.setText("Accepted!");
                        in6.setText("Accepted!");
                        in7.setText("Accepted!");
                        WorkflowManager.update(1, form.getFID());// push up in the workflow
                        DatabaseManager.update(form);// save the changes to the form
                        // System.out.println(form.getFID());
                        form = null;// prep for next form

                        // will check if the data is valid, then upload
                        // to the wf table/database
                    }
                }
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
        secondStage.setScene(new Scene(grid, 500, 300));// make gui window

        secondStage.show();
    }
}