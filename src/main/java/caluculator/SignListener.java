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
    String cmdName = e.getActionCommand();

    if (cmdName.equals("C")) {
      resultLabel.setText("0");
    }
  }
}
