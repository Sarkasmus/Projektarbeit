package exec;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;





public class Controller {

    //Booleans für Buttons
    private boolean andOn=false;
    private boolean orOn=false;
    //UI Controls werden hier deklariert (Buttons, images etc)

    @FXML
    private FlowPane output1;
    ImageView imageView1;

    @FXML
    private Button and1;
    @FXML
    private Button or1;

    final String imagePath="images/";
    final String imageName1="etZeichen.png";
    final String imageName2="oder.png";
    final int hoehe=50;
    final int weite=50;


    @FXML
    private void handleButtonPressEvent(ActionEvent event){
        Image baustein=new Image(imagePath+imageName1);
        if (!andOn) {
            imageView1 = new ImageView(baustein);
            imageView1.setFitWidth(weite);
            imageView1.setFitHeight(hoehe);
            imageView1.setPreserveRatio(false);
            output1.getChildren().add(imageView1);
        }else{
            output1.getChildren().remove(imageView1);
        }
        andOn=!andOn;
    }
    @FXML
    private void handleButtonPressEvent2(ActionEvent event){
        Image baustein=new Image(imagePath+imageName2);
        if (!orOn) {
            imageView1 = new ImageView(baustein);
            imageView1.setFitWidth(weite);
            imageView1.setFitHeight(hoehe);
            imageView1.setPreserveRatio(false);
            output1.getChildren().add(imageView1);
        }else{
            output1.getChildren().remove(imageView1);
        }
        orOn=!orOn;
    }


}
