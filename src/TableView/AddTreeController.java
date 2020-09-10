package TableView;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddTreeController implements Initializable{

	@FXML
	Pane pane;
	@FXML
	TextField nameTF;
	@FXML
	TextField diameterTF;
	@FXML
	TextField hightTF;
	@FXML
	ComboBox<String> treeSpeciesCB;
	@FXML
	CheckBox everGreenYes;
	
	@FXML
	Button addTreeButton;
	
	@FXML
	Button ListViewButton;
	
	
	String treeSpecies;
	
	
	@FXML
	Label msgLabel;
	@FXML
	Label errorLabel;
	
	@FXML
	Label IDlabel;
	@FXML
	ImageView treeImage;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> treeSpecies = FXCollections.observableArrayList("Laubbaum", "Nadelbaum");
		treeSpeciesCB.getItems().addAll(treeSpecies);
//		treeSpeciesCB.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//			
//		});
		
	}
	
	public void createTree() throws Exception {
		Model model = Model.getInstance();
		errorLabel.setText("");
		msgLabel.setText("");

		try {

			System.out.println("name: " + nameTF.getText());
			System.out.println("Durchmesser: " + Double.valueOf(diameterTF.getText()));
			System.out.println("höhe: " + Double.valueOf(hightTF.getText()));
			System.out.println("Baumart: " + treeSpeciesCB.getSelectionModel().getSelectedItem());
			System.out.println("Evergreen?" + everGreenYes.selectedProperty().getValue());
			
			model.addTreeToList(nameTF.getText(), Double.valueOf(diameterTF.getText()), Double.valueOf(hightTF.getText()), treeSpeciesCB.getSelectionModel().getSelectedItem(), everGreenYes.selectedProperty().getValue());
			
			
			
			msgLabel.setText("Baum wurde erfolgreich als Mitglied hinzugefügt");
		} catch (NumberFormatException e) {
			errorLabel.setText("Achtung: Sie haben ein falsches Zeichen eingegeben");
		}catch (NullPointerException e) {
			errorLabel.setText("Bitte alle Felder ausfüllen");
		}catch (IndexOutOfBoundsException e) {
			errorLabel.setText("Bitte Baumart auswählen");
		}
		
	}
	
	
	public void SwapToListView(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ListTreeView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ListViewButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	
	
}
