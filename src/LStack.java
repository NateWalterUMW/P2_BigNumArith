// Linked stack implementation
class LStack implements Stack {
  private String top;               // Pointer to first element
  private int size;               // Number of elements

  // Constructors
  LStack() { top = null; size = 0; }
  LStack(int size) { top = null; size = 0; }

  // Reinitialize stack
  public void clear() { top = null; size = 0; }

// Put "it" on stack
  public boolean push(String it) {  
    top = new String(it);
    size++;
    return true;
  }

// Remove "it" from stack
  public String pop() {           
    if (top == null) return null;
    String it = top;
    //top = top;
    size--;
    return it;
  }

  public String topValue() {      // Return top value
    if (top == null) return null;
    return top;
  }

  // Return stack length
  public int length() { return size; }
  
  // Check if the stack is empty
  public boolean isEmpty() { return size == 0; }
}

