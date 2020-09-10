package TableView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;

public class ListTreeController implements Initializable {

	@FXML
	private MenuItem openFileMenuItem;
	@FXML
	private MenuItem saveFileMenuItem;
	@FXML
	private MenuItem saveAsFileMenuItem;
	@FXML
	private MenuItem newFileMenuItem;
	@FXML
	MenuBar menuBar;

	@FXML
	private TableView<Tree> table;
	@FXML
	private Button addTreeButton;
	@FXML
	private Button deleteTreeButton;
	@FXML
	private Label errorMessageLabel;

	@FXML
	private TableColumn<Tree, Integer> idColumn;
	@FXML
	private TableColumn<Tree, String> nameColumn;
	@FXML
	private TableColumn<Tree, String> treeSpeciesColumn;
	@FXML
	private TableColumn<Tree, Double> diameterColumn;
	@FXML
	private TableColumn<Tree, Double> hightColumn;
	@FXML
	private TableColumn<Tree, Boolean> isEverGreenColumn;
	
	

	FileChooser fileChooser;
	File file = null;

	

	Model model = Model.getInstance();

	public void deleteTree(ActionEvent e) {
		ObservableList<Tree> selectedRows = table.getSelectionModel().getSelectedItems();
		// we don't want to iterate on same collection on with we remove items
		ArrayList<Tree> rows = new ArrayList<>(selectedRows);
		rows.forEach(row -> table.getItems().remove(row));
	}

	public void chooseFile() {

		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));
		try {
			Window window = menuBar.getScene().getWindow();
			file = fileChooser.showSaveDialog(window);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

//	public void openFile(ActionEvent e) throws ClassNotFoundException {
//		ArrayList<Tree> temps = new ArrayList<Tree>();
//		fileChooser = new FileChooser();
//		fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));
//		try {
//			Window window = menuBar.getScene().getWindow();
//			file = fileChooser.showSaveDialog(window);
//		} catch (Exception h) {
//			System.err.println("Filechoosing was schief gelaufen");
//		}
//		
//		try(FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
//			temps = (ArrayList<Tree>) ois.readObject();		
//		} catch (IOException g) {
//			g.printStackTrace();
//		}catch (ClassNotFoundException e2) {
//			e2.printStackTrace();
//		}
//		
//		model.setTrees(temps);		
//		table.getItems().addAll(model.getTrees());
//	}

	public void saveFile(ActionEvent e) {
		
		
		
	}

	public void saveAsFile(ActionEvent e) {
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));
		try {
			Window window = menuBar.getScene().getWindow();
			file = fileChooser.showSaveDialog(window);
		} catch (Exception h) {
			System.err.println("Filechoosing was schief gelaufen");
		}
		if(file != null) {
			try(FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(model.getTrees());
			} catch (Exception g) {
				System.err.println("Methode \"FileSaveAs\" im Model hat nicht ");
			}
		}
	}
	
	public void openFile(ActionEvent e) {
		try {
			model.setWindow(menuBar.getScene().getWindow());
			model.openFile();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("OpenFile Methode im Controller schiefgelaufen");
		}
		table.getItems().addAll(model.getTrees());
	}

	public void newFile(ActionEvent e) {
		model.newFile();
		table.getItems().addAll(model.getTrees());
	}

	public void addTreeViewSwap(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddTreeView.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) addTreeButton.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/*
		 * ComboBox in Tabelle anzeigen und wert reinschreiben.
		 */
		isEverGreenColumn.setCellFactory(new Callback<TableColumn<Tree, Boolean>, TableCell<Tree, Boolean>>() {

			@Override
			public TableCell<Tree, Boolean> call(TableColumn<Tree, Boolean> param) {
				CheckBoxTableCell<Tree, Boolean> cell = new CheckBoxTableCell<>();
				return cell;
			}
		});

		isEverGreenColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Tree, Boolean>, ObservableValue<Boolean>>() {

					public ObservableValue<Boolean> call(CellDataFeatures<Tree, Boolean> param) {
						SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(
								param.getValue().getIsEverGreen());
						return booleanProperty;
					}
				});

		/*
		 * Objekte der Klasse Trees in die Tabelle schreiben
		 */

		table.getItems().addAll(model.getTrees());

		/*
		 * Filechoser Initialisieren
		 */

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	

}
