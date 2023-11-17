/**
 * File Name: PAssign08.java
 * Class: CSCI 1302
 * Author: Stella Pham
 * Created on: Nov 17, 2023
 * Last Modified: Nov 17, 2023
 * Description: JavaFX GUI that asks you to enter the first 7 digits of PI   
 * Hello-World GitHub Link: https://github.com/tp13828/hello-world.git
 */

package keypad;

import java.util.ArrayList;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.geometry.*;

public class PAssign08 extends Application {
	private TextField txtAnswer = new TextField();
	private Label lblProblem = new Label("What are the first 7 digits of PI?");

	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color:#fcffff");
		KeyPadPane keyPane = new KeyPadCustomPane();
		keyPane.setAlignment(Pos.CENTER);

		//Add/Change Answer TextField
		txtAnswer.setAlignment(Pos.BOTTOM_CENTER);
		txtAnswer.setPrefSize(800, 100);
		txtAnswer.setEditable(false);
		txtAnswer.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

		//Add/Change Problem Label
		lblProblem.setAlignment(Pos.TOP_CENTER);
		lblProblem.setTextAlignment(TextAlignment.CENTER);
		lblProblem.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		lblProblem.setPrefSize(800, 100);

		//Add elements to borderpane
		borderPane.setCenter(keyPane);
		borderPane.setTop(lblProblem);
		borderPane.setBottom(txtAnswer);
		
		//Set Button Interaction
		for (int i = 0; i < keyPane.listButtons.size(); i++) {
			keyPane.listButtons.get(i).setOnAction(e -> {
				if (!e.getSource().equals(keyPane.btnBlank2)) {
				txtAnswer.setText(txtAnswer.getText() + ((Button)e.getSource()).getText());
				} else {
					checkAnswer();
				}
			});
		}

		//Set scene and show
		Scene scene = new Scene(borderPane, 1000, 700);
		primaryStage.setTitle("KeyPad");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	//Check Answer Method
	private void checkAnswer() {
		if (txtAnswer.getText().equals("3.141592")) {
			lblProblem.setText("Correct!");
		} else {
			lblProblem.setText("Incorrect, try again.");
			txtAnswer.clear();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

//Custom Keypad Upgrade
class KeyPadCustomPane extends KeyPadPane {
	public KeyPadCustomPane() {
		// Change Button Visuals
		for (int i = 0; i < listButtons.size(); i++) {
			listButtons.get(i).setPrefSize(120, 120);
			listButtons.get(i).setStyle("-fx-background-color:#e3fcff; -fx-border-color: black;");
			listButtons.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		}

		// Change Blank Buttons
		btnBlank1.setText(".");
		btnBlank2.setText("=");
	}
}
