package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class TempConverter extends Application {

    private Button buttonReset ;
    private Button buttonClose;
    private Label labelC ;
    private Label labelF ;
    private TextField textFieldC ;
    private TextField textFieldF ;
    private EventHandler textFieldCListener;
    private EventHandler textFieldFListener;
    private EventHandler buttonResetListener;
    private EventHandler buttonCloseListener;




    @Override
    public void start(Stage stage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root);
        initListener();
        initGUI(root);
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();

    }

    public void initListener(){
        /*
         * Listener of the Celsius field: convert the data from Clesius to
         * Fahrenheit when the "enter" keyboard button is hit (in the Clesius field)
         */
          textFieldCListener = new EventHandler<KeyEvent>() {
              @Override
              public void handle(KeyEvent e) {

                  if (e.getCode().equals(KeyCode.ENTER)) {
                      String value = textFieldC.getText();
                      try {
                          float valC = new Float(value);
                          float valF = valC * 1.8f + 32;
                          textFieldF.setText(Float.toString(valF));
                      } catch (Exception exp) {
                          textFieldF.setText("");
                          textFieldC.setText("");
                      }
                  } else{
                      //nothing
                  }
              }
          };



        /*
         * Listener of the Fahrenheit field: Convert the data from Fahrenheit to
         * Celsius when the "enter" keyboard button is hit (in the Fahrenheit field)
         */
          textFieldFListener = new EventHandler<KeyEvent>() {
              @Override
              public void handle(KeyEvent e) {
                  /*if(e.getCode() == KeyCode.ENTER){
                      String value = textFieldF.getText();
                      try {
                          float valF = new Float(value);
                          float valC = (valF-32) / 1.8f ;
                          textFieldC.setText(Float.toString(valC));
                      } catch (Exception exp) {
                          textFieldF.setText("");
                          textFieldC.setText("");
                      }
                  }*/
                  String value = textFieldF.getText();
                  try {
                      float valF = new Float(value);
                      float valC = (valF-32)/ 1.8f ;
                      textFieldC.setText(Float.toString(valC));
                  } catch (Exception exp) {
                      textFieldF.setText("");
                      textFieldC.setText("");
                  }

              }
          };

        /*
         * Listener of the Reset button: Reset the value in the text field when the
         * Reset button is pressed
         */
        buttonResetListener = new EventHandler(){
            @Override
            public void handle(Event event) {
                textFieldF.setText("");
                textFieldC.setText("");
            }
         };

        /*
         * Listener of the Close button: Close the program window when the Close
         * button is pressed
         */
          buttonCloseListener = new EventHandler() {
              @Override
              public void handle(Event event) {
                  Platform.exit();
              }
          };

    }


    public void initGUI(Pane root){

        buttonReset = new Button("Reset");
        buttonClose = new Button("Close");
        labelC = new Label("Celsius");
        labelF = new Label("Fahrenheit");
        textFieldC = new TextField();
        textFieldF  = new TextField();

        buttonClose.setOnAction(buttonCloseListener);
        textFieldC.setOnKeyReleased(textFieldCListener);
        textFieldF.setOnKeyReleased(textFieldFListener);
        buttonReset.setOnAction(buttonResetListener);

        buttonClose.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("test");
            }
        });


        VBox vbContainer = new VBox();
        HBox hbButtons = new HBox(3);
        VBox hbCelsius = new VBox(20);
        VBox hbFarhen = new VBox(20);
        hbFarhen.setPadding(new Insets(10, 10, 0, 10));
        hbCelsius.setPadding(new Insets(10, 10, 0, 10));
        hbButtons.setPadding(new Insets(10, 10, 10, 10));


        vbContainer.getChildren().addAll(hbCelsius,hbFarhen,hbButtons);


        hbCelsius.getChildren().addAll(labelC,textFieldC);
        hbFarhen.getChildren().addAll(labelF,textFieldF);

        hbButtons.getChildren().addAll(buttonReset, buttonClose);
        hbButtons.setAlignment(Pos.BASELINE_RIGHT);
        root.getChildren().addAll(vbContainer);
    }


    public static void main(String[] args) {
        launch(args);

    }
}
