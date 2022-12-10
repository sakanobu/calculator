package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class SignListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JLabel pushedOperatorLabel;

  SignListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
    this.pushedOperatorLabel = resultPanel.getPushedOperatorLabel();
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
      case "+":
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setPushedOperator("+");
        resultPanel.setOperatorButtonPushed(true);
        pushedOperatorLabel.setText(resultPanel.getPushedOperator());
        break;
      case "-":
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setPushedOperator("-");
        resultPanel.setOperatorButtonPushed(true);
        pushedOperatorLabel.setText(resultPanel.getPushedOperator());
        break;
      case "×":
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setPushedOperator("×");
        resultPanel.setOperatorButtonPushed(true);
        pushedOperatorLabel.setText(resultPanel.getPushedOperator());
        break;
      case "÷":
        resultPanel.setBeforeNumber(displayNumber);
        resultPanel.setPushedOperator("÷");
        resultPanel.setOperatorButtonPushed(true);
        pushedOperatorLabel.setText(resultPanel.getPushedOperator());
        break;
      case "=":
        switch (resultPanel.getPushedOperator()) {
          case "+":
            double plusResult =
                Double.parseDouble(resultPanel.getBeforeNumber())
                    + Double.parseDouble(displayNumber);
            resultLabel.setText(String.valueOf(plusResult));
            resultPanel.setPushedOperator("");
            pushedOperatorLabel.setText("");
            break;
          case "-":
            double minusResult =
                Double.parseDouble(resultPanel.getBeforeNumber())
                    - Double.parseDouble(displayNumber);
            resultLabel.setText(String.valueOf(minusResult));
            resultPanel.setPushedOperator("");
            pushedOperatorLabel.setText("");
            break;
          case "×":
            double multiplyResult =
                Double.parseDouble(resultPanel.getBeforeNumber())
                    * Double.parseDouble(displayNumber);
            resultLabel.setText(String.valueOf(multiplyResult));
            resultPanel.setPushedOperator("");
            pushedOperatorLabel.setText("");
            break;
          case "÷":
            double divideResult =
                Double.parseDouble(resultPanel.getBeforeNumber())
                    / Double.parseDouble(displayNumber);
            resultLabel.setText(String.valueOf(divideResult));
            resultPanel.setPushedOperator("");
            pushedOperatorLabel.setText("");
            break;
          default:
            resultLabel.setText("演算子のswitch文でdefault節まで到達しました。");
        }
        break;
      default:
        resultLabel.setText("SignListenerのswitch文でdefault節まで到達しました。");
    }
  }
}
