package application;

import bar.BarCanvas;
import bar.BarMenu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppEditeurFx extends Application implements AppEditeur{
	
	private Stage stage;
	private Group root;
	private Scene scene;
	
	private InterfaceGraphique iGraph;
	private BarMenu barMenu;
	private BarCanvas barCanvas;
	private Canvas canvas;
	
	public AppEditeurFx() {}
	
	public void startLaunch(){
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		stage = primaryStage;
		stage.setTitle("Hello World");
        root = new Group();
        scene = new Scene(root, 800, 800, Color.WHITE);
        stage.setScene(scene);
        stage.show();
        
        iGraph = new InterfaceFx(root);
        barMenu = iGraph.createBarMenu();
	}
	
	public BarMenu getBarMenu() {
		return barMenu;
	}
	public BarCanvas getBarCanvas() {
		return barCanvas;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	
	

}
