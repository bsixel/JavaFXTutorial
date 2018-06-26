package application;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Some really helpful tutorial stuff and hints: http://www.java2s.com/Tutorials/Java/JavaFX/index.htm
 * 
 * Basics:
 * * All UI elements extend Node, including layouts.
 * * All layouts (such as VBox and HBox) extend Group.
 * * All elements can have their color, size, and other appearance characteristics changed, either through CSS styling or hard coding.
 * * Supports things such as media display and a variety of HTML5 features. Can also integrate AWT graphics if desired.
 * * More than just node styling can be handled in CSS files - also event handling.
 * 
 */
public class JFXTester extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {	//Stages is the window, scene is the... Scene?
		
		VBox root = new VBox(10);	//Vertical box layout, spacing of 10 between UI items.
		
		Scene scene = new Scene(root, 300, 300);	//Scene - the screen you are seeing; items and layout, etc. Takes in the layout used for displaying nodes, and the size of the scene. Both can be changed later.
		Random random = new Random();
		String str = "Click me!" + new Character((char) (random.nextInt(91-65) + 65));
		
		Button clickButton = new Button(str);	//Size of the button is relative to the text it has. Can also have an image.
		
		root.getChildren().add(clickButton);	//Add the button to the root layout.
		
		clickButton.setOnAction(c -> {	//Lambda usage! Java 8 thing to simplify methods within methods. Check out http://www.java2s.com/Tutorials/Java/Java_Lambda/index.htm
			if (clickButton.getText().equals("click me")) {
				clickButton.setText("I've been clicked!");	//On being clicked, the button sets the text within it to this message.
				root.setStyle("-fx-background-color: RED"); //Set the background color of the layout to be red. Can also use web hex colors. This sort of thing is normally done in a CSS file used for the entire application.
			} else {
				clickButton.setText("click me");	//On being clicked, the button sets the text within it to this message.
				root.setStyle("-fx-background-color: BLUE"); //Set the background color of the layout to be blue. Can also use web hex colors. This sort of thing is normally done in a CSS file used for the entire application.
			}	//Button size readjusts when the size of the text changes.
		});
		
		/* This below is what the above action handler would look like without Java 8's lambdas.
		clickButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	clickButton.setText("I've been clicked!");
            }
        });
        */
		
		primaryStage.setScene(scene);	//Sets the current scene (viewable stuff) to the scene with the button.
		
		primaryStage.show();	//Show the stage (window).
		
	}

	public static void main(String[] args) {
		launch(args);		//Not necessary once compiled, but eclipse complains when it's not here. Simply calls the star method.
	}						//The args are the arguments given to the application when launched from a console. Can be used later with Application.getParameters();

}
