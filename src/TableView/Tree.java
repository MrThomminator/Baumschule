package TableView;

public class Tree {
	
	/*
	 * Attribute
	 */
	
	private String name;
	private double diameter;
	private double hight;
	private String treeSpecies;
	private Boolean isEverGreen;
	private static int id = 0;
	
	public Tree(String name, double diamter, double hight, String treeSpecies, Boolean isEvergreen) {
	id++;
	this.name = name;
	this.diameter = diamter;
	this.hight = hight;
	this.treeSpecies = treeSpecies;
	this.isEverGreen = isEvergreen;
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
