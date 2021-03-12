import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectileScreen extends JPanel {
  private Grapher grapher = new Grapher();
  private CalcForP calc = new CalcForP();
  Font font = new Font("Gill Sans MT", Font.PLAIN, 18);
  Font titleFont = new Font("Gill Sans MT", Font.BOLD,21);
  Color black = new Color(0,0,0);
  Color white = new Color(255,255,255);
  Color red = new Color(255,0,0);
  boolean show;
  JButton toMain, calculate, calcParam;
  JTextField time, iVelocity, angle, h, totalTime, range, maxH;
  JLabel em1,em2,timeText, pTitle ,graphTitle, results, errorMessage, inputMess, iVMess, aMess, hMess, tTMess, rMess,mHMess, iVRes, aRes, hRes, tRes, rRes, hmRes, paramV, paramH, paramVX, paramVY, paramR;

  ProjectileScreen () {
    setLayout(null);
    components();
  }

  private void components() {
    // Add graphing JPanel
    setBackground(black);
    grapher.setBackground(black);
    grapher.setBorder(BorderFactory.createLineBorder(white));
    grapher.setBounds(10, 402 ,965, 250);
    add(grapher);
    // JTextFields
    iVelocity = new JTextField("");
    angle = new JTextField("");
    h = new JTextField("");
    totalTime = new JTextField("");
    range = new JTextField("");
    maxH = new JTextField("");
    time = new JTextField("");
    time.setBounds(785, 114, 50,25);
    time.setFont(font);
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
    add(time); add(iVelocity); add(angle); add(h); add(totalTime); add(range); add(maxH);
    // JLabels, the text on JPanel
    graphTitle = new JLabel("Graph of Motion: ");
    graphTitle.setForeground(white);
    graphTitle.setFont(titleFont);
    graphTitle.setBounds(10, 370, 200, 30);
    results = new JLabel("Results: ");
    results.setForeground(white);
    results.setFont(titleFont);
    results.setBounds(390,65,130,30);
    iVRes = new JLabel();
    iVRes.setVisible(false);
    iVRes.setForeground(white);
    iVRes.setFont(font);
    iVRes.setBounds(410, 100, 300,25);
    aRes = new JLabel();
    aRes.setVisible(false);
    aRes.setForeground(white);
    aRes.setFont(font);
    aRes.setBounds(410, 135, 300,25);
    hRes = new JLabel();
    hRes.setVisible(false);
    hRes.setForeground(white);
    hRes.setFont(font);
    hRes.setBounds(410, 170, 300,25);
    tRes = new JLabel();
    tRes.setVisible(false);
    tRes.setForeground(white);
    tRes.setFont(font);
    tRes.setBounds(410, 205, 300,25);
    rRes = new JLabel();
    rRes.setVisible(false);
    rRes.setForeground(white);
    rRes.setFont(font);
    rRes.setBounds(410, 240, 300,25);
    hmRes = new JLabel();
    hmRes.setVisible(false);
    hmRes.setForeground(white);
    hmRes.setFont(font);
    hmRes.setBounds(410, 275, 300,25);
    inputMess = new JLabel("Input the information you know:");
    inputMess.setBounds(10,65,320,30);
    inputMess.setFont(titleFont);
    inputMess.setForeground(white);
    iVMess = new JLabel("Initial Velocity (m/s): ");
    iVMess.setForeground(white);
    iVMess.setBounds(30, 100, 230,25);
    iVMess.setFont(font);
    aMess = new JLabel("Angle of Launch (degrees):");
    aMess.setForeground(white);
    aMess.setBounds(30,135, 230,25);
    aMess.setFont(font);
    hMess = new JLabel("Height of launch (m):");
    hMess.setForeground(white);
    hMess.setBounds(30,170, 230,25);
    hMess.setFont(font);
    tTMess = new JLabel("Time in air (s):");
    tTMess.setForeground(white);
    tTMess.setBounds(30,205, 230,25);
    tTMess.setFont(font);
    rMess = new JLabel("Range of Projectile (m):");
    rMess.setForeground(white);
    rMess.setBounds(30,240, 230,25);
    rMess.setFont(font);
    mHMess = new JLabel("Maximun Height Reached (m):");
    mHMess.setForeground(white);
    mHMess.setBounds(30,275, 230,25);
    mHMess.setFont(font);
    timeText = new JLabel ("Time (s): ");
    timeText.setBounds(710,110,80,30);
    timeText.setFont(font);
    timeText.setForeground(white);
    pTitle = new JLabel ("Parameters at given time: ");
    pTitle.setBounds(690,65, 300, 30);
    pTitle.setFont(titleFont);
    pTitle.setForeground(white);
    paramV = new JLabel();
    paramV.setFont(font);
    paramV.setForeground(white);
    paramV.setBounds(740,155, 200,30);
    paramV.setVisible(false);
    paramVX = new JLabel();
    paramVX.setFont(font);
    paramVX.setForeground(white);
    paramVX.setBounds(740,180, 200,30);
    paramVX.setVisible(false);
    paramVY = new JLabel();
    paramVY.setFont(font);
    paramVY.setForeground(white);
    paramVY.setBounds(740,205, 200,30);
    paramVY.setVisible(false);
    paramH = new JLabel();
    paramH.setFont(font);
    paramH.setForeground(white);
    paramH.setBounds(740,230, 200,30);
    paramH.setVisible(false);
    paramR = new JLabel();
    paramR.setFont(font);
    paramR.setForeground(white);
    paramR.setBounds(740,255, 200,30);
    paramR.setVisible(false);
    errorMessage = new JLabel("Error, not enough info");
    errorMessage.setVisible(false);
    errorMessage.setBounds(400, 100, 300, 25);
    errorMessage.setForeground(red);
    errorMessage.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
    em1 = new JLabel("Error, input initial values");
    em1.setForeground(red);
    em1.setBounds(740,155, 200,30);
    em1.setVisible(false);
    em1.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
    em2 = new JLabel("Error, invalid time");
    em2.setForeground(red);
    em2.setVisible(false);
    em2.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
    em2.setBounds(740,155, 200,30);
    add(errorMessage); add(inputMess); add(iVMess); add(aMess); add(hMess); add(tTMess); add(rMess); add(mHMess); add(results);
    add(em1); add(em2); add(paramV); add(paramVX); add(paramVY); add(paramH); add(paramR); add(timeText); add(pTitle); add(iVRes); add(aRes); add(hRes); add(tRes); add(rRes); add(hmRes); add(graphTitle);
    // Buttons
    calculate = new JButton(new ImageIcon("C:\\Users\\henry\\OneDrive\\Documents\\GitHub\\2020CP2Project\\doc\\CalculateButtonIcon.png"));
    calculate.setBounds(260, 320, 90, 37);
    calculate.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        calc.calculate(iVelocity.getText(), angle.getText(), h.getText(), totalTime.getText(), range.getText(), maxH.getText());
        errorMessage.setVisible(calc.getErrorMessage());
        if (calc.getErrorMessage()) {
          iVRes.setVisible(false);
          aRes.setVisible(false);
          hRes.setVisible(false);
          tRes.setVisible(false);
          rRes.setVisible(false);
          hmRes.setVisible(false);
        } else {
          iVRes.setText("Initial Velocity = " + calc.getString(calc.iVelocity) + " m/s");
          iVRes.setVisible(true);
          aRes.setText("Angle of Launch = " + calc.getString(calc.angleInDegrees) + " degrees");
          aRes.setVisible(true);
          hRes.setText("Height of Launch = " + calc.getString(calc.h) + "m");
          hRes.setVisible(true);
          tRes.setText("Time of flight = " + calc.getString(calc.totalTime) + "s");
          tRes.setVisible(true);
          rRes.setText("Range of Projectile = " + calc.getString(calc.range) + "m");
          rRes.setVisible(true);
          hmRes.setText("Maximum Height Reached = " + calc.getString(calc.maxH) + "m");
          hmRes.setVisible(true);
          grapher.update(calc.iVelocity, calc.angleInDegrees, calc.h, calc.range, calc.maxH);
          grapher.repaint();
        }
      }
    });
    toMain = new JButton(new ImageIcon("C:\\Users\\henry\\OneDrive\\Documents\\GitHub\\2020CP2Project\\doc\\MainScreenButtonIcon.png"));
    toMain.setBounds(10,10,119,46);
    toMain.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Project.card.show(Project.main, "Title Screen");
      }
    });
    calcParam = new JButton(new ImageIcon("C:\\Users\\henry\\OneDrive\\Documents\\GitHub\\2020CP2Project\\doc\\CalculateButtonIcon.png"));
    calcParam.setBounds(855,108,90,37);
    calcParam.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        calc.calcParametersAtTime(time.getText());
        if (calc.time > 0 && calc.time < calc.totalTime) {
          paramV.setText("Velocity = " + calc.getString(calc.velocity) + " m/s");
          paramV.setVisible(true);
          paramVX.setText("X-Velocity = " + calc.getString(calc.pVX)+ " m/s");
          paramVX.setVisible(true);
          paramVY.setText("Y-Velocity = " + calc.getString(calc.pVY)+ " m/s");
          paramVY.setVisible(true);
          paramH.setText("Height = " + calc.getString(calc.height) + "m");
          paramH.setVisible(true);
          paramR.setText("Distance = " + calc.getString(calc.distFromLaunch) + "m");
          paramR.setVisible(true);
          em1.setVisible(false);
          em2.setVisible(false);
        } else if (calc.getErrorMessage()) {
          paramV.setVisible(false);
          paramVX.setVisible(false);
          paramVY.setVisible(false);
          paramH.setVisible(false);
          paramR.setVisible(false);
          em1.setVisible(true);
          em2.setVisible(false);
        } else {
          paramV.setVisible(false);
          paramVX.setVisible(false);
          paramVY.setVisible(false);
          paramH.setVisible(false);
          paramR.setVisible(false);
          em2.setVisible(true);
          em1.setVisible(false);
        }
      }
    });
    add(calcParam); add(calculate); add(toMain);
  }
}
