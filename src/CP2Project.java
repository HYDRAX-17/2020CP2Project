import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CP2Project extends JFrame {

    CP2Project() {
        super();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        components();
    }

    public void components() {
      Random rand = new Random();
      CardLayout card = new CardLayout();
      JPanel main = new JPanel(card);
      JPanel card1 = new JPanel();
      JPanel card2 = new JPanel();
      JPanel card3 = new JPanel();
      Color black = new Color(0,0,0);
      main.add(card1, "Title Screen");
      main.add(card2, "Projectile");
      main.add(card3, "Free Fall");
      add(main);
      card.show(main, "Title Screen");

      
    }

    public static void main(String[] args) {
        CP2Project physicsCalc = new CP2Project();
        physicsCalc.setSize(800, 600);
        physicsCalc.setVisible(true);
    }
}
