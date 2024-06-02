package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;

import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Controller class for the image button example.
 *
 * @author Karsten Lehn
 * @version 5.4.2021
 */
public class Controller implements Initializable {
    // Local instance variables for handling input states
    private boolean imageOn = false;
    private boolean imageOn2=false;
    boolean inA;
    public void scan(){
        Scanner ein=new Scanner(System.in);
        System.out.print("zustand:");
        int a = ein.nextInt();

        if(a==1){
            inA=true;
        }
        if(a==0){
            inA=false;
        }
        System.out.println(inA);
    }

    // Declaration of all UI controls used in this controller class
    // and in the layout definition FXML file (defined in the scene builder)
    @FXML
    private Button button;
    @FXML
    private Button button2;

    Group pane;


    @FXML
    private FlowPane outputArea;
    ImageView imageView;
    @FXML
    private FlowPane outputArea2;
    ImageView imageView2;

    final double outputImageWidth = 60;
    final double outputImageHeight = 60;

//    final String imageName = "champignons.jpg";
    // Freigestelltes Bild
    final String imageName = "champignonsF.png";
    final String imageName2= "paprikaF.png";

    final String imagePath = "images/";

    /* There are (at least) three ways of loading an image to a button.
        1. Loading an image as background using a style sheet and styling rule
            (see file "buttonImage.css")
        2. Loading the image as Background object and attach it to the button
            (see methode initialize() below).
        3. Loading the image to an ImageView object and attach it to the button
            (see methode initialize() below).
                --> The button text cannot be put on top of the image
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }



    private Label createLabel(){
        Label newLabel=new Label();
        newLabel.setText("klappt");
        newLabel.setTextFill(Color.GREEN);
        return newLabel;
    }
    private Pane createPane(){//Test zum kreieren einer nicht angemeldeten Pane
        Pane testPane=new Pane();
        testPane.setPrefHeight(50);
        testPane.setPrefWidth(50);
        testPane.setStyle("-fx-background-color:BLACK;");
        return testPane;
    }
    private Pane panePane(){//Gehört zum oben genannten Test dazu
        //Image image = new Image(imagePath + imageName);
        Pane klein=new Pane();
        klein.setPrefHeight(5);
        klein.setPrefWidth(10);
        klein.setStyle("-fx-background-color:RED;");
        //klein.setBackground(new Background(new BackgroundImage
        //(image, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,new BackgroundSize
        //(10,5,true,true,true,false))));
        return klein;
    }
    private Group createPanePane(){//Führt die Testpanes zusammen.
        Pane Gros=createPane();
        Pane Klein=panePane();
        if(inA==false){
            Klein.setStyle("-fx-background-color:RED;");
        }
        if(inA==true){
            Klein.setStyle("-fx-background-color:GREEN;");
        }
        Pane KleinUnten=panePane();
        Pane KleinUntenRechts=panePane();
        //Translation der Pane oben links
        Translate transOL=new Translate(-5,5);
        Klein.getTransforms().add(transOL);
        //Translation der Pane unten links
        Translate transUL=new Translate(-5,40);
        KleinUnten.getTransforms().add(transUL);
        //Translation der Pane unten rechts
        Translate transUR=new Translate(45,40);
        KleinUntenRechts.getTransforms().add(transUR);
        //Zusammenführung der Panes und Rückgabe des neuen Objekts
        return new Group(Gros,Klein,KleinUnten,KleinUntenRechts);
    }
    private Group createPaneLabel(){
        Group pane=createPanePane();
        Label label=createLabel();
        return new Group(pane,label);
    }
    // Define action handler using an ImageView
    @FXML
    private void handleImageButtonPressEvent(ActionEvent event) {
        System.out.println("Loading image: " + imagePath + imageName);
        Image image = new Image(imagePath + imageName);
        //Group test =createPaneLabel();




        if (!imageOn) {
            pane = createPanePane();
            //createLabel();
            //createPane();
            //createPaneLabel();

            //imageView = new ImageView(image); //Original
            //imageView.setFitWidth(outputImageWidth); //Original
            //imageView.setFitHeight(outputImageHeight); //Original
            //imageView.setPreserveRatio(true); //Original
            //outputArea.getChildren().add(imageView); //Original
            //outputArea.getChildren().add(createLabel());
            //outputArea.getChildren().add(createPane());
            outputArea.getChildren().add(pane);
            //outputArea.getChildren().add(createPaneLabel());
        } else {
            //outputArea.getChildren().remove(imageView); //Original
            System.out.println("Test");
            outputArea.getChildren().remove(pane);
        }
        imageOn = !imageOn;
    }
    @FXML
    private void handleImage2ButtonPressEvent(ActionEvent event){
        System.out.println("Loading image"+imagePath+imageName2);
        Image image=new Image(imagePath+imageName2);
        if (!imageOn2){
            //scan();
            imageView2=new ImageView(image);
            imageView2.setFitWidth(outputImageWidth);
            imageView2.setFitHeight(outputImageHeight);
            imageView2.setPreserveRatio(true);
            outputArea2.getChildren().add(imageView2);
        }else{
            outputArea2.getChildren().remove(imageView2);
        }
        imageOn2=!imageOn2;
    }
}