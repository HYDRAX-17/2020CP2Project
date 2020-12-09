import javax.swing.*;

public class Grapher {
  public static void main(String [] args) {
    JFrame frame = new JFrame();
    frame.setSize(1000,600);
    frame.setTitle("Projectile Motion Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Component component = new Component();
    frame.add(component);
    frame.setVisible(true);
  }
  
}
