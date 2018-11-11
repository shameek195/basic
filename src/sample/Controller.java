package sample;

import connectivity.connectionClass;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
   
    public Label LABEL;
    public TextField NAME;
    public TextField SUBJECT;
    public TextField DELETE;
    public AnchorPane rootpane;
    public TextField SECOND;
    public ComboBox combobox;
    public String SECTION;
    Statement statement,statement1;
    ResultSet rs;
    public  int flag=0;
    connectionClass connectionclass=new connectionClass();
    Connection connection=connectionclass.getConnection();
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("A","B");
        combobox.setItems(list);
        SECTION= (String) combobox.getValue();


    }
    public void ADD(ActionEvent actionEvent) throws SQLException {
       // connectionClass connectionclass=new connectionClass();
      //  Connection connection=connectionclass.getConnection();

        String sql="INSERT INTO lecturers VALUES('"+NAME.getText()+"','"+SUBJECT.getText()+"','"+SECOND.getText()+"','"+SECTION+"')";
        statement=connection.createStatement();
        statement.executeUpdate(sql);
        LABEL.setText("Data successfully inserted");
        NAME.setText("");
        SUBJECT.setText("");
        SECOND.setText("");
        combobox.setItems(null);




    }


    public void DELETE(ActionEvent actionEvent) throws SQLException {
       if(flag==0) {
           DELETE.setVisible(true);
           flag=1;
       }
       else {statement1 = connection.createStatement();
           String del = DELETE.getText();
           String sql2="SELECT * FROM lecturers WHERE faculty ='" +del+ "'";
           rs=statement1.executeQuery(sql2);
           rs.next();
           String subj = rs.getString("subject");
           System.out.println(subj);
           System.out.println("this executes");
           statement1 = connection.createStatement();
           String sql1="DELETE  FROM lecturers WHERE faculty ='" +del+ "'";
           statement1.execute(sql1);
           System.out.println("this executes1");
           String sql3 = "DELETE  FROM `count` WHERE subject='"+subj+"';";
           statement1.execute(sql3);
           LABEL.setText("Data successfully deleted");
           DELETE.setText("");
       }

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


