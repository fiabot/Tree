package TreeExample;

/**
 * A basic interface for a tree
 * @author Fiona Shyne
 *
 */

public interface GenTree<T> {
	
	/**
	 * remove all elements from tree
	 */
	public void clear();
	
	/**
	 * returns the root of tree
	 * @return root node of tree, null if empty
	 */
	public GTNode<T> getRoot();
	
	/**
	 * Add a new root given a value
	 * if root already exists, make old root child of new root
	 * @param value value of new root
	 */
	public void newRoot(T value);
	
	/**
	 * Add a new root given a node 
	 * if root already exists, make old root child of new root
	 * @param root node to make new root 
	 */
	public void newRoot(GTNode<T> root);
	
	/**
	 * Add a new child to the root given a value
	 * @param value value of new child node
	 * @return new child node of root
	 * @throws TreeEmptyException throws when tree is empty
	 */
	public GTNode<T> addRootChild(T value) throws TreeEmptyException; 
	
	/**
	 * Add a new child to the root given a value 
	 * @param child node of new root child
	 * @throws TreeEmptyException throws when tree is empty
	 */
	public void addRootChild(GTNode<T> child) throws TreeEmptyException; 
	
	/**
	 * returns true if there is a node that contains value
	 * @param value value of node to look for
	 * @return true if value is in tree 
	 * @throws TreeEmptyException throws when tree is empty
	 */
	public boolean hasElement(T value)  throws TreeEmptyException; 
	
	/**
	 * returns true if node is in tree
	 * @param node node to look for
	 * @return true if node is in tree
	 * @throws TreeEmptyException throws when tree is empty
	 */
	public boolean hasElement(GTNode<T> node)  throws TreeEmptyException;
	
	/**
	 * return a node with the given value of tree
	 * @param value value of node to look for
	 * @return node of tree with value, null if non-existent 
	 * @throws TreeEmptyException throws when tree is empty
	 */
	public GTNode<T> getElement(T value)  throws TreeEmptyException; 
	
	/**
	 * returns true if there are not elements in tree
	 * @return true if there is no root
	 */
	public boolean isEmpty(); 
	
	public void display() throws TreeEmptyException; 
}
