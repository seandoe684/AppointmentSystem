package controller;

import DBAccess.DBConnection;
import DBAccess.DBUsers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {

    public String userName;
    public String passWord;
    public TextField txtUsername;
    public TextField txtPassword;
    public Label lblCountry;
    public Label lblUsername;
    public Label lblPassword;
    public Button btnSubmit;
    public Label lblLocation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("Setting country to FR");
        //Locale.setDefault(new Locale("fr","Canada"));

        System.out.println(Locale.getDefault().getCountry().toString());
        if(Locale.getDefault().getLanguage().toString() == "fr"){
            frenchTranslation();
            lblCountry.textProperty().setValue("Canada");
        }

    }

    public void frenchTranslation(){

            lblUsername.textProperty().setValue("Nom d'utilisateur: ");
            lblPassword.textProperty().setValue("Le mot de passe: ");
            btnSubmit.textProperty().setValue("Nous faire parvenir");
            lblLocation.textProperty().setValue("Emplacement: ");

            

    }

    public void onClickBtnSubmit(ActionEvent actionEvent) throws IOException {
        userName = txtUsername.getText();
        passWord = txtPassword.getText();
        Boolean checker = DBUsers.checkUser(userName, passWord);
        System.out.println("Checker returned " + checker);
        if (checker == true)
        {
            loadMainMenu(actionEvent);
        }

    }

    public void loadMainMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}
