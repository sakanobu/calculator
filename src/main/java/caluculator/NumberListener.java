package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class NumberListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;

  NumberListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String displayNumber = resultLabel.getText();
    String cmdName = e.getActionCommand();

    switch (cmdName) {
      case ".":
        if (resultPanel.isOperatorButtonPushed()) {
          resultPanel.setOperatorButtonPushed(false);
          resultLabel.setText("0.");
        } else if (displayNumber.contains(".")) {
          return;
        } else if (displayNumber.equals("0")) {
          resultLabel.setText("0.");
        } else {
          resultLabel.setText(displayNumber + ".");
        }
        break;
      case "00":
        if (resultPanel.isOperatorButtonPushed()) {
          resultPanel.setOperatorButtonPushed(false);
          resultLabel.setText("0");
        } else if (displayNumber.equals("0")) {
          resultLabel.setText("0");
        } else {
          resultLabel.setText(displayNumber + "00");
        }
        break;
      default:
        if (resultPanel.isOperatorButtonPushed()) {
          resultPanel.setOperatorButtonPushed(false);
          resultLabel.setText(cmdName);
        } else if (displayNumber.equals("-0")) {
          resultLabel.setText("-" + cmdName);
        } else if (displayNumber.equals("0")) {
          resultLabel.setText(cmdName);
        } else {
          resultLabel.setText(displayNumber + cmdName);
        }
    }
  }
}
