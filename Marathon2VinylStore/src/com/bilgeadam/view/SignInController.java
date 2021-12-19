package com.bilgeadam.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignInController {

	@FXML
	private Button signUp;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField surname;
	
	@FXML
	private TextField email;
	
	/*
	 * style="-fx-background-color: #ffc900;"
	 */
	
	@FXML
	private TextField password;
	
	@FXML
	private Label wrongLogin;
	
	public void enrollUser(ActionEvent event) throws IOException {	
		checkLogin();
	}
	
    private void checkLogin() throws IOException {
        VinylShopMain m = new VinylShopMain();
        if(name.getText().isEmpty() || password.getText().isEmpty() || surname.getText().isEmpty() || email.getText().isEmpty()) {
        	wrongLogin.setText("Please enter your name, surname, email and password.");
        }else{
        	m.changeScene("MailActivationPage.fxml");
        }
    }
}
