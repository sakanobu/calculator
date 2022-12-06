package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
  JLabel resultLabel;
  String beforeNumber;
  boolean pushedOperator;

  ResultPanel() {
    int width = 300;
    int height = 30;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    resultLabel = new JLabel("0");
    this.beforeNumber = "";
    this.pushedOperator = false;

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

  public boolean isPushedOperator() {
    return pushedOperator;
  }

  public void setPushedOperator(boolean pushedOperator) {
    this.pushedOperator = pushedOperator;
  }
}
