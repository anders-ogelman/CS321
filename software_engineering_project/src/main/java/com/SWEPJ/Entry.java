package com.SWEPJ;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Entry {
	public Entry() {

		Label firstNameLabel = new Label("First Name:");
		TextField firstNameField = new TextField();

		Label middleNameLabel = new Label("Middle Name:");
		TextField middleNameField = new TextField();

		Label lastNameLabel = new Label("Last Name:");
		TextField lastNameField = new TextField();

		Label emailLabel = new Label("Email:");
		TextField emailField = new TextField();

		Label dobLabel = new Label("Date of Birth:");
		TextField dobField = new TextField();

		Label dodLabel = new Label("Date of Death:");
		TextField dodField = new TextField();

		Stage secondStage = new Stage();

		VBox entryBox = new VBox(4, new Label("Entry Window"));
		entryBox.getChildren().addAll(firstNameLabel, firstNameField, middleNameLabel, middleNameField, lastNameLabel,
				lastNameField, emailLabel, emailField, dobLabel, dobField, dodLabel, dodField);

		Scene entryScene = new Scene(entryBox);
		secondStage.setScene(entryScene);
		secondStage.show();
	}
}
