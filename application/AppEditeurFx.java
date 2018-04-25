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
	private Menu menu;
	private CanvasMenu canvasMenu;
	private Canvas canvas;
	
	public AppEditeurFx() {}
	public AppEditeurFx(Menu barMenu, CanvasMenu barCanvas, Canvas canvas) {
		this.menu = barMenu;
		this.canvasMenu = barCanvas;
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
        menu = menu==null? iGraph.createBarMenu(): iGraph.createBarMenu(menu);
	}
	
	public Menu getBarMenu() {
		return menu;
	}
	public CanvasMenu getBarCanvas() {
		return canvasMenu;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	
	

}
