package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SignPanel extends JPanel {
  ResultPanel resultPanel;

  SignPanel(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;

    int width = 350;
    int height = 100;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    JButton allClearBtn = new JButton("AC");
    allClearBtn.addActionListener(new SignListener(resultPanel));
    add(allClearBtn);

    JButton clearBtn = new JButton("C");
    clearBtn.addActionListener(new SignListener(resultPanel));
    add(clearBtn);

    JButton deleteBtn = new JButton("→");
    deleteBtn.addActionListener(new SignListener(resultPanel));
    add(deleteBtn);

    JButton percentBtn = new JButton("%");
    percentBtn.addActionListener(new SignListener(resultPanel));
    add(percentBtn);

    JButton reverseNumberSignBtn = new JButton("±");
    reverseNumberSignBtn.addActionListener(new SignListener(resultPanel));
    add(reverseNumberSignBtn);
  }
}
