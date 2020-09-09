package TableView;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application{

	public static void main(String[] args){
		launch(args);

	}

	@Override
	public void init() throws Exception {
		
		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = new FXMLLoader().load(getClass().getResource("ListTreeView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Mitgliederbereich Baumschule Oberholz");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("laubbaumicon.jpg")));

//		try {
//		    FXMLLoader loader = new FXMLLoader(getClass().getResource("ListTreeView.fxml"));
//		    loader.setRoot(this);
//		    loader.setController("ListTreeController");
//		    loader.setClassLoader(getClass().getClassLoader());
//		    loader.load();
//		} catch (IOException e ){
//		    throw new RuntimeException(e);
//		}
		
	}
	
	@Override
	public void stop() {
		
	}

}
