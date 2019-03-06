/*
 * Gagandeep Pabla (100655179) and Isaiah von Uders (100655186)
 * Assignment 1 - Question 2
 * Due March 6th, 2019 by 11:59
 * AssignmentPt2.java
 * This program calculates the future value of an investment, given a specific
 * interest rate, for a specific number of years. This is calculated via the formula:
 * futureValue = investmentAmount * (1 + monthlyInterestRate)^(years*12)
 */
package assignmentpt2;

//These are the libraries that we will be using in the program
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import java.util.*;

/**
 *
 * @author G
 */
public class AssignmentPt2 extends Application {

    @Override
    public void start(Stage primaryStage) {
       //This creates the button that the user can press to calculate the total
       Button btn = new Button();

       //Displays text for button
        btn.setText("Calculate");

        //These are the textFields that we will be using for our program
        //Each textField is named after the kind of information the user needs to enter
        TextField investAmo = new TextField();
        TextField years = new TextField();
        TextField interest = new TextField();
        TextField futValue = new TextField();

        //When the user clicks on the calculate button this action will occur
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Gets the interger value of investment amount
                int amount = Integer.valueOf(investAmo.getText());

                // Gets the integer value of the Year
                int time = Integer.valueOf(years.getText());

                //Gets the interest rate that was entered by the user
                double interestRate = Double.valueOf(interest.getText());

                // Creates variable that will be the value of the customers investment after year and interest rates are applied
                double futureValue;

                // These next two variables will be used for the math calculation
                double math1 = 1 + (interestRate/1200);
                int math2 = time * 12;

                // Math calculation
                futureValue = amount * Math.pow(math1,math2);

                // Displays the total amount to user after calculation is complete
                futValue.setText(String.valueOf(futureValue));
              }

        });

        //GridPane will be the pane that we use for this program
        GridPane root = new GridPane();

        //These next few lines will set the padding, horizontal gap and vertical gap for the GridPane
        root.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        root.setHgap(5.5);
        root.setVgap(5.5);

        //Adds the button to the pane
        root.add(btn, 0,7);

        //These next few lines will add text to the program that will show the user what each textField does
        root.add(new Text("Investment Amount:"),0,0);
        root.add(new Text("Years:"),0,1);
        root.add(new Text("Annual Interest Rate:"),0,2);
        root.add(new Text("Future Value:"),0,3);

        //These next few lines will add the textField to the program
        root.add(investAmo,2,0);
        root.add(years,2,1);
        root.add(interest,2,2);
        root.add(futValue,2,3);

        //Creates a new Scene that has the dimensions 300 by 250, and passes it root(a gridpane)
        Scene scene = new Scene(root, 300, 250);

        //Sets the title of the stage to "Investment Calculator"
        primaryStage.setTitle("Investment Calculator");

        //Add the scene to the stage
        primaryStage.setScene(scene);

        //Shows the stage
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
