package com.bilgeadam.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginPageController implements Initializable {

	@FXML
	private Button loginButton;
	
	@FXML
	private Label wrongLogin;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button signUp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginButton.getStyleClass().add("button-login");
		signUp.setId("button-signup");
		
	}
	
	
	public void signingUp(ActionEvent event) throws IOException {
		VinylShopMain main = new VinylShopMain();
		main.changeScene("SignIn.fxml");
	}
	
    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        VinylShopMain m = new VinylShopMain();
        if(email.getText().equals("mail") && password.getText().toString().equals("root")) {
            wrongLogin.setText("Successfully logged in!");
            m.changeScene("AfterLogin.fxml");
        }else if(password.getText().isEmpty() || email.getText().isEmpty()) {
            wrongLogin.setText("Please enter your email and password.");
        } else {
            wrongLogin.setText("Wrong email and password!");
        }
    }
    


}
