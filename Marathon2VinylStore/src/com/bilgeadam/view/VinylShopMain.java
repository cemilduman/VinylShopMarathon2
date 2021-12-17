package com.bilgeadam.view;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class VinylShopMain extends Application {
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			stg = primaryStage;
			primaryStage.setResizable(false);
			primaryStage.setTitle("VINYL SHOP");
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("VinylShopController.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
