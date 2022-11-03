package caluculator;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calculator extends JFrame {
  ResultPanel resultPanel;
  JLabel resultLabel;
  NumberPanel numberPanel;
  static final int WIDTH = 600;
  static final int HEIGHT = 600;

  Calculator() {
    setTitle("電卓");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    int width = 600;
    int height = 600;
    setSize(width, height);
    setLayout(new FlowLayout());

    Container contentPane = getContentPane();

    resultPanel = new ResultPanel();
    contentPane.add(resultPanel);

    resultLabel = resultPanel.getResultLabel();

    numberPanel = new NumberPanel(resultLabel);
    contentPane.add(numberPanel);
  }

  public static void main(String[] args) {
    Calculator frame = new Calculator();
    frame.setVisible(true);
  }
}
