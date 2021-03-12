import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitleScreen extends JPanel {
  Font font = new Font("Gill Sans MT", Font.PLAIN, 18);
  Font titleFont = new Font("Gill Sans MT", Font.BOLD,21);
  Color black = new Color(0,0,0);
  Color white = new Color(255,255,255);
  Color red = new Color(255,0,0);
  JLabel titleImage = new JLabel(new ImageIcon("C:\\Users\\henry\\OneDrive\\Documents\\GitHub\\2020CP2Project\\doc\\TitleImage.png"));
  JButton toFreeFall, toProjectile;
  TitleScreen () {
    setLayout(null);
    setBackground(black);
    components();
  }

  private void components() {
    titleImage.setBounds(150,50,700,205);
    add(titleImage);
    toFreeFall = new JButton(new ImageIcon("C:\\Users\\henry\\OneDrive\\Documents\\GitHub\\2020CP2Project\\doc\\FreeFallButtonImage.png"));
    toFreeFall.setBounds(Project.WINDOW_WIDTH/2-375,Project.WINDOW_HEIGHT/2-50,300,300);
    toFreeFall.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Project.card.show(Project.main, "Free Fall");
      }
    });

    toProjectile = new JButton(new ImageIcon("C:\\Users\\henry\\OneDrive\\Documents\\GitHub\\2020CP2Project\\doc\\ProjectileButtonImage.png"));
    toProjectile.setBounds(Project.WINDOW_WIDTH/2+75,Project.WINDOW_HEIGHT/2-50,300,300);
    toProjectile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Project.card.show(Project.main, "Projectile");
      }
    });
    add(toFreeFall); add(toProjectile);

  }

}
