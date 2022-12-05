package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
  JLabel resultLabel;
  String beforeNumber;

  ResultPanel() {
    int width = 300;
    int height = 30;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    resultLabel = new JLabel("0");
    this.beforeNumber = "";

    add(resultLabel);
  }

  public JLabel getResultLabel() {
    return resultLabel;
  }

  public String getBeforeNumber() {
    return beforeNumber;
  }

  public void setBeforeNumber(String beforeNumber) {
    this.beforeNumber = beforeNumber;
  }
}
