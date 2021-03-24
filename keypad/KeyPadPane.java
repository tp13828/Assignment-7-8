package keypad;
/**
 * File: csci1302/keypad/KeyPadPane.java
 * Package: keypad
 * @author Christopher Williams
 * Created on: Mar 02, 2020
 * Description:  Extended GridPane that creates a KeyPad with either an ATM or phone-esque 
 * 				 Button arrangement
 */

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class KeyPadPane extends GridPane {
	// private Buttons 
	private Button btn1 = new Button("1");
	private Button btn2 = new Button("2");
	private Button btn3 = new Button("3");
	private Button btn4 = new Button("4");
	private Button btn5 = new Button("5");
	private Button btn6 = new Button("6");
	private Button btn7 = new Button("7");
	private Button btn8 = new Button("8");
	private Button btn9 = new Button("9");
	private Button btnBlank1 = new Button("  ");
	private Button btn0 = new Button("0");
	private Button btnBlank2 = new Button("  ");
	private Button btnAsterisk = new Button("*");
	private Button btnPound = new Button("#");
	
	// collect all buttons
	private Button[] arrButtons = { btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnBlank1, btn0, btnBlank2};
	private ArrayList<Button> listButtons = new ArrayList<>(Arrays.asList(arrButtons));

	/** 
	 * Create a default KeyPadPane with numbers in order, includes 2 blanks around 0
	 */
	public KeyPadPane() {
		// counter for ArrayList elements
		int counter = 0;
		
		// place all buttons in 1-9, blank, 0, blank order, 3 per row
		for (int i = 0; i < listButtons.size() / 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.add(listButtons.get(counter++), j, i);
			}
		}
	}
	
	/** 
	 * Create a KeyPadPane with phone order buttons
	 * @param phoneOrder specify that the user wants phone keypad layout of buttons, 
	 * 		if they use true here, use default layout
	 */
	public KeyPadPane(boolean phoneOrder) {
		// default to default layout for someone choosing false
		this();
		
		// now check if they want a phone layout
		if (phoneOrder) {
			// get rid of default layout
			this.getChildren().clear();
			
			// clone list and replace blanks
			ArrayList<Button> copyListButtons = (ArrayList<Button>)listButtons.clone();
			copyListButtons.set(copyListButtons.size() - 3, btnAsterisk);
			copyListButtons.set(copyListButtons.size() - 1, btnPound);
			
			// counter start at last numeric button index
			int counter = copyListButtons.size() - 4;
			
			// place all buttons in 9-1, 3 per row
			for (int i = 0; i < (copyListButtons.size() - 3) / 3; i++) {
				for (int j = 0; j < 3; j++) {
					this.add(copyListButtons.get(counter--), j, i);
				}
			}
			
			// reset counter
			counter = copyListButtons.size() - 1;
			// manually add the blank, 0, blank order
			for (int i = 2; i >= 0; i--) {
				this.add(copyListButtons.get(counter--), i, 3);
			}
		} 
	}

}
