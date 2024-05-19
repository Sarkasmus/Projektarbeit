package exec;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    //UI Controls werden hier deklariert (Buttons, images etc)

    @FXML
    private Pane output;
    @FXML
    private Pane outputDelete;

    @FXML
    private VBox source;

    final String imagePath = "images/";
    final String[] images = {"etZeichen.png", "oder.png"};

    //
    //
    //Einführung der Drag/Drop Funktion
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//Erstellung eines Bildes/der Bilder/der Bausteine im Sourcearea
        source.setAlignment(Pos.CENTER);
        for (int imageNo = 0; imageNo < images.length; imageNo++) {
            Image baustein=new Image(imagePath+images[imageNo]);
            ImageView sourceview =new ImageView();
            sourceview.setImage(baustein);
            //Teilt der Source mit dass ein Drag erfasst wurde
            sourceview.setOnDragDetected(this::sourceOnDragDetectedHandler);
            source.getChildren().add(sourceview);
        }
    }
    @FXML
    private void sourceOnDragDetectedHandler(MouseEvent event) {//Wird ein Drag gestartet wird das jeweilige Bild aufgenommen, in diesem Fall aus der Source
        ImageView sourceview = (ImageView) event.getTarget();
        Dragboard dragboard = sourceview.startDragAndDrop(TransferMode.COPY);
        ClipboardContent inhalt = new ClipboardContent();
        inhalt.putImage(sourceview.getImage());
        dragboard.setContent(inhalt);
        event.consume();
    }
    @FXML
    private void targetOnDragDetectedHandler(MouseEvent event) {//Wird ein Drag gestartet wird das jeweilige Bild aufgenommen, in diesem Fall aus der Pane
        ImageView outputview = (ImageView) event.getTarget();
        Dragboard dragboard = outputview.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent inhalt = new ClipboardContent();
        inhalt.putImage(outputview.getImage());
        dragboard.setContent(inhalt);
        event.consume();
    }
    @FXML
    private void targetOnDragDoneHandler(DragEvent event) {//Entferne das alte Bild wenn der Drag abgeschlossen ist
        if (event.getTransferMode() == TransferMode.MOVE) {
            ImageView outputview = (ImageView) event.getTarget();
            output.getChildren().remove(outputview);
        }
        event.consume();
    }
    @FXML
    private void targetOnDragOverHandler(DragEvent event) {
        if (event.getGestureSource() != output && event.getDragboard().hasImage()) {//Führt Drag durch wenn das Bild nicht von der selben Node kommt
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    @FXML
    private void targetOnDragDroppedHandler(DragEvent event) {//Liegt ein Objekt auf dem Dragboard kann es verwendet werden
        Dragboard dragboard = event.getDragboard();
        boolean success = false;
        if (dragboard.hasImage()) {
            ImageView imageView = new ImageView(dragboard.getImage());
            //Positionierung nach Mauskoordinaten
            imageView.setX(event.getX() - imageView.getImage().getWidth() / 2);
            imageView.setY(event.getY() - imageView.getImage().getHeight() / 2);
            //Anheften der Draghandler
            //Dies ermöglicht, dass die Objekte auch auf der Pane mit Drag/Drop verschoben werden können
            imageView.setOnDragDetected(this::targetOnDragDetectedHandler);
            imageView.setOnDragDone(this::targetOnDragDoneHandler);
            output.getChildren().add(imageView);
            success = true;
        }
        event.setDropCompleted(success);//Drag erfolgreich, kein weiterer Dragboard Zugriff
        event.consume();
    }
    @FXML
    private void targetDeleteOnDragDroppedHandler(DragEvent event) {//Die Deletefläche entfernt Objekte die in sie hinein gezogen werden
        Dragboard dragboard = event.getDragboard();
        boolean success = false;
        if (dragboard.hasImage()) {
            ImageView imageView = new ImageView(dragboard.getImage());
            imageView.setX(event.getX() - imageView.getImage().getWidth() / 2);
            imageView.setY(event.getY() - imageView.getImage().getHeight() / 2);
            imageView.setOnDragDetected(this::targetOnDragDetectedHandler);
            imageView.setOnDragDone(this::targetOnDragDoneHandler);
            outputDelete.getChildren().remove(imageView);
            success = true;
        }
        event.setDropCompleted(success);
        event.consume();
    }
}
