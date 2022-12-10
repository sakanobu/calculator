package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OperatorPanel extends JPanel {
  ResultPanel resultPanel;

  OperatorPanel(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;

    int width = 350;
    int height = 100;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    JButton plusBtn = new JButton("+");
    plusBtn.addActionListener(new OperatorListener(resultPanel));
    add(plusBtn);

    JButton minusBtn = new JButton("-");
    minusBtn.addActionListener(new OperatorListener(resultPanel));
    add(minusBtn);

    JButton multiplyBtn = new JButton("×");
    multiplyBtn.addActionListener(new OperatorListener(resultPanel));
    add(multiplyBtn);

    JButton divideBtn = new JButton("÷");
    divideBtn.addActionListener(new OperatorListener(resultPanel));
    add(divideBtn);

    JButton equalBtn = new JButton("=");
    equalBtn.addActionListener(new OperatorListener(resultPanel));
    add(equalBtn);
  }
}
