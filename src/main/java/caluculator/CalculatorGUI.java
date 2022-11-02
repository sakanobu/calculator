package caluculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorGUI extends JFrame {
  JLabel resultLabel;
  static final int WIDTH = 600;
  static final int HEIGHT = 600;

  CalculatorGUI() {
    setTitle("電卓");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(CalculatorGUI.WIDTH, CalculatorGUI.HEIGHT);
    setLayout(new FlowLayout());

    Container contentPane = getContentPane();

    JPanel resultPanel = new JPanel();
    resultPanel.setPreferredSize(new Dimension(300, 30));
    resultPanel.setBackground(Color.WHITE);

    resultLabel = new JLabel("結果");
    resultLabel.setText("0");

    resultPanel.add(resultLabel);

    contentPane.add(resultPanel);

    JPanel operandPanel = new JPanel();
    operandPanel.setPreferredSize(new Dimension(300, 200));
    operandPanel.setBackground(Color.WHITE);

    for (int i = 0; i <= 9; i++) {
      JButton btn = new JButton(String.valueOf(i));
      btn.addActionListener(new NumberListener(resultLabel));

      operandPanel.add(btn);
    }

    JButton btn00 = new JButton("00");
    btn00.addActionListener(new NumberListener(resultLabel));
    operandPanel.add(btn00);

    JButton btnDot = new JButton(".");
    btnDot.addActionListener(new NumberListener(resultLabel));
    operandPanel.add(btnDot);

    contentPane.add(operandPanel);
  }

  public static void main(String[] args) {
    CalculatorGUI frame = new CalculatorGUI();
    frame.setVisible(true);
  }
}
