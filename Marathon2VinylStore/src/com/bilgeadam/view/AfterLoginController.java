package com.bilgeadam.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AfterLoginController {

	@FXML
	Button logOut;
	
	public void userLogOut(ActionEvent event) throws IOException {
		VinylShopMain main = new VinylShopMain();
		main.changeScene("LoginPage.fxml");
	}
}
