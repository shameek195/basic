package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("loading.fxml"));
        primaryStage.setTitle("TIME-TABLE ASSISSTANT");
        primaryStage.setScene(new Scene(root, 608, 343));
        //primaryStage.setMaxHeight(400);
        //primaryStage.setMaxWidth(600);
        primaryStage.setResizable(false);
        primaryStage.show();
        sleep(3000);
        Parent thirdView;
        FXMLLoader load1=new FXMLLoader(getClass().getResource("loading.fxml"));
        thirdView = (Parent) load1.load();

        loading l=new loading();
        l.start(primaryStage);

//        Parent thirdView;
//        try {FXMLLoader load1=new FXMLLoader(getClass().getResource("loading.fxml"));
//
//
//
//
//            thirdView = (Parent) load1.load();
//            loading c2=load1.getController();
//
//            c2.start(primaryStage);







//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
