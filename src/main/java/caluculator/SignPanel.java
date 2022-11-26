package caluculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignPanel extends JPanel {
  JLabel resultLabel;

  SignPanel(JLabel resultLabel) {
    this.resultLabel = resultLabel;

    int width = 600;
    int height = 600;
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.WHITE);

    JButton deleteBtn = new JButton("→");
    deleteBtn.addActionListener(new SignListener(resultLabel));
    add(deleteBtn);

    JButton clearBtn = new JButton("C");
    clearBtn.addActionListener(new SignListener(resultLabel));
    add(clearBtn);
  }
}
