/**
 * 
 */
package TreeExample;

/**
 * A basic implementation for a tree 
 * @author Fiona Shyne
 *
 */
public class Tree<T> implements GenTree<T> {
	
	GTNode<T> root; 

	/**
	 * Default constructor for an empty tree 
	 */
	public Tree() {
		root = null; 
	}
	
	/**
	 * Tree constructor that creates a root node with the given value
	 * @param rootValue value of root node for tree
	 */
	public Tree(T rootValue) {
		GTNode<T> node = new TreeNode<T>(rootValue); 
		root = node; 
	}
	
	/**
	 * Tree constructor with given node as root
	 * @param root node to make root of tree 
	 */
	public Tree(GTNode<T> root) {
		this.root = root; 
	}


	/**
	 * remove all elements from tree
	 */
	@Override
	public void clear() {
		root = null; 
		
	}
	
	/**
	 * returns the root of tree
	 * @return root node of tree, null if empty
	 */
	@Override
	public GTNode<T> getRoot() {
		return root; 
	}
	
	/**
	 * Add a new root given a value
	 * if root already exists, make old root child of new root
	 * @param value value of new root
	 */
	@Override
	public void newRoot(T value) {
		GTNode<T> newRoot = new TreeNode<T>(value); 
		if(root != null) {
			newRoot.addChild(root);
		}
		
		root = newRoot; 
		
	}
	
	/**
	 * Add a new root given a node 
	 * if root already exists, make old root child of new root
	 * @param root node to make new root 
	 */
	@Override
	public void newRoot(GTNode<T> newRoot) {
		if(root != null) {
			newRoot.addChild(root);
		}
		
		root = newRoot; 
		
	}
	
	/**
	 * Add a new child to the root given a value
	 * @param value value of new child node
	 * @return new child node of root
	 * @throws TreeEmptyException throws when tree is empty
	 */
	@Override
	public GTNode<T> addRootChild(T value) throws TreeEmptyException {
		if(!isEmpty()) {
			GTNode<T> newChild = new TreeNode<T>(value); 
			root.addChild(newChild);
			return newChild;
		}else {
			throw new TreeEmptyException(); 
		}
		
	}

	/**
	 * Add a new child to the root given a value 
	 * @param child node of new root child
	 * @throws TreeEmptyException throws when tree is empty
	 */
	@Override
	public void addRootChild(GTNode<T> child) throws TreeEmptyException{
		if(!isEmpty()) {
			root.addChild(child);
		}
		else {
			throw new TreeEmptyException(); 
		}
		
	}
	
	/**
	 * returns true if there is a node that contains value
	 * @param value value of node to look for
	 * @return true if value is in tree 
	 * @throws TreeEmptyException throws when tree is empty
	 */
	@Override
	public boolean hasElement(T value) throws TreeEmptyException {
		if(isEmpty()) {
			throw new TreeEmptyException();
		}else {
			return root.hasElement(value); 
		}
	}
	
	/**
	 * returns true if node is in tree
	 * @param node node to look for
	 * @return true if node is in tree
	 * @throws TreeEmptyException throws when tree is empty
	 */
	@Override
	public boolean hasElement(GTNode<T> node)  throws TreeEmptyException{
		if(isEmpty()) {
			throw new TreeEmptyException();
		}else {
			return root.hasElement(node); 
		}
	}

	/**
	 * return a node with the given value of tree
	 * @param value value of node to look for
	 * @return node of tree with value, null if non-existent 
	 * @throws TreeEmptyException throws when tree is empty
	 */
	@Override
	public GTNode<T> getElement(T value) throws TreeEmptyException{
		if(isEmpty()) {
			throw new TreeEmptyException();
		}else {
			return root.getElement(value); 
		}
	}
	
	/**
	 * returns true if there are not elements in tree
	 * @return true if there is no root
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}
	
	@Override
	public void display() throws TreeEmptyException {
		if(isEmpty()) {
			throw new TreeEmptyException(); 
		}else {
			root.displayTree();
		}
		
	}
 
	
	/**
	 * Test tree
	 */
	public static void main(String[] args) {
		Tree<String> tree = new Tree("Root");

		GTNode<String> node = tree.addRootChild("Child1");
		GTNode<String> node3 = node.addChild("Child5");
		node3.addChild("Child6");
		GTNode<String> node2 = node.addChild("Child2");
		node2.addChild("Child3");
		node2.addChild("Child4");
		System.out.println(tree.getElement("Child3")); 
		tree.display();
	
		
		

	}



	

}
