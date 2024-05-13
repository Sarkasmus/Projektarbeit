package exec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{

        //Lädt das FXML File
Parent root= FXMLLoader.load(getClass().getResource("demoProject.fxml"));

//Setzt den Titel der Stage
primaryStage.setTitle("Demo");

//Setzt neue Scene
        //Bindet das stylesheet an
Scene demoScene=new Scene(root);
        demoScene.getStylesheets().add(getClass().getResource("demoBackground.css").toExternalForm());
//Bindet neue Scene in die Stage ein
primaryStage.setScene(demoScene);
primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}