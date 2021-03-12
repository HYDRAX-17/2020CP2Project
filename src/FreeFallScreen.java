import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FreeFallScreen extends JPanel {
  private Grapher grapher = new Grapher();
  private CalcForFF calc = new CalcForFF();
  Font font = new Font("Gill Sans MT", Font.PLAIN, 18);
  Font titleFont = new Font("Gill Sans MT", Font.BOLD,21);
  Color black = new Color(0,0,0);
  Color white = new Color(255,255,255);
  Color red = new Color(255,0,0);
  boolean show;
  JButton toMain, calculate, calcParam;
  JLabel filer;
  JTextField filler;

  FreeFallScreen() {
    setLayout(null);
    setBackground(black);
    components();
  }

  private void components() {
    JButton toMain = new JButton(new ImageIcon("C:\\Users\\henry\\OneDrive\\Documents\\GitHub\\2020CP2Project\\doc\\MainScreenButtonIcon.png"));
    toMain.setBounds(10,10,119,47);
    toMain.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Project.card.show(Project.main, "Title Screen");
      }
    });
    add(toMain);
  }

}
