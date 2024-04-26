package com.SWEPJ;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


//plan: accepting input, use it to create a form, call the requisite method from database manager

public class Entry {
	public Entry() {
		
		//setting up form UI elements
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

		Label pidLabel = new Label("PID: ");
		TextField pidField = new TextField();

		Label relationLabel = new Label("Relation: ");
		TextField relationField = new TextField();

		Label relationPIDLabel = new Label("RelationPID: ");
		TextField relationPIDField = new TextField();

		Label validationLabel = new Label("");
	
		Button submitButton = new Button("Submit");

		//handling form submission
		EventHandler<ActionEvent> submitForm = new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				//debug message
				System.out.println("pressed button!");
				
				//putting them all in variables to make validation easier down the line
				long pid;
				try {
					pid = Long.parseLong(pidField.getText());
				} catch (NumberFormatException err) {
					pid = -1; 
				}
				String dob = dobField.getText();
				String dod = dodField.getText();
				String firstName = firstNameField.getText();
				String middleName = middleNameField.getText();
				String lastName = lastNameField.getText();
				String email = emailField.getText();
				String relation = relationField.getText();
				long relationPID;
				try {
					relationPID = Long.parseLong(relationPIDField.getText());
				} catch (NumberFormatException err) {
					relationPID = -1;
				}

				
				//TODO: add in basic validation, figure out what to do
				Form submissionForm = new Form(pid, dob, dod, relation, firstName, middleName, lastName, email, relationPID);
				//validation and display if the form isn't valid
				submissionForm.isValid();
				Boolean[] isValidArr = submissionForm.getFail();
				String[] fieldsArr = {"PID", "DOB", "relation", "firstname", "middlename", "lastname", "email", "relatedPID", "DOD"};
				String invalids = "";
				
				boolean validationPassed = true;

				for(int i = 0; i < isValidArr.length; i++) {
					if(!isValidArr[i]) {
						if(validationPassed) {
							invalids = invalids + "Invalid entries in: ";
						}
						invalids = invalids + fieldsArr[i] + ", ";
						validationPassed = false;
					}
				}
				
				if(validationPassed) {
					
					validationLabel.setText("");

					firstNameField.setText("");
					middleNameField.setText("");
					lastNameField.setText("");
					emailField.setText("");
					dobField.setText("");
					dodField.setText("");
					pidField.setText("");
					relationField.setText("");
					relationPIDField.setText("");

					//Adding new form to the database, method also sets submissionForm FID
					DatabaseManager.update(submissionForm);
					//updating the workflow table
					WorkflowManager.update(0, submissionForm.getFID());

				} else {
					validationLabel.setText(invalids);
				}


			}

		};

		submitButton.setOnAction(submitForm);
		
		//JavaFx UI VBox layout setup
		Stage secondStage = new Stage();

		VBox entryBox = new VBox(4, new Label("Entry Window"));
		entryBox.getChildren().addAll(firstNameLabel, firstNameField, middleNameLabel, middleNameField, lastNameLabel,
				lastNameField, emailLabel, emailField, dobLabel, dobField, dodLabel, dodField, pidLabel, pidField, relationLabel, relationField, relationPIDLabel, relationPIDField, submitButton, validationLabel);

		
		//adding the layout to the screen and rendering
		Scene entryScene = new Scene(entryBox);
		secondStage.setScene(entryScene);
		secondStage.show();
	}

}
