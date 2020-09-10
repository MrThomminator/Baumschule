package TableView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Model {

	/*
	 * Attributes
	 */
	private String name;
	private double diameter;
	private double hight;
	private String treeSpecies;
	private Boolean isEverGreen;
	private File file = null;

	/*
	 * Singleton Mode
	 */
	private static Model instance;
	ArrayList<Tree> trees = new ArrayList<>();
	
	private Model() {

	}

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	/*
	 * TableView Add Tree
	 */

	public void addTreeToList(String name, double diameter, double hight, String treeSpecies, boolean isEverGreen) {
			trees.add(new Tree(name, diameter, hight, treeSpecies, isEverGreen));
			
	}

	/*
	 * Serialisierungsbereich / Datei speichern, Datei einlesen.
	 */
	
public void saveAsFile(File file) {
	this.file = file;
	if(file != null) {
		try(FileOutputStream fos = new FileOutputStream(file, false); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(trees);
		} catch (Exception g) {
			System.err.println("Methode \"FileSaveAs\" im Model hat nicht ");
		}
	}
}
	
	
	public void saveFile() {
		
			if(file != null) {
			try(FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(trees);
			} catch (Exception e) {
				System.err.println("Methode \"saveFile\" im Model hat nicht ");
			}
		}else {
			System.out.println("kein File vorhanden");
		}
	}
	
	public void openFile(File file) throws ClassNotFoundException {
		trees.clear();
		this.file = file;		
	
		try(FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			trees = (ArrayList<Tree>) ois.readObject();
		} catch (IOException g) {
			g.printStackTrace();
		}
	}
	
	
	public void newFile() {
		trees.clear();
	}
	
	/*
	 * Getter- and Setters
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getdiameter() {
		return diameter;
	}

	public void setdiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	public String getTreeSpecies() {
		return treeSpecies;
	}

	public void setTreeSpecies(String treeSpecies) {
		this.treeSpecies = treeSpecies;
	}

	public Boolean getIsEverGreen() {
		return isEverGreen;
	}

	public void setIsEverGreen(Boolean isEverGreen) {
		this.isEverGreen = isEverGreen;
	}

	public ArrayList<Tree> getTrees() {
		return trees;
	}

	public void setTrees(ArrayList<Tree> trees) {
		this.trees = trees;
	}	
}
