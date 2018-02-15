package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
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
                  //TODO
              }
          };

        /*
         * Listener of the Reset button: Reset the value in the text field when the
         * Reset button is pressed
         */
        buttonResetListener = new EventHandler(){
            @Override
            public void handle(Event event) {
                //TODO
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
        //TODO
    }


    public static void main(String[] args) {
        launch(args);
    }
}
