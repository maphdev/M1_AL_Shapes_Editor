import application.*;

public class MainApplication {
	
	private static AppEditeur app;
	
	public static AppEditeur getInstance() {
		return app;
	}
	
	public static void main(String[] args) {
		app = new AppEditeurFx();
		app.startLaunch();
		System.out.println("Good bye");
	}

}
