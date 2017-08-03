package com.xwintop.xJavaFxTool;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.xwintop.xJavaFxTool.controller.IndexController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	private static Logger log = Logger.getLogger(Main.class);

	@Override
	public void start(Stage primaryStage) throws Exception {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("locale.Menu", Locale.CHINA);
		URL url = getClass().getResource("/fxml/Index.fxml");
//		ResourceBundle resourceBundle = ResourceBundle.getBundle("locale.epmsTools.Menu", Locale.UK);
//		URL url = getClass().getResource("/fxml/epmsTools/GeneratingCode.fxml");

		FXMLLoader fXMLLoader = new FXMLLoader(url, resourceBundle);
//		Parent root = FXMLLoader.load(url, resourceBundle);
		Parent root = fXMLLoader.load();
		primaryStage.setResizable(true);
		primaryStage.setTitle("MyJavaFxTool");
		primaryStage.getIcons().add(new Image("/images/icon.jpg"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
//		IndexController indexController = fXMLLoader.getController();
	}

	public static void main(String[] args) {
		PropertyConfigurator.configure(Main.class.getResource("/config/log4j.properties"));
		try {
			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			log.error(e);
		}
	}
}