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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
public class Approve {
	private Form form = null; //form to load
    public Approve() {
    	//System.out.println("Hello World!");
    	
    	//Fields
    	
    	//FIRST NAME
    	Label lblNF = new Label("First Name");
    	TextField txfNF = new TextField();
    	txfNF.setEditable(false);
    	//MIDDLE NAME
    	Label lblNM = new Label("Middle Name");
    	TextField txfNM = new TextField();
    	txfNM.setEditable(false);
    	//LAST NAME
    	Label lblNL = new Label("Last Name");
    	TextField txfNL = new TextField();
    	txfNL.setEditable(false);
    	//EMAIL
    	Label lblEmail = new Label("email");
    	TextField txfEmail = new TextField();
    	txfEmail.setEditable(false);
    	//DOB
    	Label lblDOB = new Label("DOB:");
    	TextField txfDOB = new TextField();
    	txfDOB = new TextField();
    	//DOD
    	Label lblDOD = new Label("DOD:");
    	TextField txfDOD = new TextField();
    	txfDOD.setEditable(false);
    	
    	Label lblHdr1 = new Label("Incoming Form");
    	lblHdr1.setAlignment(Pos.TOP_CENTER);
    	
    	VBox boxForm = new VBox(4, lblHdr1);
    	boxForm.setPadding(new Insets(25, 25, 25, 25));
    	boxForm.setAlignment(Pos.CENTER);
    	boxForm.getChildren().addAll(lblNF, txfNF,lblNM,txfNM,lblNL,txfNL, lblDOB,txfDOB, lblDOD, txfDOD);
    	//End Fields
    	
    	//Buttons
    	
    	Button butDeny = new Button("Deny");
    	butDeny.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
    			System.out.println("Denied something!!");
    		}
    	});
    	
    	
    	Button butLoadNext = new Button("Load Next");
    	//butLoadNext.setDisable(true); //look into this
    	butLoadNext.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
    			System.out.println("Wanted to Load something!!");
    		}
    	});
    	
    	Button butApprove = new Button("Approve");
    	butApprove.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
    			System.out.println("Approved something!!");
    		}
    	});
    	
    	VBox boxButtons = new VBox(5, new Label("Control"));
    	boxButtons.setPadding(new Insets(25, 25, 25, 25));
    	boxButtons.setAlignment(Pos.CENTER);
    	boxButtons.getChildren().addAll(butDeny,butLoadNext,butApprove);
    	//End Buttons
    	
    	//boilerplate
    	HBox boxScreen = new HBox(8, new Label(""));
    	boxScreen.setAlignment(Pos.CENTER);
    	boxScreen.getChildren().addAll(boxButtons, boxForm);
    	
    	Stage secondStage = new Stage();
    	secondStage.setTitle("Data Approval");
        secondStage.setScene(new Scene(boxScreen));
        secondStage.show();
    }
}