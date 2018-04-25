package application;

import canvas.Canvas;
import igraph.InterfaceFx;
import igraph.InterfaceGraphique;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import menu.CanvasMenu;
import menu.Menu;

public class AppEditeurFx extends Application implements AppEditeur{
	
	private Stage stage;
	private Group root;
	private Scene scene;
	
	private InterfaceGraphique iGraph;
	private Menu barMenu;
	private CanvasMenu barCanvas;
	private Canvas canvas;
	
	public AppEditeurFx() {}
	public AppEditeurFx(Menu barMenu, CanvasMenu barCanvas, Canvas canvas) {
		this.barMenu = barMenu;
		this.barCanvas = barCanvas;
		this.canvas = canvas;
	}
	
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
        barMenu = barMenu==null? iGraph.createBarMenu(): iGraph.createBarMenu(barMenu);
	}
	
	public Menu getBarMenu() {
		return barMenu;
	}
	public CanvasMenu getBarCanvas() {
		return barCanvas;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	
	

}
