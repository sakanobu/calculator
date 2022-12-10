package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NumberPanel extends JPanel {
  ResultPanel resultPanel;

  NumberPanel(ResultPanel resultPanel) {
    this.resultPanel = resultPanel;

    int width = 300;
    int height = 300;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    for (int i = 7; i <= 9; i++) {
      JButton btn = new JButton(String.valueOf(i));
      btn.addActionListener(new NumberListener(resultPanel));
      add(btn);
    }

    for (int i = 4; i <= 6; i++) {
      JButton btn = new JButton(String.valueOf(i));
      btn.addActionListener(new NumberListener(resultPanel));
      add(btn);
    }

    for (int i = 1; i <= 3; i++) {
      JButton btn = new JButton(String.valueOf(i));
      btn.addActionListener(new NumberListener(resultPanel));
      add(btn);
    }

    JButton singleZeroBtn = new JButton("0");
    singleZeroBtn.addActionListener(new NumberListener(resultPanel));
    add(singleZeroBtn);

    JButton doubleZeroBtn = new JButton("00");
    doubleZeroBtn.addActionListener(new NumberListener(resultPanel));
    add(doubleZeroBtn);

    JButton dotBtn = new JButton(".");
    dotBtn.addActionListener(new NumberListener(resultPanel));
    add(dotBtn);
  }
}
