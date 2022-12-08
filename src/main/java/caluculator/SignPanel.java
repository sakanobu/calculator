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

    JButton plusBtn = new JButton("+");
    plusBtn.addActionListener(new SignListener(resultPanel));
    add(plusBtn);

    JButton minusBtn = new JButton("-");
    minusBtn.addActionListener(new SignListener(resultPanel));
    add(minusBtn);

    JButton equalBtn = new JButton("=");
    equalBtn.addActionListener(new SignListener(resultPanel));
    add(equalBtn);
  }
}
