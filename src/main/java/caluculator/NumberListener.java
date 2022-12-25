package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class NumberListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JLabel operatorLabel;

  NumberListener(ResultPanel resultPanel) {
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
      case ".":
        if (resultPanel.getLastOperationByOperatorPushed()) {
          resultLabel.setText("0.");
        } else if (resultLabel.getText().contains(".")) {
          return;
        } else {
          resultLabel.setText(resultLabel.getText() + ".");
        }
        break;
      case "00":
        if (resultPanel.getLastOperationByOperatorPushed()) {
          resultLabel.setText("0");
        } else if (resultLabel.getText().equals("0")) {
          return;
        } else {
          resultLabel.setText(resultLabel.getText() + "00");
        }
        break;
      default:
        if (resultPanel.getLastOperationByOperatorPushed()) {
          resultLabel.setText(e.getActionCommand());
        } else if (resultLabel.getText().equals("-0")) {
          resultLabel.setText("-" + e.getActionCommand());
        } else if (resultLabel.getText().equals("0")) {
          resultLabel.setText(e.getActionCommand());
        } else {
          resultLabel.setText(resultLabel.getText() + e.getActionCommand());
        }
    }
    resultPanel.setLastOperationByOperatorPushed(false);
  }
}
