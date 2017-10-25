import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javax.swing.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class ControlCircleFX extends Application
{
   private CirclePane cPane = new CirclePane();
   
   public void start(Stage primaryStage)
   {
      HBox hBox = new HBox();
      hBox.setSpacing(10);
      hBox.setAlignment(Pos.CENTER);
      
      Button btEnlarge = new Button("Enlarge");
      Button btShrink = new Button("Shrink");
      
      hBox.getChildren().add(btEnlarge);
      hBox.getChildren().add(btShrink);
      
      EnlargeHandler handler1 = new EnlargeHandler();
      btEnlarge.setOnAction(handler1);
      
      ShrinkHandler handler2 = new ShrinkHandler();
      btShrink.setOnAction(handler2);
      
      BorderPane bPane = new BorderPane();
      bPane.setCenter(cPane);
      bPane.setBottom(hBox);
      bPane.setAlignment(hBox, Pos.CENTER);
      
      Scene scene = new Scene(bPane, 200, 150);
      primaryStage.setTitle("ControlCircleFX"); 
      primaryStage.setScene(scene); 
      primaryStage.show(); 
     }
      
class EnlargeHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         cPane.enlarge();
      }
   }
 class ShrinkHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent a)
      {
         cPane.shrink();
      }
   }
      
      
   public static void main (String[] args)
      {
         launch(args);
      }

   }

class CirclePane extends StackPane
{
   private Circle circle = new Circle(50);
   
   public CirclePane()
   {
      getChildren().add(circle);
      circle.setStroke(Color.BLACK);
      circle.setFill(Color.WHITE);
   }
   
   public void enlarge()
   {
      circle.setRadius(circle.getRadius() + 1);
   }
   
   public void shrink()
   {
      if(circle.getRadius() > 1)
      {
         circle.setRadius(circle.getRadius() - 1);
      }
   }
}

/* Errors (Should be handle(actionEvent a) instead of actionPerformed(actionEvent a) */