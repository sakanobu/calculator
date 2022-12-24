package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JLabel;

public class SignListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JLabel operatorLabel;

  SignListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
    this.operatorLabel = resultPanel.getOperatorLabel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String displayNumber = resultLabel.getText();
    String cmdName = e.getActionCommand();

    if (displayNumber.contains("0除算")) {
      resultLabel.setText("0");
      resultPanel.setBeforeNumber("0");
      resultPanel.setLastOperationByOperatorPushed(false);
      operatorLabel.setText("");
      return;
    }

    switch (cmdName) {
      case "AC":
        resultLabel.setText("0");
        resultPanel.setBeforeNumber("0");
        resultPanel.setLastOperationByOperatorPushed(false);
        operatorLabel.setText("");
        break;
      case "C":
        resultLabel.setText("0");
        break;
      case "→":
        if ((displayNumber.contains("-") && displayNumber.length() == 2)
            || (displayNumber.length() == 1)) {
          resultLabel.setText("0");
        } else if ((displayNumber.contains("-") && displayNumber.length() >= 3)
            || (!displayNumber.contains("-") && displayNumber.length() >= 2)) {
          resultLabel.setText(displayNumber.substring(0, displayNumber.length() - 1));
        }
        break;
      case "%":
        if (new BigDecimal(displayNumber).compareTo(BigDecimal.ZERO) == 0) {
          resultLabel.setText("0");
        } else {
          BigDecimal percentResult = new BigDecimal(displayNumber).scaleByPowerOfTen(-2);
          resultLabel.setText(percentResult.toPlainString());
        }
        break;
      case "±":
        if (resultPanel.getLastOperationByOperatorPushed()) {
          resultLabel.setText("-0");
          resultPanel.setLastOperationByOperatorPushed(false);
        } else if (displayNumber.matches("^-.*")) {
          resultLabel.setText(displayNumber.substring(1));
        } else {
          resultLabel.setText("-" + displayNumber);
        }
        break;
      default:
        resultLabel.setText("SignListenerのswitch文でdefault節まで到達しました。");
    }
  }
}
