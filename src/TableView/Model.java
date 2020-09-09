package TableView;



public class Model {
	
	/*
	 * Attributes
	 */
	private String name;
	private double diameterTF;
	private double hight;
	private String treeSpecies;
	private Boolean isEverGreen;
	private int id;
	
	
/*
 * Singleton Mode
 */
	private static Model instance;

	private Model() {
		
	}

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
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

	public double getDiameterTF() {
		return diameterTF;
	}

	public void setDiameterTF(double diameterTF) {
		this.diameterTF = diameterTF;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
