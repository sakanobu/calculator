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
    String displayNumber = resultLabel.getText();

    try {
      if (e.getActionCommand().equals("=") && resultPanel.getLastOperationByOperatorPushed()) {
        resultLabel.setText(calculate());
      } else if (e.getActionCommand().equals("=")) {
        resultLabel.setText(calculate());
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setLastOperationByOperatorPushed(true);
      } else if (!operatorLabel.getText().equals("")
          && !resultPanel.getLastOperationByOperatorPushed()) {
        resultLabel.setText(calculate());
        resultPanel.setBeforeNumber(resultLabel.getText());
        resultPanel.setLastOperationByOperatorPushed(true);
        resultPanel.setLastOperationByOperatorPushed(true);
        operatorLabel.setText(e.getActionCommand());
      } else if (e.getActionCommand().matches("[+-×÷]")) {
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setLastOperationByOperatorPushed(true);
        operatorLabel.setText(e.getActionCommand());
      } else {
        throw new Error("到達するはずのない条件節まで来ています。");
      }
    } catch (ArithmeticException ex) {
      resultLabel.setText("0除算です。ACボタンを押してください。");
      resultPanel.setBeforeNumber("0");
      resultPanel.setLastOperationByOperatorPushed(false);
      operatorLabel.setText("");
    }
  }

  String calculate() {
    String displayNumber = resultLabel.getText();

    if (displayNumber.contains("0除算")) {
      return displayNumber;
    }

    if (operatorLabel.getText().equals("")) {
      return displayNumber;
    }

    BigDecimal bigDecimalResult = switch (operatorLabel.getText()) {
      case "+" -> new BigDecimal(resultPanel.getBeforeNumber()).add(new BigDecimal(displayNumber));
      case "-" -> {
        if (resultPanel.getLastOperationByOperatorPushed()) {
          yield new BigDecimal(displayNumber).subtract(
              new BigDecimal(resultPanel.getBeforeNumber()));
        } else {
          yield new BigDecimal(resultPanel.getBeforeNumber()).subtract(
              new BigDecimal(displayNumber));
        }
      }
      case "×" ->
          new BigDecimal(resultPanel.getBeforeNumber()).multiply(new BigDecimal(displayNumber));
      case "÷" -> {
        try {
          if (resultPanel.getLastOperationByOperatorPushed()) {
            yield new BigDecimal(displayNumber).divide(
                new BigDecimal(resultPanel.getBeforeNumber()),
                30,
                RoundingMode.HALF_UP);
          } else {
            yield new BigDecimal(resultPanel.getBeforeNumber()).divide(
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
