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
    if (resultLabel.getText().contains("0除算")) {
      resultLabel.setText("0");
      resultPanel.setBeforeNumber("0");
      resultPanel.setLastOperationByOperatorPushed(false);
      operatorLabel.setText("");
      return;
    }

    switch (e.getActionCommand()) {
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
        if ((resultLabel.getText().contains("-") && resultLabel.getText().length() == 2)
            || (resultLabel.getText().length() == 1)) {
          resultLabel.setText("0");
        } else if ((resultLabel.getText().contains("-") && resultLabel.getText().length() >= 3)
            || (!resultLabel.getText().contains("-") && resultLabel.getText().length() >= 2)) {
          resultLabel.setText(
              resultLabel.getText().substring(0, resultLabel.getText().length() - 1));
        }
        break;
      case "%":
        if (new BigDecimal(resultLabel.getText()).compareTo(BigDecimal.ZERO) == 0) {
          resultLabel.setText("0");
        } else {
          BigDecimal percentResult = new BigDecimal(resultLabel.getText()).scaleByPowerOfTen(-2);
          resultLabel.setText(percentResult.toPlainString());
        }
        break;
      case "±":
        if (resultPanel.getLastOperationByOperatorPushed()) {
          resultLabel.setText("-0");
          resultPanel.setLastOperationByOperatorPushed(false);
        } else if (resultLabel.getText().matches("^-.*")) {
          resultLabel.setText(resultLabel.getText().substring(1));
        } else {
          resultLabel.setText("-" + resultLabel.getText());
        }
        break;
      default:
        throw new Error("到達するはずのないdefault節まで来ています。");
    }
  }
}
