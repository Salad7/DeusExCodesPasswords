import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApplication extends Application{
	static DisplayFrame dframe;
	
	public static void main(String [] args)
	{
		Database.init();
		
		Database.loadFile("./res/test");
		dframe = new DisplayFrame(Database.getDatabase());
		
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(dframe, 333, 250, Color.WHITE);

	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
}
