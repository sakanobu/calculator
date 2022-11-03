package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class NumberListener implements ActionListener {
  JLabel resultLabel;

  NumberListener(JLabel resultLabel) {
    this.resultLabel = resultLabel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String displayNumber = resultLabel.getText();
    String cmdName = e.getActionCommand();

    if (displayNumber.contains(".") && cmdName.equals(".")) {
      return;
    }

    if (displayNumber.equals("0") && cmdName.equals(".")) {
      resultLabel.setText("0.");
      return;
    }

    if (displayNumber.equals("0") && cmdName.equals("00")) {
      resultLabel.setText("0");
      return;
    }

    if (displayNumber.equals("0")) {
      resultLabel.setText(cmdName);
    } else {
      resultLabel.setText(displayNumber + cmdName);
    }
  }
}
