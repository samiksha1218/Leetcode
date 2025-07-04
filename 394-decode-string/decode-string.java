class Solution {
  public String decodeString(String s) {
    Stack<Pair<StringBuilder, Integer>> stack = new Stack<>(); // (prevStr, repeatCount)
    StringBuilder currStr = new StringBuilder();
    int currNum = 0;

    for (final char c : s.toCharArray())
      if (Character.isDigit(c)) {
        currNum = currNum * 10 + (c - '0');
      } else {
        if (c == '[') {
          stack.push(new Pair<>(currStr, currNum));
          currStr = new StringBuilder();
          currNum = 0;
        } else if (c == ']') {
          final Pair<StringBuilder, Integer> pair = stack.pop();
          final StringBuilder prevStr = pair.getKey();
          final int n = pair.getValue();
          currStr = prevStr.append(currStr.toString().repeat(n));
        } else {
          currStr.append(c);
        }
      }

    return currStr.toString();
  }
}