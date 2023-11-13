/**
 * File Name: PAssign07.java
 * Class: CSCI 1302
 * Author: Stella Pham
 * Created on: Oct 26, 2023
 * Last Modified: Oct 27, 2023
 * Description: JavaFX GUI designed to look like a keypad    
 */

package keypad;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.geometry.*;

public class PAssign07 extends Application {
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		KeyPadPane keyPane = new KeyPadPane();

		Scene scene = new Scene(borderPane, 800, 800);
		primaryStage.setTitle("KeyPad");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}

class KeyPadUpgrade extends KeyPadPane {
	public KeyPadUpgrade() {
		
	}
}
