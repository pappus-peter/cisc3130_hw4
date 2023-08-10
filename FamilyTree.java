package hw4_ver3;
import java.io.*; 
import java.util.*; 


public class FamilyTree {
	private static Node root; 

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("src/hw4_ver2/input.txt")); 
		PrintWriter output = new PrintWriter(new File("src/hw4_ver2/output.txt")); 
		LinkedList<Father> fathers = new LinkedList<Father>();
		
		root = new Node(input.next());
		int sons = input.nextInt(); 
		Father grand = new Father(root.getName(),sons);
		fathers.add(grand); 
		output.println("Start reading family tree: "); 
		read(0, input, output, fathers, root); 		
		
		
		Node key, keyFather, keyGrandfather, keyBrother, keySon; 
		key = searchPretrav("Richard", root);
		keyFather = searchFather(key); 
		output.println("\n\n-----\n1. Father of " + key.getName() + " is: " + keyFather.getName() ); 
		
		key = searchPretrav("Bill", root);
		keyGrandfather = searchFather(searchFather(key)); 
		output.println("\n\n-----\n9a. Grandfather of " + key.getName() + " is: " + keyGrandfather.getName() ); 
		
		key = searchPretrav("Deville", root);
		keyGrandfather = searchFather(searchFather(key)); 
		output.println("\n\n-----\n9b. Grandfather of " + key.getName() + " is: " + keyGrandfather.getName() ); 
		
		key = searchPretrav("Dan", root);
		keyBrother = searchBrother(key);
		output.print("\n\n-----\n3. all the brothers of " + key.getName() + " are: "); 
		printSiblings(output, key, keyBrother); 
		
		output.print("\n\n-----\n4a. Oldest brother of " + key.getName() + " is: ");
		printOldestSibling(output, key, keyBrother);
		
		key = searchPretrav("Michael", root);
		keyBrother = searchBrother(key);
		output.print("\n\n-----\n4b. Oldest brother of " + key.getName() + " is: "); 
		printOldestSibling(output, key, keyBrother); 
		
		output.close();
		input.close();
	}
		
	
	// failed to return the node
	public static Node readRoot(Scanner input, PrintWriter output, LinkedList fathers) {
		Node result = new Node(input.next());
		int sons = input.nextInt(); 
		Father grand = new Father(root.getName(),sons);
		fathers.add(grand); 
		return result; 
		
	}
	
	public static void read(int siblings, Scanner input, PrintWriter output, LinkedList fathers, Node current) {
		// recursive reading method
		if(input.hasNext()) {			
			Node insert = new Node(input.next()); 
			int sons = input.nextInt(); 
			Father listed = new Father(insert.getName(), sons);  
			if(sons > 0) fathers.add(listed); 
			
			
			if(siblings > 0) { 
				current.insertRight(insert);
				output.println(current.getName() + " added brother " + current.right().getName());
				current = current.right();
				siblings--;
				
			} else if(siblings == 0){
				Father search = (Father)fathers.remove();
				String searchName = search.getName(); 
				siblings = search.getSons()-1; 
				current = searchPretrav(searchName, root);
				
				current.insertLeft(insert);
				output.println(current.getName() + " added son " + current.left().getName()); 
				current = current.left();	
			}
			if(current != null) {
				read(siblings, input, output, fathers, current); 
			}	
		}
	}
	
	public static Node searchPretrav(String target, Node current) { 

		if(current.getName().equals(target)){
			return current;
		}		
		if(current.left() != null) {
			Node result = searchPretrav(target, current.left());
			if(result != null) return result; 
		}
		if(current.right() != null) {
			return searchPretrav(target, current.right()); 
		}
		return null; 
	}
	
	public static Node searchFather(Node current) {
		Node previous = new Node(); 
		while(current.left() != previous) {
			previous = current; 
			current = current.parent(); 
		}
		return current; 
	}
	
	public static Node searchBrother(Node current) {
		Node result = searchFather(current).left(); 
		return result; 
	}
	
	public static void printSiblings(PrintWriter output, Node skip, Node current) {
		if(current == skip && current.right() == null) {
			output.println(current.getName() + " has no brothers"); 
			return; 
		}else {
			while (current.right() != null){
				if(current != skip) {
					output.print(current.getName() + ", "); 
				}
				current = current.right(); 
			} 
			if(current != skip) {
				output.print(current.getName()); 
			}
			output.println();

			 
		}
	}
	
	public static void printOldestSibling(PrintWriter output, Node skip, Node current) {
		if(skip != current) {
			output.println(current.getName()); 
		}else {
			output.println("himself");
		}
	}
	
//	current.left().getName().equals(previous.getName()
	
	
//	root = readRoot(input, output, fathers); 
//	readRoot(input, output, fathers, root); 
//	Node found = searchPosttrav("Dan", root); 
//	System.out.println(found.getName()); 
//	System.out.println("searching name: " + searchName); 
//	System.out.println("new siblings: " + siblings); 
//	System.out.print("new current name: "); 
//	System.out.println(current.getName());
//	System.out.print("current name: "); 
//	System.out.println(current.getName());
//	System.out.println("target name: " + searchName);
//	System.out.print("new current name: "); 
//	System.out.println(current.getName());
//	System.out.print("found current name: "); 
//	System.out.println(current.getName());
//	System.out.print("root name: "); 
//	System.out.println(root.getName());
//	System.out.print("searching current name: "); 
//	System.out.println(current.getName());
	
	
//	public static Node searchPosttrav(String target, Node current) { 
//		if(current == null) return null; 
//			
//		Node result = searchPosttrav(target, current.left()); 
//		if(result == null) {
//			result = searchPosttrav(target, current.right()); 
//		}
//		
//		if(current.getName().equals(target)){
//			return current;
//		}
//		return result; 
//	}	
//	public static Node searchPosttrav(String target, Node current) {
//		Node result; 
//		
//		if(current != null) {
//			result = searchPosttrav(target, current.left()); 
//			if(result == null) {
//				result = searchPosttrav(target, current.right()); 
//			}
//			if(current.getName().equals(target)) {
//				current = result;
//			return result;
//			
//			} else {
//				return null;
//			}
//			
//		}
//	}
	

}
