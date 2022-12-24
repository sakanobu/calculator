package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class NumberListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JLabel pushedOperatorLabel;

  NumberListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
    this.pushedOperatorLabel = resultPanel.getPushedOperatorLabel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String displayNumber = resultLabel.getText();
    String cmdName = e.getActionCommand();

    if (displayNumber.contains("0除算")) {
      resultLabel.setText("0");
      resultPanel.setBeforeNumber("0");
      resultPanel.setOperator("");
      resultPanel.setLastOperationByOperatorPushed(false);
      pushedOperatorLabel.setText("");
      return;
    }

    switch (cmdName) {
      case ".":
        if (resultPanel.getLastOperationByOperatorPushed()) {
          resultLabel.setText("0.");
        } else if (displayNumber.contains(".")) {
          return;
        } else {
          resultLabel.setText(displayNumber + ".");
        }
        break;
      case "00":
        if (resultPanel.getLastOperationByOperatorPushed()) {
          resultLabel.setText("0");
        } else if (displayNumber.equals("0")) {
          return;
        } else {
          resultLabel.setText(displayNumber + "00");
        }
        break;
      default:
        if (resultPanel.getLastOperationByOperatorPushed()) {
          resultLabel.setText(cmdName);
        } else if (displayNumber.equals("-0")) {
          resultLabel.setText("-" + cmdName);
        } else if (displayNumber.equals("0")) {
          resultLabel.setText(cmdName);
        } else {
          resultLabel.setText(displayNumber + cmdName);
        }
    }
    resultPanel.setLastOperationByOperatorPushed(false);
  }
}
