package sample;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller3 {
    @FXML
    private AnchorPane rootpane1;

    public void BACK2(ActionEvent actionEvent) {
        {
            Parent thirdView;
            try {
                thirdView = FXMLLoader.load(getClass().getResource("sample1.fxml"));
                Scene secondScene=new Scene(thirdView);
                Stage curStage = (Stage) rootpane1.getScene().getWindow();
                curStage.setScene(secondScene);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void setTT(ActionEvent actionEvent) {
        {
            Parent thirdView;
            try {
                thirdView = FXMLLoader.load(getClass().getResource("sample4.fxml"));
                Scene secondScene=new Scene(thirdView);
                Stage curStage = (Stage) rootpane1.getScene().getWindow();
                curStage.setScene(secondScene);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
