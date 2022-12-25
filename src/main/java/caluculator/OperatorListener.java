package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class OperatorListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JLabel operatorLabel;

  OperatorListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
    this.operatorLabel = resultPanel.getOperatorLabel();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String tmpDisplayNumber = resultLabel.getText();

    try {
      if (e.getActionCommand().equals("=")) {
        if (resultLabel.getText().contains("0除算") || operatorLabel.getText().equals("")) {
          return;
        }
        resultLabel.setText(
            Calculator.calculate(resultPanel.getBeforeNumber(), resultLabel.getText(),
                operatorLabel.getText(),
                resultPanel.getLastOperationByOperatorPushed()));
        if (!resultPanel.getLastOperationByOperatorPushed()) {
          resultPanel.setBeforeNumber(tmpDisplayNumber);
          resultPanel.setLastOperationByOperatorPushed(true);
        }
        return;
      }
      if (e.getActionCommand().matches("[+-×÷]") && operatorLabel.getText().matches("[+-×÷]")
          && !resultPanel.getLastOperationByOperatorPushed()) {
        if (resultLabel.getText().contains("0除算") || operatorLabel.getText().equals("")) {
          return;
        }
        resultLabel.setText(
            Calculator.calculate(resultPanel.getBeforeNumber(), resultLabel.getText(),
                operatorLabel.getText(),
                resultPanel.getLastOperationByOperatorPushed()));
        resultPanel.setBeforeNumber(resultLabel.getText());
      } else {
        resultPanel.setBeforeNumber(tmpDisplayNumber);
      }
      resultPanel.setLastOperationByOperatorPushed(true);
      operatorLabel.setText(e.getActionCommand());
    } catch (ArithmeticException ex) {
      resultLabel.setText("0除算です。ACボタンを押してください。");
      resultPanel.setBeforeNumber("0");
      resultPanel.setLastOperationByOperatorPushed(false);
      operatorLabel.setText("");
    }
  }
}
