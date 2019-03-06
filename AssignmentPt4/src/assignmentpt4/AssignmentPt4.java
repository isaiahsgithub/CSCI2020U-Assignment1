/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentpt4;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.collections.*;
import javafx.geometry.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.*;

public class AssignmentPt4 extends Application {

    @Override
    public void start(Stage primaryStage){

        //Creates a new BorderPane
        BorderPane grid = new BorderPane();

        //Creates a new HBox
        HBox theHB = new HBox(15);

        //Creates a new label informing the user the filename goes here
        Label lbl = new Label("Filename: ");

        //Creates a new textField, with a width of 382
        TextField fileInput = new TextField("");
        fileInput.setPrefWidth(382);

        //Creates a new button that says View
        Button btnRead = new Button("View");

        //Creates a new label with no text
        Label lbl2 = new Label("");


        //When the button is clicked
        btnRead.setOnAction(e -> {

            //Create a new string called file name
            String filename = "";

            //Get the text from the textfield
            filename = fileInput.getText();

            try {
                //Pass the file name and the grid to the ScanFile function
                ScanFile(filename, grid);
            } catch (IOException ex) {
                //Catch any errors
                Logger.getLogger(AssignmentPt4.class.getName()).log(Level.SEVERE, null, ex);

                //Put the errors in the textfield for the user to view.
                //fileInput.setText(ex.toString());

                //Inform the user of any errors at the top of the BorderPane (will be removed after a successful build)
                lbl2.setText(ex.toString());
                grid.setTop(lbl2);
            }


        });

        //Add the label, textfield, and button to the HBox
        theHB.getChildren().addAll(lbl, fileInput,btnRead);

        //Add the HBox to the bottom of the BorderPane
        grid.setBottom(theHB);

        //Create a new scene, pass it the border pane, assign dimensions of 500x450
        Scene scene = new Scene(grid, 500, 450);

        //Set the title of the stage (at the top)
        primaryStage.setTitle("Question 4");

        //Pass the scene to the stage
        primaryStage.setScene(scene);

        //Prevents resizing
        primaryStage.setResizable(false);

        //Shows the stage
        primaryStage.show();
    }


    //Scan file function, checks for any IO errors
    public void ScanFile(String theFile, BorderPane g)  throws java.io.IOException{
            java.io.File file = new java.io.File(theFile);                          //Declaring the file
            Scanner sc = new Scanner(file);                                         //Using scanner to scan through the file
            int[] theArray = new int[26];                                           //New array that stores each letter
            String largeFile = "";                                                  //String that will store the text in the file
             while(sc.hasNext()){                                                   //Loop through the entire file
                largeFile += sc.next();                                             //Append the text in the file to the String
             }
            largeFile = largeFile.toLowerCase();                                    //Set everything to lowercase (easier for later)
            for(int i =0; i<largeFile.length(); i++){                               //Loop through the entire string
                char theChar = largeFile.charAt(i);                                 //Get the char at every position in the string
                int a = (int) theChar;                                              //Turn the char into an int
                a = a-97;                                                           //Turn the int ascii value, into a numerical range from 0-25 (97-123) is the range for lowercase ascii values
                theArray[a] +=1;                                                    //Add 1 to each letter location
            }
            CategoryAxis xAxis = new CategoryAxis();                                //New xAxis
            xAxis.setLabel("Letter");                                               //Label for the xAxis is Letter
            NumberAxis yAxis = new NumberAxis();                                    //New yAxis
            yAxis.setLabel("Times Appeared");                                       //Label for the yAxis is Times Shown
            BarChart theChart = new BarChart(xAxis, yAxis);                         //Make a new Bar Chart, with the xAxis and the yAxis

            XYChart.Series set1 = new XYChart.Series<>();                           //New set that will contain the data points


            for (int j=0; j<theArray.length; j++){                                  //Loop through the array (every letter in the alphabet)
                int i = j+97;                                                       //Get the ASCII values again(97-123)
                char theChar = (char) i;                                            //Turn it back into a char
                String charAsString = Character.toString(theChar);                  //Turn the char into a String
                set1.getData().add(new XYChart.Data(charAsString, theArray[j]));
                //Add each letter to the set
                }
            
            set1.setName("Amount of Times Letters Appeared");
            //Add the set to the chart
            theChart.getData().add(set1);
            

            //set the top of the BorderPane to be theChart
            g.setTop(theChart);

            //Close the file
            sc.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
