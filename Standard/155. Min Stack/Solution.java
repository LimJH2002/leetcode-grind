import java.util.Stack;

class MinStack {

  private Stack<Integer> mainStack;
  private Stack<Integer> auxStack;

  public MinStack() {
    mainStack = new Stack<>();
    auxStack = new Stack<>();
  }

  public void push(int val) {
    if (auxStack.isEmpty() || val <= auxStack.peek()) {
      auxStack.push(val);
      mainStack.push(val);
    } else {
      mainStack.push(val);
    }
  }

  public void pop() {
    if (mainStack.peek().intValue() == auxStack.peek().intValue()) {
      mainStack.pop();
      auxStack.pop();
    } else {
      mainStack.pop();
    }
  }

  public int top() {
    return mainStack.peek();
  }

  public int getMin() {
    return auxStack.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */