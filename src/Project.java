import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame {
  final static int WINDOW_WIDTH = 1000;
  final static int WINDOW_HEIGHT = 700;
  static CardLayout card = new CardLayout();
  static JPanel main = new JPanel(card);
  private TitleScreen card1 = new TitleScreen();
  private ProjectileScreen card2 = new ProjectileScreen();
  private FreeFallScreen card3 = new FreeFallScreen();

   Project() {
     main.add(card1, "Title Screen");
     main.add(card2, "Projectile");
     main.add(card3, "Free Fall");
     add(main);
     card.show(main, "Title Screen");
   }

   public static void main(String[] args) {
     Project project = new Project();
     project.setVisible(true);
     project.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     project.setResizable(false);
     project.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
   }
}
