package TableView;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application{
	 private static Stage primaryStage;
	 
	 static public Stage getPrimaryStage() {
	        return main.primaryStage;
	    }
	 
	public static void main(String[] args){
		launch(args);

	}

	@Override
	public void init() throws Exception {
		
//		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("ListTreeView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Mitgliederbereich Baumschule Oberholz");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("laubbaumicon.jpg")));
	
	}
	
	@Override
	public void stop() {
		
	}

}
