package caluculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class SignListener implements ActionListener {
  ResultPanel resultPanel;
  JLabel resultLabel;

  SignListener(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;
    this.resultLabel = resultPanel.getResultLabel();
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
        break;
      case "=":
        switch (resultPanel.getPushedOperator()) {
          case "+":
            double result =
                Double.parseDouble(resultPanel.getBeforeNumber())
                    + Double.parseDouble(displayNumber);
            resultLabel.setText(String.valueOf(result));
            break;
        }
        resultPanel.setPushedOperator("");
        break;
      default:
        resultLabel.setText("予期していない入力です");
    }
  }
}
