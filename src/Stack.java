public interface Stack { // Stack class ADT
  // Reinitialize the stack.
  //public void clear();

  // Push "it" onto the top of the stack
  public boolean push(String it);

  // Remove and return the element at the top of the stack
  public String pop();

  // Return a copy of the top element
  //public String topValue();

  // Return the number of elements in the stack
  public int length();
  
  // Return true if the stack is empty 
  //public boolean isEmpty();
}
