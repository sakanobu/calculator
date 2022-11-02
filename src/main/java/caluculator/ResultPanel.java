package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
  JLabel resultLabel;

  ResultPanel() {
    setPreferredSize(new Dimension(300, 30));
    setBackground(Color.WHITE);

    resultLabel = new JLabel("0");

    add(resultLabel);
  }

  public JLabel getResultLabel() {
    return resultLabel;
  }
}
