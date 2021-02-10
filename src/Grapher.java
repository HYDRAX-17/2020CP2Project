import javax.swing.*;

public class Grapher {
  public static void main(String [] args) {
    JFrame frame = new JFrame();
    frame.setSize(1000,600);
    frame.setTitle("Projectile Motion Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    InputScreenComponent screen2 = new InputScreenComponent();
    OutputScreenComponent screen3 = new OutputScreenComponent();
    TitleScreenComponent screen1 = new TitleScreenComponent();
  }
}
