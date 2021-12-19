package com.bilgeadam.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MailActivationPageController {

	@FXML
	TextField activationCode;
	
	@FXML
	Button activationSubmit;
	
	@FXML
	Label wrongSubmit;
	
	public void activateSignUp() throws IOException {
		checkActivation();
	}
	
    private void checkActivation() throws IOException {
        VinylShopMain m = new VinylShopMain();
        if(activationCode.getText().toString().equals("xy6326798")) {
        	m.changeScene("LoginPage.fxml");
        	
        }else{
        	wrongSubmit.setText("Wrong Activation Code");
        }
    }
}
