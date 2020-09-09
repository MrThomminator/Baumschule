package TableView;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ListTreeController {

	@FXML
	MenuItem openFileMenuItem;
	@FXML
	MenuItem saveFileMenuItem;
	@FXML
	MenuItem saveAsFileMenuItem;
	@FXML
	MenuItem newFileMenuItem;

	@FXML
	TableView<Tree> table;
	@FXML
	Button addTreeButton;
	@FXML
	Button deleteTreeButton;
	@FXML
	Label errorMessageLabel;
	
	
	@FXML
	TableColumn<Tree, Integer> idColumn;
	@FXML
	TableColumn<Tree, String> nameColumn;
	@FXML
	TableColumn<Tree, String> treeSpeciesColumn;
	@FXML
	TableColumn<Tree, Double> diameterColumn;
	@FXML
	TableColumn<Tree, Double> hightColumn;
	
	

	public void deleteTree(ActionEvent e) {

	}

	public void openFile(ActionEvent e) {

	}

	public void saveFile(ActionEvent e) {

	}

	public void saveAsFile(ActionEvent e) {

	}
	public void newFile(ActionEvent e) {
		
	}
	

	public void addTreeViewSwap(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddTreeView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) addTreeButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	
}
