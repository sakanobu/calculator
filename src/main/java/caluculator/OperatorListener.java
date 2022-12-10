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
      resultLabel.setText(calculateWhenEqualRepushed());
    } else if (cmdName.equals("=")) {
      resultLabel.setText(calculate());
      resultPanel.setBeforeNumber(displayNumber);
      resultPanel.setLastOperationByOperatorPushed(true);
    } else if (!resultPanel.getPushedOperator().equals("")
        && !resultPanel.isLastOperationByOperatorPushed()) {
      resultLabel.setText(calculate());
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
    BigDecimal bigDecimalResult = BigDecimal.ZERO;

    switch (resultPanel.getPushedOperator()) {
      case "+":
        bigDecimalResult =
            new BigDecimal(resultPanel.getBeforeNumber()).add(new BigDecimal(displayNumber));
        break;
      case "-":
        bigDecimalResult =
            new BigDecimal(resultPanel.getBeforeNumber()).subtract(new BigDecimal(displayNumber));
        break;
      case "×":
        bigDecimalResult =
            new BigDecimal(resultPanel.getBeforeNumber()).multiply(new BigDecimal(displayNumber));
        break;
      case "÷":
        bigDecimalResult =
            new BigDecimal(resultPanel.getBeforeNumber()).divide(new BigDecimal(displayNumber), 30,
                RoundingMode.HALF_UP);
        break;
      default:
        resultLabel.setText("OperatorListenerのswitch文③でdefault節まで到達しました。");
    }

    return bigDecimalResult.stripTrailingZeros().toPlainString();
  }

  String calculateWhenEqualRepushed() {
    String displayNumber = resultLabel.getText();
    BigDecimal bigDecimalResult = BigDecimal.ZERO;

    switch (resultPanel.getPushedOperator()) {
      case "+":
        bigDecimalResult =
            new BigDecimal(resultPanel.getBeforeNumber()).add(new BigDecimal(displayNumber));
        break;
      case "-":
        bigDecimalResult =
            new BigDecimal(displayNumber).subtract(new BigDecimal(resultPanel.getBeforeNumber()));
        break;
      case "×":
        bigDecimalResult =
            new BigDecimal(resultPanel.getBeforeNumber()).multiply(new BigDecimal(displayNumber));
        break;
      case "÷":
        bigDecimalResult =
            new BigDecimal(displayNumber).divide(new BigDecimal(resultPanel.getBeforeNumber()), 30,
                RoundingMode.HALF_UP);
        break;
      case "":
        resultLabel.setText("pushedOperatorが空文字列にもかかわらずcalculateメソッドが呼ばれました。");
        break;
      default:
        resultLabel.setText("OperatorListenerのswitch文③でdefault節まで到達しました。");
    }

    return bigDecimalResult.stripTrailingZeros().toPlainString();
  }
}
