package TreeExample;

public class TreeEmptyException extends RuntimeException {

	public TreeEmptyException(String message) {
		super(message); 
	}
	
	public TreeEmptyException() {
		super("Cannot prefrom action on empty tree"); 
	}

}
