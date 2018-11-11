package sample;


import connectivity.connectionClass;
import javafx.animation.FadeTransition;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {
    public Button BACK;
    @FXML
private AnchorPane rootpane1;
    Statement statement,statement1;
    connectionClass connectionclass = new connectionClass();
    Connection connection = connectionclass.getConnection();
    ResultSet rs;
    public static String name,str;




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
        try {FXMLLoader load1=new FXMLLoader(getClass().getResource("sample2.fxml"));



            thirdView = (Parent) load1.load();
            Controller2 c2=load1.getController();

            c2.refresh();
            Scene secondScene=new Scene(thirdView);
            Stage curStage = (Stage) rootpane1.getScene().getWindow();


            curStage.setScene(secondScene);
            curStage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void SECTION5B(ActionEvent actionEvent) {
        Parent thirdView;
        try {
            FXMLLoader load1=new FXMLLoader(getClass().getResource("sample3.fxml"));



            thirdView = (Parent) load1.load();
            Controller3 c3=load1.getController();
            c3.refresh();
            c3.refresh();
            Scene secondScene=new Scene(thirdView);
            Stage curStage = (Stage) rootpane1.getScene().getWindow();
            curStage.setScene(secondScene);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

