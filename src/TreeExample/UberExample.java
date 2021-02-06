package TreeExample;

import java.util.Scanner;

public class UberExample {
	
	/**
	 * create the tree from the Uber Example in presentation
	 * @return example Uber Tree
	 */
	public static Tree<String> CreateUberTree() {
		Tree<String> tree = new Tree("Root"); 
		GTNode<String> loggedOut = tree.addRootChild("Logged Out"); 
		GTNode<String> loggedIn = tree.addRootChild("Logged In");
		
		loggedOut.addChild("On Boarding"); 
		
		GTNode<String> menu = loggedIn.addChild("Menu"); 
		GTNode<String> request = loggedIn.addChild("Request");
		GTNode<String> onTrip = loggedIn.addChild("On Trip"); 
		
		GTNode<String> locationEditor = onTrip.addChild("Location Editor"); 
		locationEditor.addChild("Favorites");
		
		GTNode<String> confirmation = request.addChild("Confirmation"); 
		GTNode<String> refinementSteps = request.addChild("Refinment Steps"); 
		GTNode<String> shortCuts = request.addChild("Short Cuts"); 
		return tree; 
	}
	
	/**
	 * Allow the user to navigate through a string tree and select a node
	 * @param tree tree to navigate
	 * @return node selected by user 
	 */
	public static GTNode<String> navigateTree(Tree<String> tree){
		if(tree.isEmpty()) {
			return null; 
		}else {
			boolean keepGoing = true; 
			GTNode<String> currentNode = tree.getRoot(); 
			Scanner input = new Scanner(System.in); 
			
			while(keepGoing) {
				currentNode.displayTree(); 
				System.out.println("Type the child node  of " + currentNode +" you want to navigate to");
				System.out.println("Enter exit to leave"); 
				String userInput = input.nextLine();
				
				if(userInput.equals("exit")) {
					System.out.println("Selected node: " + currentNode); 
					System.out.println("Exiting navigation"); 
					keepGoing = false; 
				}else {
					GTNode<String> node = currentNode.getChild(userInput);
					if(node == null) {
						System.out.println(userInput + " was invalid, please try again"); 
					}else if( node.isLeaf()) {
						currentNode = node; 
						System.out.println("Selected node: " + currentNode); 
						System.out.println("No further nodes available, exiting naviation"); 
						keepGoing = false; 
					}else {
						currentNode = node; 
						System.out.println("Selected node: " + currentNode + " continue on to select children"); 
					}
				}
			}// leave while 
			
			return currentNode; 
		}
		
	}
	public static void main(String[] args) {
		Tree uberTree = CreateUberTree();
		navigateTree(uberTree); 

	}

}
