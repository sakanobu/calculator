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

    switch (cmdName) {
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
          case "":
            resultLabel.setText(displayNumber);
            break;
          default:
            resultLabel.setText("演算子のswitch文でdefault節まで到達しました。");
        }
        break;
      default:
        resultLabel.setText("OperatorListenerのswitch文でdefault節まで到達しました。");
    }
  }
}
