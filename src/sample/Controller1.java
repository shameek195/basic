package sample;


import javafx.animation.FadeTransition;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {
    public Button BACK;
    @FXML
private AnchorPane rootpane1;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        makeFadeTransistion();
    }
    private void makeFadeTransistion() {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(rootpane1);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();


    }

    public void BACK(ActionEvent actionEvent) {
        {
            Parent thirdView;
            try {
                thirdView = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Scene secondScene=new Scene(thirdView);
                Stage curStage = (Stage) rootpane1.getScene().getWindow();
                curStage.setScene(secondScene);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public void SECTION5A(ActionEvent actionEvent) {
        Parent thirdView;
        try {
            thirdView = FXMLLoader.load(getClass().getResource("sample2.fxml"));
            Scene secondScene=new Scene(thirdView);
            Stage curStage = (Stage) rootpane1.getScene().getWindow();
            curStage.setScene(secondScene);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void SECTION5B(ActionEvent actionEvent) {
        Parent thirdView;
        try {
            thirdView = FXMLLoader.load(getClass().getResource("sample3.fxml"));
            Scene secondScene=new Scene(thirdView);
            Stage curStage = (Stage) rootpane1.getScene().getWindow();
            curStage.setScene(secondScene);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

