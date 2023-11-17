/**
 * File Name: PAssign07.java
 * Class: CSCI 1302
 * Author: Stella Pham
 * Created on: Nov 5, 2023
 * Last Modified: Nov 17, 2023
 * Description: JavaFX GUI designed to look like a keypad    
 * Hello-World GitHub Link: https://github.com/tp13828/hello-world.git
 */

package keypad;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.geometry.*;

public class PAssign07 extends Application {
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

		//Add/Change Problem Label
		lblProblem.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
		lblProblem.setPrefSize(800, 100);
		lblProblem.setAlignment(Pos.TOP_CENTER);

		//Add elements to borderpane
		borderPane.setCenter(keyPane);
		borderPane.setTop(lblProblem);
		borderPane.setBottom(txtAnswer);

		//Set scene and show
		Scene scene = new Scene(borderPane, 1000, 700);
		primaryStage.setTitle("KeyPad");
		primaryStage.setScene(scene);
		primaryStage.show();

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
