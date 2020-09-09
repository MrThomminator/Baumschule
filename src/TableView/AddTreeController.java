package TableView;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
			model.setDiameterTF(Double.valueOf(diameterTF.getText()));
			model.setHight(Double.valueOf(hightTF.getText()));
			msgLabel.setText("Baum wurde erfolgreich als Mitglied hinzugefügt");
			model.setTreeSpecies(treeSpeciesCB.getSelectionModel().getSelectedItem());
			model.setIsEverGreen(Boolean.valueOf(treeSpeciesCB.getSelectionModel().getSelectedItem()));
			
			
			System.out.println("Durchmesser: " + diameterTF.getText());
			System.out.println("höhe: " + hightTF.getText());
			System.out.println("Baumart: " + treeSpeciesCB.getSelectionModel().getSelectedItem());
			System.out.println("IsEverGreen?: " + treeSpeciesCB.getSelectionModel().getSelectedItem());
		} catch (NumberFormatException e) {
			errorLabel.setText("Achtung: Sie haben ein falsches Zeichen eingegeben");
		}catch (NullPointerException e) {
			errorLabel.setText("Bitte alle Felder ausfüllen");
		}catch (IndexOutOfBoundsException e) {
			errorLabel.setText("Bitte Baumart auswählen");
		}
		
		

		
		
//		boolean selected;
//		if(everGreenYes.isSelected()) {
//			selected = true;
//		}else {
//			selected = false;
//		}
//		model.setIsEverGreen(selected);
//		System.out.println(selected);
//
//		System.out.println(treeSpeciesCB.getSelectionModel().getSelectedItem());
		
		
		
		
	}
	
	
	
	
}
