package application;

public class AppInstance {
	
	private final static AppInstance appInstance = new AppInstance();
	private AppEditeur appEditeur;
	
	private AppInstance() {}
	
	public static AppInstance getInstance() {
		return appInstance;
	}
	
	public AppEditeur getAppEditeur() {
		return appEditeur;
	}
	
	public void setAppEditeur(AppEditeur app) {
		appEditeur = app;
	}
	
	public void close() {
		appEditeur.close();
	}
	
	
	
}
