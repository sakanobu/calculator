package caluculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame {
  ResultPanel resultPanel;
  JLabel resultLabel;
  JPanel numberPanel;
  static final int WIDTH = 600;
  static final int HEIGHT = 600;

  Calculator() {
    setTitle("電卓");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(Calculator.WIDTH, Calculator.HEIGHT);
    setLayout(new FlowLayout());

    Container contentPane = getContentPane();

    resultPanel = new ResultPanel();
    contentPane.add(resultPanel);

    resultLabel = resultPanel.getResultLabel();

    numberPanel = new JPanel();
    numberPanel.setPreferredSize(new Dimension(300, 200));
    numberPanel.setBackground(Color.WHITE);

    for (int i = 0; i <= 9; i++) {
      JButton btn = new JButton(String.valueOf(i));
      btn.addActionListener(new NumberListener(resultLabel));

      numberPanel.add(btn);
    }

    JButton btn00 = new JButton("00");
    btn00.addActionListener(new NumberListener(resultLabel));
    numberPanel.add(btn00);

    JButton btnDot = new JButton(".");
    btnDot.addActionListener(new NumberListener(resultLabel));
    numberPanel.add(btnDot);

    contentPane.add(numberPanel);
  }

  public static void main(String[] args) {
    Calculator frame = new Calculator();
    frame.setVisible(true);
  }
}
