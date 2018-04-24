package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppEditeurFx extends Application implements AppEditeur{
	
	private Stage stage;
	private Group root;
	private Scene scene;
	
	public AppEditeurFx() {}
	
	public void startLaunch(){
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		stage = primaryStage;
		stage.setTitle("Hello World");
        root = new Group();
        scene = new Scene(root, 1000, 800, Color.WHITE);
        stage.setScene(scene);
        stage.show();
	}

}
