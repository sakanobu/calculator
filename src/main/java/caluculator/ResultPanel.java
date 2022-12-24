package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
  JLabel resultLabel;
  JLabel operatorLabel;
  String beforeNumber;
  String operator;
  boolean lastOperationByOperatorPushed;

  ResultPanel() {
    setLayout(null);
    int width = 300;
    int height = 30;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    resultLabel = new JLabel("0");
    operatorLabel = new JLabel("");
    this.beforeNumber = "";
    this.operator = "";
    this.lastOperationByOperatorPushed = false;

    resultLabel.setBounds(10, 0, 260, 30);
    resultLabel.setHorizontalAlignment(JLabel.RIGHT);
    add(resultLabel);
    operatorLabel.setBounds(280, 0, 20, 30);
    add(operatorLabel);
  }

  public JLabel getResultLabel() {
    return resultLabel;
  }

  public JLabel getOperatorLabel() {
    return operatorLabel;
  }

  public String getBeforeNumber() {
    return beforeNumber;
  }

  public void setBeforeNumber(String beforeNumber) {
    this.beforeNumber = beforeNumber;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public boolean getLastOperationByOperatorPushed() {
    return this.lastOperationByOperatorPushed;
  }

  public void setLastOperationByOperatorPushed(boolean lastOperationByOperatorPushed) {
    this.lastOperationByOperatorPushed = lastOperationByOperatorPushed;
  }
}
