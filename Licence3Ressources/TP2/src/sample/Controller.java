package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class Controller {


    ObservableList<String> optionsListview;
    ObservableList<String>   optionsListRep  ;
    FileSelector fs;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOpen;

    @FXML
   private  ListView listViewFile;

    @FXML
   private ComboBox<String> comboxRep;

    public Controller(){
        super();
         fs = new FileSelector();
    }


    @FXML
    public void initialize(){


        String path = System.getProperty("user.dir");
        majComboView(path);
        comboxRep.getSelectionModel().selectLast();
        majListeView();



        comboxRep.setOnAction(event ->  {
            majListeView();
        });


            btnOpen.setOnMouseClicked(event -> {
                File dir = new File(comboxRep.getValue()+listViewFile.getSelectionModel().getSelectedItem()) ;
                if(dir.isFile()){
                    //Do something with the file (open it?)
                    System.exit(0);

                } else if(dir.isDirectory()){
                    majComboView(dir.getAbsolutePath());
                } else{
                    //DO something else
                }

            });



            listViewFile.setOnMouseClicked(event -> {
                btnOpen.setDisable(false);
                if(event.getClickCount() == 2){
                    System.out.println("Double clicked");
                    btnOpen.fireEvent(event);
                }
            });



            //Avec une lambda expression
            btnCancel.setOnAction((event)-> {
                System.exit(0);
            });
        }


    //mise a jour du modele de donnée
    private void majListeView() {

        if (comboxRep.getSelectionModel().getSelectedItem() != null ){
            optionsListview =
                    FXCollections.observableArrayList(
                            fs.getListFile(comboxRep.getSelectionModel().getSelectedItem())

                    );

            listViewFile.setItems(optionsListview);
        }

    }

    private void majComboView(String path){
       optionsListRep =  FXCollections.observableArrayList(fs.getListRepParent(path) );
        comboxRep.setItems(optionsListRep);
        comboxRep.getSelectionModel().selectLast();

    }
}






