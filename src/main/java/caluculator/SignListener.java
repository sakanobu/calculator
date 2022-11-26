package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class SignListener implements ActionListener {
  JLabel resultLabel;

  SignListener(JLabel resultLabel) {
    this.resultLabel = resultLabel;
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
      default:
        resultLabel.setText("予期していない入力です");
    }
  }
}
