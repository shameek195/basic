package sample;

import connectivity.connectionClass;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
   
    public Label LABEL;
    public TextField NAME;
    public TextField SUBJECT;
    public TextField DELETE;
    public AnchorPane rootpane;
    public TextField SECOND;
    Statement statement,statement1;
    connectionClass connectionclass=new connectionClass();
    Connection connection=connectionclass.getConnection();
    public void ADD(ActionEvent actionEvent) throws SQLException {
       // connectionClass connectionclass=new connectionClass();
      //  Connection connection=connectionclass.getConnection();

        String sql="INSERT INTO lecturers VALUES('"+NAME.getText()+"','"+SUBJECT.getText()+"','"+SECOND.getText()+"')";
        statement=connection.createStatement();
        statement.executeUpdate(sql);
        LABEL.setText("Data successfully inserted");
        NAME.setText("");
        SUBJECT.setText("");
        SECOND.setText("");




    }

    public void DELETE(ActionEvent actionEvent) throws SQLException {
        DELETE.setVisible(true);
        String del=DELETE.getText();
        String sql1="DELETE  FROM lecturers WHERE faculty ='"+del+"'";
        statement1=connection.createStatement();
        statement1.execute(sql1);
        LABEL.setText("Data successfully deleted");
        DELETE.setText("");

    }

    public void SECOND(ActionEvent actionEvent) {
        SECOND.setVisible(true);

    }



    public void nextbuttonclick(ActionEvent actionEvent) {
        makeFadeOut();



    }



    private void makeFadeOut() {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(rootpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);


        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadNextScene();
            }
        });
        fadeTransition.play();

    }
    private void loadNextScene()


    {Parent secondView;
        try {
            secondView = FXMLLoader.load(getClass().getResource("sample1.fxml"));
            Scene secondScene=new Scene(secondView);
            Stage curStage = (Stage) rootpane.getScene().getWindow();
            curStage.setScene(secondScene);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


