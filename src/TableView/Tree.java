package TableView;

import java.io.Serializable;

public class Tree implements Serializable {
	
	/*
	 * Attribute
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double diameter;
	private double hight;
	private String treeSpecies;
	private Boolean isEverGreen;
	private int id;
	private static int nID;
	
	Model model = Model.getInstance();
	


	public Tree(String name, double diameter, double hight, String treeSpecies, Boolean isEverGreen) {
		
	for(Tree tree : model.getTrees()) {
		if(tree.getId() > nID) {
			nID = tree.getId();
		}
	}
		
	this.id = ++nID;
	this.name = name;
	this.diameter = diameter;
	this.hight = hight;
	this.treeSpecies = treeSpecies;
	this.isEverGreen = isEverGreen;
	
	
}

	
	
	
	
	/*
	 * Getters and Setters
	 */
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getnID() {
		return nID;
	}


	public void setnID(int nID) {
		this.nID = nID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameterTF(double diameter) {
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
	

}
