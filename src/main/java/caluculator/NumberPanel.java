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

    for (int i = 0; i <= 9; i++) {
      JButton btn = new JButton(String.valueOf(i));
      btn.addActionListener(new NumberListener(resultPanel));
      add(btn);
    }

    JButton btn00 = new JButton("00");
    btn00.addActionListener(new NumberListener(resultPanel));
    add(btn00);

    JButton btnDot = new JButton(".");
    btnDot.addActionListener(new NumberListener(resultPanel));
    add(btnDot);
  }
}
