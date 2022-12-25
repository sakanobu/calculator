package caluculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
  public static String calculate(String beforeNumber, String displayNumber, String operator,
                                 boolean lastOperationByOperatorPushed) {
    BigDecimal bigDecimalResult = switch (operator) {
      case "+" -> new BigDecimal(beforeNumber).add(new BigDecimal(displayNumber));
      case "-" -> {
        if (lastOperationByOperatorPushed) {
          yield new BigDecimal(displayNumber).subtract(
              new BigDecimal(beforeNumber));
        } else {
          yield new BigDecimal(beforeNumber).subtract(
              new BigDecimal(displayNumber));
        }
      }
      case "×" -> new BigDecimal(beforeNumber).multiply(new BigDecimal(displayNumber));
      case "÷" -> {
        try {
          if (lastOperationByOperatorPushed) {
            yield new BigDecimal(displayNumber).divide(
                new BigDecimal(beforeNumber),
                30,
                RoundingMode.HALF_UP);
          } else {
            yield new BigDecimal(beforeNumber).divide(
                new BigDecimal(displayNumber),
                30,
                RoundingMode.HALF_UP);
          }
        } catch (ArithmeticException ex) {
          throw new ArithmeticException("0除算");
        }
      }
      default -> throw new Error("到達するはずのないdefault節まで来ています。");
    };
    return bigDecimalResult.stripTrailingZeros().toPlainString();
  }

}
