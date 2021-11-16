package controller;

import DBAccess.DBConnection;
import DBAccess.DBUsers;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;

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

    public void onClickBtnSubmit(ActionEvent actionEvent) {
        userName = txtUsername.getText();
        passWord = txtPassword.getText();
        DBUsers.checkUser(userName, passWord);
    }
}
