package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JLabel;

public class OperatorListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JLabel operatorLabel;

  OperatorListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
    this.operatorLabel = resultPanel.getOperatorLabel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String tmpDisplayNumber = resultLabel.getText();

    try {
      if (e.getActionCommand().equals("=")) {
        if (resultLabel.getText().contains("0除算") || operatorLabel.getText().equals("")) {
          return;
        }
        resultLabel.setText(
            calculate(resultPanel.getBeforeNumber(), resultLabel.getText(), operatorLabel.getText(),
                resultPanel.getLastOperationByOperatorPushed()));
        if (!resultPanel.getLastOperationByOperatorPushed()) {
          resultPanel.setBeforeNumber(tmpDisplayNumber);
          resultPanel.setLastOperationByOperatorPushed(true);
        }
        return;
      }
      if (operatorLabel.getText().matches("[+-×÷]")
          && !resultPanel.getLastOperationByOperatorPushed()) {
        if (resultLabel.getText().contains("0除算") || operatorLabel.getText().equals("")) {
          return;
        }
        resultLabel.setText(
            calculate(resultPanel.getBeforeNumber(), resultLabel.getText(), operatorLabel.getText(),
                resultPanel.getLastOperationByOperatorPushed()));
        resultPanel.setBeforeNumber(resultLabel.getText());
      } else {
        resultPanel.setBeforeNumber(tmpDisplayNumber);
      }
      resultPanel.setLastOperationByOperatorPushed(true);
      operatorLabel.setText(e.getActionCommand());
    } catch (ArithmeticException ex) {
      resultLabel.setText("0除算です。ACボタンを押してください。");
      resultPanel.setBeforeNumber("0");
      resultPanel.setLastOperationByOperatorPushed(false);
      operatorLabel.setText("");
    }
  }

  String calculate(String beforeNumber, String displayNumber, String operator,
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
