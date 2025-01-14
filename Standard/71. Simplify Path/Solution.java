import java.util.Stack;

class Solution {
  public String simplifyPath(String path) {
    StringBuilder sb = new StringBuilder();
    Stack<String> stack = new Stack<>();
    String[] strArr = path.split("/");

    for (int i = 0; i < strArr.length; i++) {
      if (strArr[i].equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (strArr[i].equals(".") || strArr[i].equals("")) {
        continue;
      } else {
        stack.push(strArr[i]);
      }
    }

    if (stack.isEmpty()) {
      return "/";
    }

    while (!stack.isEmpty()) {
      sb = new StringBuilder("/" + stack.pop()).append(sb);
    }

    return sb.toString();
  }
}