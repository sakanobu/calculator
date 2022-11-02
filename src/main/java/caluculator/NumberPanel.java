package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberPanel extends JPanel {

  NumberPanel(JLabel resultLabel) {
    setPreferredSize(new Dimension(300, 200));
    setBackground(Color.WHITE);

    for (int i = 0; i <= 9; i++) {
      JButton btn = new JButton(String.valueOf(i));
      btn.addActionListener(new NumberListener(resultLabel));
      add(btn);
    }

    JButton btn00 = new JButton("00");
    btn00.addActionListener(new NumberListener(resultLabel));
    add(btn00);

    JButton btnDot = new JButton(".");
    btnDot.addActionListener(new NumberListener(resultLabel));
    add(btnDot);
  }
}