import application.AppEditeur;
import application.AppEditeurFx;

public class MainApplication {
	
	public static void main(String[] args) {
		AppEditeur app = new AppEditeurFx();
		app.startLaunch();
		System.out.println("Good bye");
	}

}
