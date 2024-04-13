package org.khiemtran.numbers;

public class CalculatorConundrum {
  public String calculate(int operand1, int operand2, String operation) {
    if (operation == null) {
      throw new IllegalArgumentException("Operation cannot be null");
    }
    int result = switch (operation) {
      case "" -> throw new IllegalArgumentException("Operation cannot be empty");
      case "+" -> operand1 + operand2;
      case "-" -> operand1 - operand2;
      case "*" -> operand1 * operand2;
      case "/" -> {
        try {
          yield operand1 / operand2;
        } catch (ArithmeticException ari) {
          throw new IllegalArgumentException("Division by zero is not allowed", ari);
        }
      }
      default -> throw new IllegalArgumentException(String.format("Operation '%s' does not exist", operation));
    };
    return String.format("%d %s %d = %d", operand1, operation, operand2, result);
  }
}
