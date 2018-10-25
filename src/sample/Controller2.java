package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller2 {

    public Button m1;
    public Button m7;
    @FXML
    private AnchorPane rootpane1;
    public String buttoninfo;



    public void BACK1(ActionEvent actionEvent) {
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
                System.out.println(((Button)actionEvent.getSource()).getId());
                buttoninfo=((Button)actionEvent.getSource()).getId();
                Controller4 c4 = new Controller4();
//                if(actionEvent.getSource() == buttoninfo){
//
//                }
                System.out.println("hello");
                System.out.println(c4.name +
                 " " + c4.str);



            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public void settingtext(String sub,String faculty) {
       // getResource()buttoninfo.setText(sub);
    }
}

