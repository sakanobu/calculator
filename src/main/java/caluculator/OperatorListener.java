package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JLabel;

public class OperatorListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JLabel pushedOperatorLabel;

  OperatorListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
    this.pushedOperatorLabel = resultPanel.getPushedOperatorLabel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String displayNumber = resultLabel.getText();
    String cmdName = e.getActionCommand();

    if (cmdName.equals("=") && resultPanel.isLastOperationByOperatorPushed()) {
      try {
        resultLabel.setText(calculate());
      } catch (ArithmeticException ex) {
        resultLabel.setText("0除算です。ACボタンを押してください。");
        resultPanel.setBeforeNumber("0");
        resultPanel.setPushedOperator("");
        resultPanel.setLastOperationByOperatorPushed(false);
        pushedOperatorLabel.setText("");
      } catch (NumberFormatException ex) {
        resultLabel.setText("エラーです。ACボタンを押してください。");
        resultPanel.setBeforeNumber("0");
        resultPanel.setPushedOperator("");
        resultPanel.setLastOperationByOperatorPushed(false);
        pushedOperatorLabel.setText("");
      }
    } else if (cmdName.equals("=")) {
      try {
        resultLabel.setText(calculate());
      } catch (ArithmeticException ex) {
        resultLabel.setText("0除算です。ACボタンを押してください。");
        resultPanel.setBeforeNumber("0");
        resultPanel.setPushedOperator("");
        resultPanel.setLastOperationByOperatorPushed(false);
        pushedOperatorLabel.setText("");
      } catch (NumberFormatException ex) {
        resultLabel.setText("エラーです。ACボタンを押してください。");
        resultPanel.setBeforeNumber("0");
        resultPanel.setPushedOperator("");
        resultPanel.setLastOperationByOperatorPushed(false);
        pushedOperatorLabel.setText("");
      }
      resultPanel.setBeforeNumber(displayNumber);
      resultPanel.setLastOperationByOperatorPushed(true);
    } else if (!resultPanel.getPushedOperator().equals("")
        && !resultPanel.isLastOperationByOperatorPushed()) {
      try {
        resultLabel.setText(calculate());
      } catch (ArithmeticException ex) {
        resultLabel.setText("0除算です。ACボタンを押してください。");
        resultPanel.setBeforeNumber("0");
        resultPanel.setPushedOperator("");
        resultPanel.setLastOperationByOperatorPushed(false);
        pushedOperatorLabel.setText("");
      } catch (NumberFormatException ex) {
        resultLabel.setText("エラーです。ACボタンを押してください。");
        resultPanel.setBeforeNumber("0");
        resultPanel.setPushedOperator("");
        resultPanel.setLastOperationByOperatorPushed(false);
        pushedOperatorLabel.setText("");
      }
      resultPanel.setBeforeNumber(resultLabel.getText());
      resultPanel.setPushedOperator(cmdName);
      resultPanel.setLastOperationByOperatorPushed(true);
      pushedOperatorLabel.setText(resultPanel.getPushedOperator());
    } else if (cmdName.matches("[+-×÷]")) {
      resultPanel.setBeforeNumber(displayNumber);
      resultPanel.setPushedOperator(cmdName);
      resultPanel.setLastOperationByOperatorPushed(true);
      pushedOperatorLabel.setText(resultPanel.getPushedOperator());
    } else {
      resultLabel.setText("到達するはずのない条件節まで来ています。");
    }
  }

  String calculate() {
    String displayNumber = resultLabel.getText();

    if (displayNumber.contains("0除算")) {
      return displayNumber;
    }

    if (resultPanel.getPushedOperator().equals("")) {
      return displayNumber;
    }

    BigDecimal bigDecimalResult = switch (resultPanel.getPushedOperator()) {
      case "+" -> new BigDecimal(resultPanel.getBeforeNumber()).add(new BigDecimal(displayNumber));
      case "-" -> {
        if (resultPanel.isLastOperationByOperatorPushed()) {
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
          if (resultPanel.isLastOperationByOperatorPushed()) {
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
      default -> new BigDecimal(
          "9999999999999999999999999999999999999999999999999999999999999999999999");
    };
    return bigDecimalResult.stripTrailingZeros().toPlainString();
  }
}
