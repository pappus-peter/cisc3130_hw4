package hw4_ver3;

public class Father {
	private String name; 
	private int sons; 
	
	public Father(String name, int sons) {
		this.name = name; 
		this.sons = sons; 
	}
	public String getName() {
		return this.name; 
	}
	public int getSons() {
		return this.sons; 
	}
	///// setter
	public void removeSon() {
		this.sons--; 
	}
	public Boolean hasSon() {
		return this.sons > 0; 
	}
//	public static Father read(Scanner input) {
//		return null; 
//	}

}
