import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CP2Project extends JFrame {
  final static int WINDOW_WIDTH = 1000;
  final static int WINDOW_HEIGHT = 700;
  public static void main(String[] args) {
      CP2Project physicsCalc = new CP2Project();
      physicsCalc.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      physicsCalc.setVisible(true);
      physicsCalc.setResizable(false);
  }

  CP2Project() {
      super();
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      components();
  }

  public void components() {
  // Inital Setup of Panels and CardLayout
      CalcForP calcForP = new CalcForP();
      CardLayout card = new CardLayout();
      JPanel main = new JPanel(card);
      JPanel card1 = new JPanel(null);
      JPanel card2 = new JPanel(null);
      JPanel card3 = new JPanel(null);
      Color black = new Color(0,0,0);
      Font font = new Font("Gill Sans MT", Font.PLAIN, 18);
      Font titleFont = new Font("Gill Sans MT", Font.BOLD,21);
      main.add(card1, "Main Screen");
      main.add(card2, "Projectile");
      main.add(card3, "Free Fall");
      add(main);
      card.show(main, "Main Screen");


  // Creation of the Main Screen Panel
      card1.setBackground(black);
      // Buttons
      JButton toFreeFall = new JButton("Free Fall Motion");
      toFreeFall.setBounds(WINDOW_WIDTH/2-225,WINDOW_HEIGHT/2-100,200,200);
      toFreeFall.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          card.show(main, "Free Fall");
        }
      });
      JButton toProjectile = new JButton("Projectile Motion");
      toProjectile.setBounds(WINDOW_WIDTH/2+25,WINDOW_HEIGHT/2-100,200,200);
      toProjectile.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          card.show(main, "Projectile");
        }
      });
      card1.add(toFreeFall); card1.add(toProjectile);


  // Creation of the Projectile Screen Panel
      card2.setBackground(black);
      Grapher grapher = new Grapher();
      grapher.setBackground(black);
      grapher.setBorder(BorderFactory.createLineBorder(Color.white));
      grapher.setBounds(10,400, 965, 250);
      card2.add(grapher);
      JButton toMain1, calculate;
      JTextField iVelocity, angle, h, totalTime, range, maxH;
      JLabel graphTitle, results, errorMessage, inputMess, iVMess, aMess, hMess, tTMess, rMess,mHMess, iVRes, aRes, hRes, tRes, rRes, hmRes;
      // JTextFields
      iVelocity = new JTextField("");
      angle = new JTextField("");
      h = new JTextField("");
      totalTime = new JTextField("");
      range = new JTextField("");
      maxH = new JTextField("");
      iVelocity.setBounds(280,100, 50, 25);
      angle.setBounds(280,135, 50, 25);
      h.setBounds(280,170, 50, 25);
      totalTime.setBounds(280,205, 50, 25);
      range.setBounds(280,240, 50, 25);
      maxH.setBounds(280,275, 50, 25);
      iVelocity.setFont(font);
      angle.setFont(font);
      h.setFont(font);
      totalTime.setFont(font);
      range.setFont(font);
      maxH.setFont(font);
      card2.add(iVelocity); card2.add(angle); card2.add(h); card2.add(totalTime); card2.add(range); card2.add(maxH);
      // JLabels
      graphTitle = new JLabel("Graph of Motion: ");
      graphTitle.setForeground(Color.white);
      graphTitle.setFont(titleFont);
      graphTitle.setBounds(10, 370, 200, 30);
      results = new JLabel("Results: ");
      results.setForeground(Color.white);
      results.setFont(titleFont);
      results.setBounds(400,65,130,30);
      iVRes = new JLabel();
      iVRes.setVisible(false);
      iVRes.setForeground(Color.white);
      iVRes.setFont(font);
      iVRes.setBounds(400, 100, 300,25);
      aRes = new JLabel();
      aRes.setVisible(false);
      aRes.setForeground(Color.white);
      aRes.setFont(font);
      aRes.setBounds(400, 135, 300,25);
      hRes = new JLabel();
      hRes.setVisible(false);
      hRes.setForeground(Color.white);
      hRes.setFont(font);
      hRes.setBounds(400, 170, 300,25);
      tRes = new JLabel();
      tRes.setVisible(false);
      tRes.setForeground(Color.white);
      tRes.setFont(font);
      tRes.setBounds(400, 205, 300,25);
      rRes = new JLabel();
      rRes.setVisible(false);
      rRes.setForeground(Color.white);
      rRes.setFont(font);
      rRes.setBounds(400, 240, 300,25);
      hmRes = new JLabel();
      hmRes.setVisible(false);
      hmRes.setForeground(Color.white);
      hmRes.setFont(font);
      hmRes.setBounds(400, 275, 300,25);
      inputMess = new JLabel("Input the information you know:");
      inputMess.setBounds(10,65,320,30);
      inputMess.setFont(titleFont);
      inputMess.setForeground(Color.white);
      iVMess = new JLabel("Initial Velocity (m/s): ");
      iVMess.setForeground(Color.white);
      iVMess.setBounds(30, 100, 230,25);
      iVMess.setFont(font);
      aMess = new JLabel("Angle of Launch (degrees):");
      aMess.setForeground(Color.white);
      aMess.setBounds(30,135, 230,25);
      aMess.setFont(font);
      hMess = new JLabel("Height of launch (m):");
      hMess.setForeground(Color.white);
      hMess.setBounds(30,170, 230,25);
      hMess.setFont(font);
      tTMess = new JLabel("Time in air (s):");
      tTMess.setForeground(Color.white);
      tTMess.setBounds(30,205, 230,25);
      tTMess.setFont(font);
      rMess = new JLabel("Range of Projectile (m):");
      rMess.setForeground(Color.white);
      rMess.setBounds(30,240, 230,25);
      rMess.setFont(font);
      mHMess = new JLabel("Maximun Height Reached (m):");
      mHMess.setForeground(Color.white);
      mHMess.setBounds(30,275, 230,25);
      mHMess.setFont(font);
      errorMessage = new JLabel("Error, not enough info");
      errorMessage.setVisible(false);
      errorMessage.setBounds(400, 100, 300, 25);
      errorMessage.setForeground(Color.red);
      errorMessage.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
      card2.add(errorMessage); card2.add(inputMess); card2.add(iVMess); card2.add(aMess); card2.add(hMess); card2.add(tTMess); card2.add(rMess); card2.add(mHMess); card2.add(results);
      card2.add(iVRes); card2.add(aRes); card2.add(hRes); card2.add(tRes); card2.add(rRes); card2.add(hmRes); card2.add(graphTitle);
      // Buttons
      calculate = new JButton("Calculate");
      calculate.setBounds(260, 320, 90,35);
      calculate.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
      calculate.addActionListener(new ActionListener () {
        public void actionPerformed(ActionEvent e) {
          calcForP.calculate(iVelocity.getText(), angle.getText(), h.getText(), totalTime.getText(), range.getText(), maxH.getText());
          errorMessage.setVisible(calcForP.getErrorMessage());
          if (calcForP.getErrorMessage()) {
            iVRes.setVisible(false);
            aRes.setVisible(false);
            hRes.setVisible(false);
            tRes.setVisible(false);
            rRes.setVisible(false);
            hmRes.setVisible(false);
            //grapher.getContentPane().removeAll();
          } else {
            iVRes.setText("Initial Velocity = " + calcForP.getString(calcForP.iVelocity) + " m/s");
            iVRes.setVisible(true);
            aRes.setText("Angle of Launch = " + calcForP.getString(calcForP.angleInDegrees) + " degrees");
            aRes.setVisible(true);
            hRes.setText("Height of Launch = " + calcForP.getString(calcForP.h) + " m");
            hRes.setVisible(true);
            tRes.setText("Time of flight = " + calcForP.getString(calcForP.totalTime) + " s");
            tRes.setVisible(true);
            rRes.setText("Range of Projectile = " + calcForP.getString(calcForP.range) + " m");
            rRes.setVisible(true);
            hmRes.setText("Maximum Height Reached = " + calcForP.getString(calcForP.maxH) + " m");
            hmRes.setVisible(true);
            grapher.repaint();
          }
        }
      });
      toMain1 = new JButton("Main Screen");
      toMain1.setBounds(10,10,120,45);
      toMain1.setFont(new Font("Gill Sans MT",Font.PLAIN,15));
      toMain1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          card.show(main, "Main Screen");
        }
      });
      card2.add(calculate); card2.add(toMain1);


  // Creation of the Free Fall Screen Panel
      card3.setBackground(black);
      JButton toMain2 = new JButton("Main Screen");
      toMain2.setBounds(10,10,120,45);
      toMain2.setFont(new Font("Verdana", Font.PLAIN, 12));
      toMain2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          card.show(main, "Main Screen");
        }
      });
      card3.add(toMain2);

    }
}
