/*
 * Gagandeep Pabla (100655179) and Isaiah von Uders (100655186)
 * Assignment 1 - Question 1
 * Due March 6th, 2019 by 11:59 PM
 * AssingmentPt1.java
 * This program randomly generates 3 numbers, and depending on the numbers
 * chosen, the program will display a card to match the number.
 * Basically, it randomly generates 3 cards, that are stored in 3 labels,
 * and they are shown in the frame.
 */
package assingmentpt1;

import javafx.application.Application;                                          //Librarys used
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;
/**
 *
 * @author G
 */
public class AssingmentPt1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Creates a new GridPane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        //Sets horizontal spacing
        pane.setHgap(5.5);

        //Sets vertical spacing
        pane.setVgap(5.5);

        //Creates 3 new random numbers
        int result = new Random().nextInt((54) + 1);
        int result2 = new Random().nextInt((54) + 1);
        int result3 = new Random().nextInt((54) + 1);

        //Opens 3 cards depending on what random integers were received from the previous 3 lines of code.
        //E.g. if 3,6,9 were the random numbers pulled, then the cards opened will be the 3rd, 6th, and 9th card
        //Place these 3 cards in a ImageView, which allows the program to display the cards (after appended to the grid)
        ImageView c1 = new ImageView(new Image("file:///C:\\coding\\csci2020u\\Assignment1\\AssingmentPt1\\src\\assingmentpt1\\Cards/" + String.valueOf(result) + ".png"));
        ImageView c2 = new ImageView(new Image("file:///C:\\coding\\csci2020u\\Assignment1\\AssingmentPt1\\src\\assingmentpt1\\Cards/" + String.valueOf(result2) + ".png"));
        ImageView c3 = new ImageView(new Image("file:///C:\\coding\\csci2020u\\Assignment1\\AssingmentPt1\\src\\assingmentpt1\\Cards/" + String.valueOf(result3) + ".png"));

        //Add each card to the gridpane (so they appear)
        pane.add(c1,2,0);
        pane.add(c2,4,0);
        pane.add(c3,6,0);

    //Add the gridpane(pane) to the scene
    Scene scene = new Scene(pane, 300, 125);

    //Set the title of the stage to "Question 1"
    primaryStage.setTitle("Question 1");

    //Add the scene to the stage
    primaryStage.setScene(scene);

    //Show the stage
    primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //When the code is executed, launch the program
        launch(args);
    }

}
