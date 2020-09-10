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
	private static int id = 0;
	
	public Tree(String name, double diameter, double hight, String treeSpecies, Boolean isEverGreen) {
	id++;
	Tree.id = id;
	this.name = name;
	this.diameter = diameter;
	this.hight = hight;
	this.treeSpecies = treeSpecies;
	this.isEverGreen = isEverGreen;
}

		
	/*
	 * Getters and Setters
	 */
	
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

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Tree.id = id;
	}
}
