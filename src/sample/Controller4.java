package sample;

import connectivity.connectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Controller4 {
    public AnchorPane rootpane1;
    Statement statement,statement1;
    connectionClass connectionclass = new connectionClass();
    Connection connection = connectionclass.getConnection();
    ResultSet rs;
    public static String name,str;

    public ComboBox comboBox1;
    @FXML
    public Label label;
    @FXML
    private void initialize() {

        try {
            String sql = "SELECT * FROM lecturers";

            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            ObservableList<String> list = FXCollections.observableArrayList();

            while (rs.next()) {

                list.addAll(rs.getString("subject"));


            }
            comboBox1.setItems(list);
            setValue();



        } catch (Exception e) {
            System.out.println(e.getMessage());


        }


    }
    public void setValue() throws SQLException {
         str=comboBox1.getValue().toString();
        System.out.println(str);

        String sql1 = "SELECT * FROM lecturers where subject='"+str+"'";
        try {
            System.out.println(sql1);
            statement1 = connection.createStatement();
            rs = statement1.executeQuery(sql1);
            rs.next();
            name=rs.getString("faculty");
            label.setText(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void BACK(ActionEvent actionEvent) {
        {
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

    }

    public void assign(ActionEvent actionEvent) {
        new Controller2().settingtext(str,name);
        BACK(actionEvent);


    }
}
