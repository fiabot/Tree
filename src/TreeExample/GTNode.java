package TreeExample;
/**
 * A basic interface for a tree node
 * @author Fiona Shyne
 * 
 */
public interface GTNode <T> {
	/**
	 * Get the data in the node
	 * @return value of node 
	 */
	public T getValue();
	
	/**
	 * Set data of node
	 * @param value date to set node to
	 * @return none
	 */
	public void setValue(T value); 
	
	/**
	 * returns true if nodes is at the top of the tree
	 * @return true if node has no parent 
	 */
	public boolean isRoot(); 
	
	/**
	 * returns if node does not have any children
	 * @return true if node is leaf 
	 */
	public boolean isLeaf();
	
	/**
	 * get parent of node
	 * @return parent node, null if root
	 */
	public GTNode<T> getParent(); 
	
	/**
	 * return the number of children in node
	 * @return number of child nodes 
	 */
	public int numberOfChildren(); 
	
	/**
	 * get the node at the given index
	 * @param index location of node
	 * @return node at location 
	 */
	public GTNode<T> getChild(int index); 
	
	/**
	 * returns the child with a given value 
	 * returns null if child does not exist
	 * @param value value of child to look for
	 * @return child node with given value, null if does not exist
	 */
	public GTNode<T> getChild(T value);
	
	/**
	 * get an array of all children of the node
	 * @return child node array
	 */
	public GTNode<T>[] getChildren(); 
	
	/**
	 * returns the node with given value if it is somewhere below this node
	 * returns null if node is not in tree below this one
	 * @param value value of node to get
	 * @return node with value if below tree, else null 
	 */
	public GTNode<T> getElement(T value);
	
	/**
	 * returns if node is one of it's children
	 * @param node node to look for
	 * @return true if node is a child 
	 */
	public boolean hasChild(GTNode<T> node); 
	
	/**
	 * returns if there is a child that contains this value
	 * @param value value to look for
	 * @return true if value is found in children 
	 */
	public boolean hasChild(T value); 
	
	/**
	 * return true if node is element or element is anywhere below it
	 * @param element node to look for
	 * @return true if element is in the tree below this node
	 */
	public boolean hasElement(GTNode<T> element); 
	
	/**
	 * return true if node contains value or if any node below it contains the value 
	 * @param element value to look for
	 * @return true if element is found anywhere in the tree below this node
	 */
	public boolean hasElement(T element); 
	
	/**
	 * Add a node to this on as a child
	 * Sets the parent of child to this node
	 * @param child node to add 
	 */
	public void addChild(GTNode<T> child); 
	
	/**
	 * Create and add a note that contains value as a child
	 * Set the parent of child to this node
	 * @param value value of child node to add 
	 */
	public GTNode<T> addChild(T value);
	
	/**
	 * remove a child with a certain value 
	 * returns true if successful
	 * if there are more then one child with the value, remove one of them
	 * @param value value of child to remove
	 * @return true if child was successfully removed, false if no child node had value
	 */
	public boolean removeChild(T value);
	
	/**
	 * Removes a node if it is a child of this node 
	 * returns true if successful 
	 * if there duplicate nodes removes one of them
	 * @param node child node to remove
	 * @return true if child was successfully removed, false if node was not a child
	 */
	public boolean removeChild(GTNode<T> node);
	
	/**
	 * Set a node as parent to this one
	 * @param par node to make parent 
	 */
	public void setParent(GTNode<T> par); 
	
	public void displayTree(); 
	
	public void displayTree(String header);


}
