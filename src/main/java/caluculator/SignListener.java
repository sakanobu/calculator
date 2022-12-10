package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JLabel;

public class SignListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JLabel pushedOperatorLabel;

  SignListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
    this.pushedOperatorLabel = resultPanel.getPushedOperatorLabel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String displayNumber = resultLabel.getText();
    String cmdName = e.getActionCommand();

    switch (cmdName) {
      case "C":
        resultLabel.setText("0");
        break;
      case "→":
        // ToDo -0, -0. のケースを後ほど追加
        if (displayNumber.equals("0.")) {
          resultLabel.setText("0");
          break;
        } else {
          resultLabel.setText(displayNumber.substring(0, displayNumber.length() - 1));
          break;
        }
      case "%":
        // ToDo 3回くらい繰り返すと誤差が生じてしまう
        if (new BigDecimal(displayNumber).compareTo(BigDecimal.ZERO) == 0) {
          resultLabel.setText("0");
          break;
        } else {
          BigDecimal percentResult = new BigDecimal(displayNumber).scaleByPowerOfTen(-2);
          //          double percentResult = Double.parseDouble(displayNumber) / 100;
          resultLabel.setText(percentResult.toPlainString());
          break;
        }
      case "+":
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setPushedOperator("+");
        resultPanel.setOperatorButtonPushed(true);
        pushedOperatorLabel.setText(resultPanel.getPushedOperator());
        break;
      case "-":
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setPushedOperator("-");
        resultPanel.setOperatorButtonPushed(true);
        pushedOperatorLabel.setText(resultPanel.getPushedOperator());
        break;
      case "×":
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setPushedOperator("×");
        resultPanel.setOperatorButtonPushed(true);
        pushedOperatorLabel.setText(resultPanel.getPushedOperator());
        break;
      case "÷":
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setPushedOperator("÷");
        resultPanel.setOperatorButtonPushed(true);
        pushedOperatorLabel.setText(resultPanel.getPushedOperator());
        break;
      case "=":
        switch (resultPanel.getPushedOperator()) {
          case "+":
            BigDecimal plusResult =
                new BigDecimal(resultPanel.getBeforeNumber()).add(new BigDecimal(
                    displayNumber));
            resultLabel.setText(plusResult.stripTrailingZeros().toPlainString());
            resultPanel.setPushedOperator("");
            pushedOperatorLabel.setText("");
            break;
          case "-":
            BigDecimal minusResult =
                new BigDecimal(resultPanel.getBeforeNumber()).subtract(new BigDecimal(
                    displayNumber));
            resultLabel.setText(minusResult.stripTrailingZeros().toPlainString());
            resultPanel.setPushedOperator("");
            pushedOperatorLabel.setText("");
            break;
          case "×":
            BigDecimal multiplyResult =
                new BigDecimal(resultPanel.getBeforeNumber()).multiply(new BigDecimal(
                    displayNumber));
            resultLabel.setText(multiplyResult.stripTrailingZeros().toPlainString());
            resultPanel.setPushedOperator("");
            pushedOperatorLabel.setText("");
            break;
          case "÷":
            BigDecimal divideResult =
                new BigDecimal(resultPanel.getBeforeNumber()).divide(new BigDecimal(
                    displayNumber), 30, RoundingMode.HALF_UP);
            resultLabel.setText(divideResult.stripTrailingZeros().toPlainString());
            resultPanel.setPushedOperator("");
            pushedOperatorLabel.setText("");
            break;
          default:
            resultLabel.setText("演算子のswitch文でdefault節まで到達しました。");
        }
        break;
      default:
        resultLabel.setText("SignListenerのswitch文でdefault節まで到達しました。");
    }
  }
}
