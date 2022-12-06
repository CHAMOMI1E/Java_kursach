package main.artifact;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Add_Controller {

    public int count = 1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private TextField fename;

    @FXML
    private TextField group;

    @FXML
    private TextField name;

    @FXML
    private TextField score;

    @FXML
    private TextField second_name;

    @FXML
    void initialize() {
        DatebaseHandler dbHandler = new DatebaseHandler();
        add.setOnAction(event -> {


            if (!name.getText().equals("") || !fename.getText().equals("") || !second_name.getText().equals("") || !group.getText().equals("") || !score.getText().equals("")) {
              //  dbHandler.add_name(name.getText(), fename.getText(), second_name.getText());
                //dbHandler.add_score(score.getText());
                //dbHandler.add_grope(group.getText());
                dbHandler.add_data(count);
                count++;

            }
            else {
                System.out.println("ОШИБКА");
            }


        });

    }

}
