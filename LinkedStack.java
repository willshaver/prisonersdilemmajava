package a6;

/**
 * A linked list-based implementation of the {@code Stack} interface.
 *
 */
public class LinkedStack implements Stack {
    // the number of elements currently on the stack
    private int size;
    
    // the node containing the top element of the stack
    private Node top;
    
    
    private static class Node {
            
        // the element stored in the node
        String elem;
    
        // the link to the next node in the sequence
        Node next;
    
        Node(String elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }
    

    /**
     * Initializes and empty stack.
     */
    public LinkedStack() {
    	this.size = 0;
    	this.top = null;
    }


	@Override
	public int size() {
		return this.size;
	}


	@Override
	public void push(String elem) {
		Node n = new Node(elem, this.top);
		this.top = n;
		this.size++;
	}


	@Override
	public String pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("popped an empty stack");
		}
		String popped = this.top.elem;
		this.top = this.top.next;
		this.size--;
		return popped;
	}
    
	/**
     * Returns a string representation of this stack. The elements of the stack
     * appear in the returned string in sequence starting from the top of the
     * stack to the bottom of the stack with each element separated from the
     * next using a newline character.
     * 
     * @return a string representation of this stack
     */
	@Override
    public String toString() {
        StringBuilder b = new StringBuilder("Stack:");
        Node n = this.top;
        while (n != null) {
            b.append('\n');
            b.append(n.elem);
            n = n.next;
        }
        return b.toString();
    }
	
	

	public LinkedStack(String a, String b) {
		 top = new Node(a, new Node(b, null));
	}
	
	
	public void bottomsUp() {
		 if (isEmpty() || top.next == null) {
		     return;
		 }
		 Node secondToLast = top;
		 while (secondToLast.next.next != null) {
		       secondToLast = secondToLast.next;
		 }
		 Node bottom = secondToLast.next;
		 secondToLast.next = null; 
		 bottom.next = top; 
		 top = bottom; 
	}

	
	
	@Override
	public boolean equals(Object obj) {
		 if (this == obj) {
	            return true; // Same object reference
	        }

	        if (obj == null || getClass() != obj.getClass()) {
	            return false; // Not the same class or null
	        }

	        LinkedStack otherStack = (LinkedStack) obj;

	        Node thisCurrent = top;
	        Node otherCurrent = otherStack.top;

	        while (thisCurrent != null && otherCurrent != null) {
	            if (!thisCurrent.elem.equals(otherCurrent.elem)) {
	                return false; // Element mismatch
	            }

	            thisCurrent = thisCurrent.next;
	            otherCurrent = otherCurrent.next;
	        }

	        // Both stacks should reach the end at the same time
	        return thisCurrent == null && otherCurrent == null;
	    }
	
	public static void main(String[] args) {
	}
}
