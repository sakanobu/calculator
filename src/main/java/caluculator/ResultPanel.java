package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
  JLabel resultLabel;
  JLabel pushedOperatorLabel;
  String beforeNumber;
  // どの演算子が選択されているのかを知っているのは SignPanel では？
  String pushedOperator;
  // OperatorButton が pushed なのかどうかを知っているのは、ResultPanel ではなく SignPanel なのでは？
  boolean operatorButtonPushed;

  ResultPanel() {
    int width = 300;
    int height = 30;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    resultLabel = new JLabel("0");
    pushedOperatorLabel = new JLabel("");
    this.beforeNumber = "";
    this.pushedOperator = "";
    this.operatorButtonPushed = false;

    add(resultLabel);
    add(pushedOperatorLabel);
  }

  public JLabel getResultLabel() {
    return resultLabel;
  }

  public JLabel getPushedOperatorLabel() {
    return pushedOperatorLabel;
  }

  public String getBeforeNumber() {
    return beforeNumber;
  }

  public void setBeforeNumber(String beforeNumber) {
    this.beforeNumber = beforeNumber;
  }

  public String getPushedOperator() {
    return pushedOperator;
  }

  public void setPushedOperator(String pushedOperator) {
    this.pushedOperator = pushedOperator;
  }

  public boolean isOperatorButtonPushed() {
    return this.operatorButtonPushed;
  }

  public void setOperatorButtonPushed(boolean operatorButtonPushed) {
    this.operatorButtonPushed = operatorButtonPushed;
  }
}
