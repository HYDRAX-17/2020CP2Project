import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.Math.*;

class Grapher extends JPanel {
    int range, iV, angle, h, maxH;
    Grapher (double iV, double angleInDegrees, double h, double range, double maxH) {
      this.iV = (int) iV;
      this.angle = (int) angleInDegrees;
      this.h = (int) h;
      this.range = (int) range;
      this.maxH = (int) maxH;
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int[] array = new int [range];
      if (range != 0) {
        for (int i = 0; i < range; i ++) {
          array[i] = (int) (h - 4.9*Math.pow((i/(iV*Math.cos(angle * (Math.PI/180)))),2) + Math.tan(angle*(Math.PI/180))*i);
        }
        for (int x = 0; x < range; x++) {
          int y = (int) (-array[x] + maxH+30);
          g.drawOval(x,y,1,1);
        }
      }
    }
}
