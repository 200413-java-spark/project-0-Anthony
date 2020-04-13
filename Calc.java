class Calc {
  public static void main(String[] args) {
    int varOne = Integer.parseInt(args[0]);
    String operator = args[1];
    int varTwo = Integer.parseInt(args[2]);
    int result = 0;
    switch (operator) {
      case "+":
        result = varOne + varTwo;
        break;
      case "-":
        result = varOne - varTwo;
        break;
      // case "*":
      // result = varOne * varTwo;
      // break;
      // case "/":
      // result = varOne / varTwo;
      // break;
      default:
        System.out.println("Hello World");
    }
    System.out.println(result);
  }
}