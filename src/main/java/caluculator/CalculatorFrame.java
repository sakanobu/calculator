package caluculator;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class CalculatorFrame extends JFrame {
  ResultPanel resultPanel;
  NumberPanel numberPanel;
  SignPanel signPanel;
  OperatorPanel operatorPanel;

  CalculatorFrame() {
    setTitle("電卓");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    int width = 400;
    int height = 500;
    setSize(width, height);
    setLayout(new FlowLayout());

    Container contentPane = getContentPane();

    resultPanel = new ResultPanel();
    contentPane.add(resultPanel);

    numberPanel = new NumberPanel(resultPanel);
    contentPane.add(numberPanel);

    signPanel = new SignPanel(resultPanel);
    contentPane.add(signPanel);

    operatorPanel = new OperatorPanel(resultPanel);
    contentPane.add(operatorPanel);
  }

  public static void main(String[] args) {
    CalculatorFrame frame = new CalculatorFrame();
    frame.setVisible(true);
  }
}
