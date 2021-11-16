
package Main;

import DBAccess.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class Main  extends Application {


    @Override

    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        stage.setTitle("Welcome");
        stage.setScene(new Scene(root, 800,600));
        stage.show();
    }


    public static void main(String[] args){
        DBConnection.startConnection();
        launch(args);
        DBConnection.closeConnection();
    }
}
