package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SignPanel extends JPanel {
  ResultPanel resultPanel;

  SignPanel(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;

    int width = 600;
    int height = 600;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    JButton deleteBtn = new JButton("→");
    deleteBtn.addActionListener(new SignListener(resultPanel));
    add(deleteBtn);

    JButton clearBtn = new JButton("C");
    clearBtn.addActionListener(new SignListener(resultPanel));
    add(clearBtn);

    JButton percentBtn = new JButton("%");
    percentBtn.addActionListener(new SignListener(resultPanel));
    add(percentBtn);

    JButton reverseNumberSignBtn = new JButton("±");
    reverseNumberSignBtn.addActionListener(new SignListener(resultPanel));
    add(reverseNumberSignBtn);

    JButton plusBtn = new JButton("+");
    plusBtn.addActionListener(new SignListener(resultPanel));
    add(plusBtn);

    JButton minusBtn = new JButton("-");
    minusBtn.addActionListener(new SignListener(resultPanel));
    add(minusBtn);

    JButton multiplyBtn = new JButton("×");
    multiplyBtn.addActionListener(new SignListener(resultPanel));
    add(multiplyBtn);

    JButton divideBtn = new JButton("÷");
    divideBtn.addActionListener(new SignListener(resultPanel));
    add(divideBtn);

    JButton equalBtn = new JButton("=");
    equalBtn.addActionListener(new SignListener(resultPanel));
    add(equalBtn);
  }
}
