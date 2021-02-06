package TreeExample;
import java.util.ArrayList;
/**
 * A basic implementation of a tree node 
 * @author Fiona Shyne
 *
 */
public class TreeNode<T> implements GTNode<T>{
	public static final String INDENTSPACE = "  ";
	T value; 
	GTNode<T> parent; 
	ArrayList<GTNode<T>> children; 
	
	
	/**
	 * Node constructor given value and parent
	 * @param data value of node 
	 * @param parent parent of node
	 */
	public TreeNode (T data, GTNode<T> parent){
		value= data; 
		this.parent = parent; 
		children = new ArrayList<GTNode<T>>();
	}
	
	/**
	 * Node constructor given value of node, 
	 * automatically a root with no parent
	 * @param data value of node
	 */
	public TreeNode (T data){
		this(data, null);
	}
	
	/**
	 * Get the data in the node
	 * @return value of node 
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * Set data of node
	 * @param value date to set node to
	 * @return none
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/**
	 * get parent of node
	 * @return parent node, null if root
	 */
	public GTNode<T> getParent() {
		return parent;
	}

	public void setParent(GTNode<T> parent) {
		this.parent = parent;
	}
	
	/**
	 * returns true if nodes is at the top of the tree
	 * @return true if node has no parent 
	 */
	@Override
	public boolean isRoot() {
		return parent == null; 
	}
	
	/**
	 * returns if node does not have any children
	 * @return true if node is leaf 
	 */
	@Override
	public boolean isLeaf() {
		return numberOfChildren() == 0; 
	}
	
	/**
	 * return the number of children in node
	 * @return number of child nodes 
	 */
	@Override
	public int numberOfChildren() {
		return children.size(); 
	}
	
	/**
	 * get the node at the given index
	 * @param index location of node
	 * @return node at location 
	 */
	@Override
	public GTNode<T> getChild(int index) throws  IndexOutOfBoundsException{
		if (index < 0 || index >= numberOfChildren()) {
			throw new  IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}else {
			return children.get(index);
		}
		
	}
	
	/**
	 * returns the child with a given value 
	 * returns null if child does not exist
	 * @param value value of child to look for
	 * @return child node with given value, null if does not exist
	 */
	public GTNode<T> getChild(T value){
		boolean foundChild = false; 
		GTNode<T> outChild = null; 
		int index = 0; 
		while (!foundChild && index < numberOfChildren()) {
			GTNode<T> child = getChild(index); 
			if(child.getValue().equals(value)) {
				foundChild = true; 
				outChild = child;
			}
			index ++; 
		}
		
		return outChild; 
	}
	
	/**
	 * get an array of all children of the node
	 * @return child node array
	 */
	@Override
	public GTNode<T>[] getChildren() {
		GTNode<T>[] returnArr = new GTNode[numberOfChildren()];
		children.toArray(returnArr); 
		return returnArr;
	}
	
	/**
	 * returns the node with given value if it is somewhere below this node
	 * returns null if node is not in tree below this one
	 * @param value value of node to get
	 * @return node with value if below tree, else null 
	 */
	public GTNode<T> getElement(T value){
		if(this.getValue().equals(value)) {
			return this;
		}else {
			boolean foundChild = false; 
			int index = 0; 
			while (!foundChild && index < numberOfChildren()) {
				GTNode<T> child = getChild(index); 
				if(child.getValue().equals(value)) {
					foundChild = true; 
					return child; 
				}else {
					GTNode<T> childEle = child.getElement(value); 
					if (childEle != null) {
					
						foundChild = true; 
						return childEle; 
					}
				}
				
				index ++; 
			}		
		}
		return null; 
	}

	
	/**
	 * returns if node is one of it's children
	 * @param node node to look for
	 * @return true if node is a child 
	 */
	@Override
	public boolean hasChild(GTNode<T> node) {
		// TODO Auto-generated method stub
		return children.contains(node);
	}
	
	/**
	 * returns if there is a child that contains this value
	 * @param value value to look for
	 * @return true if value is found in children 
	 */
	@Override
	public boolean hasChild(T value) {
		boolean foundChild = false; 
		int index = 0; 
		while (!foundChild && index < numberOfChildren()) {
			GTNode<T> child = getChild(index); 
			if(child.getValue().equals(value)) {
				foundChild = true; 
			}
			index ++; 
		}
		return foundChild;
	}
	
	/**
	 * return true if node is element or element is anywhere below it
	 * @param element node to look for
	 * @return true if element is in the tree below this node
	 */
	@Override
	public boolean hasElement(GTNode<T> element) {
		if(this.equals(element)) {
			return true;
		}else {
			boolean foundChild = false; 
			int index = 0; 
			while (!foundChild && index < numberOfChildren()) {
				GTNode<T> child = getChild(index); 
				if(child.equals(element)) {
					foundChild = true; 
				}else if (child.hasElement(element)) {
					foundChild = true; 
				}
				index ++; 
			}
			return foundChild;
		}
		
	}
	
	/**
	 * return true if node contains value or if any node below it contains the value 
	 * @param element value to look for
	 * @return true if element is found anywhere in the tree below this node
	 */
	@Override
	public boolean hasElement(T element) {
		if(this.getValue().equals(element)) {
			return true;
		}else {
			boolean foundChild = false; 
			int index = 0; 
			while (!foundChild && index < numberOfChildren()) {
				GTNode<T> child = getChild(index); 
				if(child.getValue().equals(element)) {
					foundChild = true; 
				}else if (child.hasElement(element)) {
					foundChild = true; 
				}
				index ++; 
			}
			return foundChild;
		}
	}
	
	/**
	 * Add a node to this on as a child
	 * Sets the parent of child to this node
	 * @param child node to add 
	 */
	@Override
	public void addChild(GTNode<T> child) {
		child.setParent(this);
		children.add(child);
		
	}
	
	/**
	 * Create and add a note that contains value as a child
	 * Set the parent of child to this node
	 * @param value value of child node to add 
	 */
	@Override
	public GTNode<T> addChild(T value) {
		GTNode<T> child = new TreeNode<T>(value, this);
		children.add(child); 
		return child; 
		
	}
	
	/**
	 * remove a child with a certain value 
	 * returns true if successful
	 * if there are more then one child with the value, remove one of them
	 * @param value value of child to remove
	 * @return true if child was successfully removed, false if no child node had value
	 */
	@Override
	public boolean removeChild(T value) {
		boolean foundChild = false; 
		GTNode childToRemove = null; 
		int index = 0; 
		while (!foundChild && index < numberOfChildren()) {
			GTNode<T> child = getChild(index); 
			if(child.getValue().equals(value)) {
				foundChild = true; 
				childToRemove = child; 
			}
			index ++; 
		}
		if(foundChild) {
			children.remove(childToRemove);
		}
		return foundChild;
	}
	
	/**
	 * Removes a node if it is a child of this node 
	 * returns true if successful 
	 * if there duplicate nodes removes one of them
	 * @param node child node to remove
	 * @return true if child was successfully removed, false if node was not a child
	 */
	@Override
	public boolean removeChild(GTNode<T> node) {
		// TODO Auto-generated method stub
		return children.remove(node);
	}
	
	public String toString() {
		return getValue().toString();
	}
	
	/**
	 * Testing of tree node
	 */
	public static void main (String[] args) {
		TreeNode<String> node = new TreeNode<>("Root");
		node.addChild("Child1");
		node.addChild("Child2");
		GTNode<String> child = node.getChild(0);
		child.addChild("Child2");
		GTNode<String> child2 = child.getChild(0);
		//System.out.println(node.getElement("Child3")); 
		System.out.println(node.numberOfChildren()); 
		node.displayTree();
	}
	
	public void displayTree() {
		System.out.println(this); 
		for(int i =0; i < numberOfChildren(); i++) {
			getChild(i).displayTree(INDENTSPACE);
		}
	}
	
	public void displayTree(String header) {
		System.out.println(header + this); 
		for(int i =0; i < numberOfChildren(); i++) {
			getChild(i).displayTree(INDENTSPACE + header);
		}
	}
	

}
