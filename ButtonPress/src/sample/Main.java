package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Einfache JavaFX-Applikation, mit der es möglich ist, einen Text durch einen
 * Druck auf einen Knopf (Button) zu ändern.
 *
 * @author Karsten Lehn
 * @version 16.3.2021
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Button Press");

        // Ausgabe-Feld
        Label outputField = new Label("Der Knopf wurde noch nicht gedrückt!");

        // Button
        Button button = new Button("Drück mich!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                outputField.setText("Der Knopf wurde gedrückt!");
            }
        });

        VBox vContainer = new VBox();
        vContainer.getChildren().add(button);
        vContainer.getChildren().add(outputField);

        primaryStage.setScene(new Scene(vContainer, 300, 100));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
