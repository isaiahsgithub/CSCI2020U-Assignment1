/*
 * Gagandeep Pabla (100655179) and Isaiah von Uders (100655186)
 * Assignment 1 - Question 3
 * Due March 6th, 2019 by 11:59 PM
 * AssingnmentPt3.java
 * This program lets the user move around circles to form a triangle
 * the program will display the lines for the triangle and angles
 */
package assignmentpt3;

//These are the libraries that we will be using in the program

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.lang.Object;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;


/**
 *
 * @author G
 */
public class AssignmentPt3 extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Creates the pane that we will be display the program on
        Pane pane = new Pane();
        //Creates new circles that will mark the points on the triangle
        Circle circle = new Circle(100,50,10);
        Circle circle2 = new Circle(50,100,10);
        Circle circle3 = new Circle(80,220,10);

        //Creates a bigger cirlce that will be the track for the smaller circles to move along on
        Circle circle4 = new Circle(140,140,100);

        //Sets the stroke color of the small circles
        circle.setStroke(Color.BLACK);
        circle2.setStroke(Color.BLACK);
        circle3.setStroke(Color.BLACK);

        //Fills the smaller cirlces with color
        circle.setFill(Color.RED);
        circle2.setFill(Color.RED);
        circle3.setFill(Color.RED);

        //Sets the stroke color of bigger circle and fills it
        circle4.setStroke(Color.BLACK);
        circle4.setFill(Color.WHITE);

        //These next two lines will add the circles to the pane
        pane.getChildren().add(circle4);
        pane.getChildren().addAll(circle,circle2,circle3);


    Scene scene = new Scene(pane, 300, 300);

    primaryStage.setTitle("Question 3");
    primaryStage.setScene(scene);
    primaryStage.show();


    //These next few lines create the line variables and text variables that we will use to display the lines and angles between the circles to form a triangle
    Line line1 = new Line();
    Line line2 = new Line();
    Line line3 = new Line();
    Text text1 = new Text();
    Text text2 = new Text();
    Text text3 = new Text();


                //Initializes Line to be displayed when program is opened

                line1.setStartX(circle.getCenterX());
                line1.setStartY(circle.getCenterY());
                line1.setEndX(circle2.getCenterX());
                line1.setEndY(circle2.getCenterY());
                line3.setStartX(circle.getCenterX());
                line3.setStartY(circle.getCenterY());
                line3.setEndX(circle3.getCenterX());
                line3.setEndY(circle3.getCenterY());

                //Initializes line to be displayed when program is opened

                line1.setStartX(circle.getCenterX());
                line1.setStartY(circle.getCenterY());
                line1.setEndX(circle2.getCenterX());
                line1.setEndY(circle2.getCenterY());
                line2.setStartX(circle2.getCenterX());
                line2.setStartY(circle2.getCenterY());
                line2.setEndX(circle3.getCenterX());
                line2.setEndY(circle3.getCenterY());


                //Initializes line to be displayed when program is opened

                line3.setStartX(circle.getCenterX());
                line3.setStartY(circle.getCenterY());
                line3.setEndX(circle3.getCenterX());
                line3.setEndY(circle3.getCenterY());
                line2.setStartX(circle2.getCenterX());
                line2.setStartY(circle2.getCenterY());
                line2.setEndX(circle3.getCenterX());
                line2.setEndY(circle3.getCenterY());

    //adds the lines and text to the pane
    pane.getChildren().addAll(line1,line3,line2,text1,text2,text3);

    //When user clicks on circle 1
    circle.setOnMouseDragged(e -> {
         if (circle.contains(e.getX(), e.getY())) {
             
              
                //Updates X and Y values for the lines connected to circle 1
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
                line1.setStartX(circle.getCenterX());
                line1.setStartY(circle.getCenterY());
                line1.setEndX(circle2.getCenterX());
                line1.setEndY(circle2.getCenterY());
                line3.setStartX(circle.getCenterX());
                line3.setStartY(circle.getCenterY());
                line3.setEndX(circle3.getCenterX());
                line3.setEndY(circle3.getCenterY());
                
               //These next few lines will make sure the smaller circle stays on the big circle 
               double s = e.getX() - circle4.getCenterX();
               double p = e.getY() - circle4.getCenterY(); 
               double j = Math.sqrt(Math.pow(s, 2) + Math.pow(p,2));
               
               double k = (s/ j);
               double a = (p/j); 
               
              
               double h = circle4.getRadius();
               
               circle.setCenterX((h*k)+ circle4.getCenterX());
               circle.setCenterY((h*a)+ circle4.getCenterY());
               
               //This calls a function that will obtain the angles for the triangle
               getNumbers(circle, circle2, circle3, text1,text2,text3);
              
               
               
         }

        });

    circle2.setOnMouseDragged(e -> {
         if (circle2.contains(e.getX(), e.getY())) {
                //Updates X and Y values for the lines connected to circle 1
                circle2.setCenterX(e.getX());
                circle2.setCenterY(e.getY());
                line1.setStartX(circle.getCenterX());
                line1.setStartY(circle.getCenterY());
                line1.setEndX(circle2.getCenterX());
                line1.setEndY(circle2.getCenterY());
                line2.setStartX(circle2.getCenterX());
                line2.setStartY(circle2.getCenterY());
                line2.setEndX(circle3.getCenterX());
                line2.setEndY(circle3.getCenterY());
                
                //These next few lines will make sure the smaller circle stays on the big circle 
               double s = e.getX() - circle4.getCenterX();
               double p = e.getY() - circle4.getCenterY(); 
               double j = Math.sqrt(Math.pow(s, 2) + Math.pow(p,2));
               
               double k = (s/ j);
               double a = (p/j); 
               
              
               double h = circle4.getRadius();
               
               circle2.setCenterX((h*k)+ circle4.getCenterX());
               circle2.setCenterY((h*a)+ circle4.getCenterY());
                
                //This calls a function that will obtain the angles for the triangle
                getNumbers(circle, circle2, circle3, text1,text2,text3);
         }

        });


      circle3.setOnMouseDragged(e -> {
         if (circle3.contains(e.getX(), e.getY())) {
                //Updates X and Y values for the lines connected to circle 1
                circle3.setCenterX(e.getX());
                circle3.setCenterY(e.getY());
                line3.setStartX(circle.getCenterX());
                line3.setStartY(circle.getCenterY());
                line3.setEndX(circle3.getCenterX());
                line3.setEndY(circle3.getCenterY());
                line2.setStartX(circle2.getCenterX());
                line2.setStartY(circle2.getCenterY());
                line2.setEndX(circle3.getCenterX());
                line2.setEndY(circle3.getCenterY());
                
               //These next few lines will make sure the smaller circle stays on the big circle 
               double s = e.getX() - circle4.getCenterX();
               double p = e.getY() - circle4.getCenterY(); 
               double j = Math.sqrt(Math.pow(s, 2) + Math.pow(p,2));
               
               double k = (s/ j);
               double a = (p/j); 
               
              
               double h = circle4.getRadius();
               
               circle3.setCenterX((h*k)+ circle4.getCenterX());
               circle3.setCenterY((h*a)+ circle4.getCenterY());
                
                //This calls a function that will obtain the angles for the triangle
                getNumbers(circle, circle2, circle3, text1,text2,text3);

         }

        });




    }

    //This function will obtain the angles for the triangle
    public void getNumbers(Circle circle, Circle circle2, Circle circle3,Text text1, Text text2, Text text3){

        double a = new Point2D(circle3.getCenterX(), circle3.getCenterY()).distance(circle2.getCenterX(),circle2.getCenterY());
        double b = new Point2D(circle3.getCenterX(), circle3.getCenterY()).distance(circle.getCenterX(),circle.getCenterY());
        double c = new Point2D(circle.getCenterX(), circle.getCenterY()).distance(circle2.getCenterX(),circle2.getCenterY());


        double[] angle = new double[3];
        //Math calculation to get agnles
        angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));

        angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));

        angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));


        //sets text to correspodning angles
        text1.setText(String.format("%.2f", Math.toDegrees(angle[0])));
        text2.setText(String.format("%.2f", Math.toDegrees(angle[1])));
        text3.setText(String.format("%.2f", Math.toDegrees(angle[2])));

        //These next few lines will position the text lables to display the angles
        text1.setX(circle.getCenterX());
        text1.setY(circle.getCenterY() - 25);

        text2.setX(circle2.getCenterX());
        text2.setY(circle2.getCenterY() - 25);

        text3.setX(circle3.getCenterX());
        text3.setY(circle3.getCenterY() - 25);






    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
