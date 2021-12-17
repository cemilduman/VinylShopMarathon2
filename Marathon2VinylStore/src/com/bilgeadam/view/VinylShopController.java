package com.bilgeadam.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VinylShopController {

	@FXML
	private Button loginButton;
	
	@FXML
	private Label wrongLogin;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        VinylShopMain m = new VinylShopMain();
        if(username.getText().toString().equals("javacoding") && password.getText().toString().equals("123")) {
            wrongLogin.setText("Successfull logged in!");

           // m.changeScene("afterLogin.fxml");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your username and password.");
        }


        else {
            wrongLogin.setText("Wrong username or password!");
        }
    }
}
