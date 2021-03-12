import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.Math.*;

class Grapher extends JPanel {
    int r, iV, a, h, mH;
    Grapher () {
      this.iV = 0;
      this.a = 0;
      this.h = 0;
      this.r = 0;
      this.mH = 0;
    }

    public void update(double a, double b, double c, double d, double e) {
      iV = (int) a;
      a = (int) b;
      h = (int) c;
      r = (int) d;
      mH = (int) e;
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.RED);
      int[] array = new int [r];
      if (r != 0) {
        for (int i = 0; i < r; i ++) {
          array[i] = (int) (h - 4.9*Math.pow((i/(iV*Math.cos(a * (Math.PI/180)))),2) + Math.tan(a*(Math.PI/180))*i);
        }
        for (int x = 0; x < r; x++) {
          int y = (int) (-array[x] + mH+30);
          g.drawOval(x,y,1,1);
        }
      }
    }
}
