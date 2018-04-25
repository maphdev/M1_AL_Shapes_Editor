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
	public AppEditeurFx(AppEditeur app) {
		this.menu = app.getBarMenu();
		this.canvasMenu = app.getBarCanvas();
		this.canvas = app.getCanvas();
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
        menu = menu==null? iGraph.createMenu(): iGraph.createMenu(menu);
        canvas = canvas==null? iGraph.createCanvas(): iGraph.createCanvas(canvas);
        canvasMenu = canvasMenu==null? iGraph.createCanvasMenu(): iGraph.createCanvasMenu(canvasMenu);
        
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
