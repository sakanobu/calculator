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
        resultPanel.setPushedOperator("");
        pushedOperatorLabel.setText("");
        break;
      case "→":
        // ToDo -0, -0. のケースを後ほど追加
        if (displayNumber.equals("0.")) {
          resultLabel.setText("0");
        } else {
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
        if (displayNumber.matches("^-.*")) {
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
