import java.lang.Math.*;
import java.text.DecimalFormat;

public class CalcForP {
  final static double g = 9.81;
  public double vx,vy;
  public double h;
  public double angle, angleInDegrees;
  public double maxH;
  public double totalTime;
  public double range;
  public double iVelocity;

  public double velocity;
  public double time;
  public double height;
  public double pVX,pVY;
  public double distFromLaunch;

  public boolean errorMessage = false;

  // @param Strings from text boxes
  public void calculate (String a, String b, String c, String d, String e, String f) {
    if (!a.equals("")) {
      iVelocity = Double.parseDouble(a);
    }
    if (!b.equals("")) {
      angleInDegrees = Double.parseDouble(b);
      angle = Math.toRadians(angleInDegrees);
    }
    if (!c.equals("")) {
      h = Double.parseDouble(c);
    }
    if (!d.equals("")) {
      totalTime = Double.parseDouble(d);
    }
    if (!e.equals("")) {
      range = Double.parseDouble(e);
    }
    if (!f.equals("")) {
      maxH = Double.parseDouble(f);
    }
    if (a.equals("") && b.equals("") && c.equals("") && d.equals("") && e.equals("") && f.equals("")) {
      errorMessage = true;
      // do stuff
    }
    // Figure out which calculation to do
    if (d.equals("") && e.equals("") && f.equals("")) {
      errorMessage = false;
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      if (h == 0) {
        totalTime = (2*vy)/g;
        range = (Math.pow(iVelocity,2)*Math.sin(2*angle))/g;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        totalTime = (vy + Math.sqrt(Math.pow(vy,2)+2*g*h))/g;
        range = vx*totalTime;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + h;
      }
    } else if (c.equals("") && e.equals("") && f.equals("")) {
      errorMessage = false;
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      h = (Math.pow((totalTime*g)-vy,2)-Math.pow(vy,2))/(2*g);
      if (h >= -0.1 && h <= 0.1) {
        h = 0;
        range = (Math.pow(iVelocity,2)*Math.sin(2*angle))/g;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        range = vx*totalTime;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + h;
      }
    } else if (c.equals("") && d.equals("") && f.equals("")) {
      errorMessage = false;
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      h = (Math.pow(((range*g)/vx)-vy,2)-Math.pow(vy,2))/(2*g);
      if (h >= -0.1 && h <= 0.1) {
        h = 0;
        totalTime = range/vx;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        totalTime = range/vx;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + h;
      }
    } else if (c.equals("") && d.equals("") && e.equals("")) {
      errorMessage = false;
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      h = maxH - ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g));
      if (h >= -0.1 && h <= 0.1) {
        h = 0;
        totalTime = (2*vy)/g;
        range = totalTime*vx;
      } else {
        totalTime = (vy + Math.sqrt(Math.pow(vy,2)+2*g*h))/g;
        range = totalTime*vx;
      }
    } else if (b.equals("") && c.equals("") && f.equals("")) {
      errorMessage = false;
      angle = Math.acos((range/totalTime)/iVelocity);
      angleInDegrees = Math.toDegrees(angle);
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      h = (Math.pow(((range*g)/vx)-vy,2)-Math.pow(vy,2))/(2*g);
      if (h >= -0.1 && h <= 0.1) {
        h = 0;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + h;
      }
    } else if (b.equals("") && e.equals("") && f.equals("")) {
      errorMessage = false;
      if (h == 0) {
        angle = Math.asin((totalTime*g)/(2*iVelocity));
        angleInDegrees = Math.toDegrees(angle);
        vy = iVelocity * Math.sin(angle);
        vx = iVelocity * Math.cos(angle);
        range = totalTime*vx;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g));
      } else {
        errorMessage = true;
      }
    } else if (a.equals("") && e.equals("") && f.equals("")) {
      errorMessage = false;
      if (h == 0) {
        iVelocity = (totalTime*g)/(2*Math.sin(angle));
        vy = iVelocity * Math.sin(angle);
        vx = iVelocity * Math.cos(angle);
        range = totalTime*vx;
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g));
      } else {
        errorMessage = true;
      }
    } else if (a.equals("") && c.equals("") && f.equals("")) {
      errorMessage = false;
      iVelocity = range/(Math.cos(angle)*totalTime);
      vy = iVelocity * Math.sin(angle);
      vx = iVelocity * Math.cos(angle);
      h = (Math.pow(((range*g)/vx)-vy,2)-Math.pow(vy,2))/(2*g);
      if (h >= -0.1 && h <= 0.1) {
        h = 0;
        maxH = (Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g);
      } else {
        maxH = ((Math.pow(iVelocity,2)*Math.pow(Math.sin(angle),2))/(2*g)) + h;
      }
    } else {
      errorMessage = true;
    }
    if (iVelocity == 0 && angle ==0 && totalTime ==0 && range == 0 && maxH ==0&&h==0) {
      errorMessage = true;
    }
  }
  // @param double to be converted to string
  // @return string of double in the right format
  public String getString(double a) {
    DecimalFormat df = new DecimalFormat("#.##");
    Double d = a;
    String b = df.format(d);
    return b;
  }
  // @param string of data in the time text box
  public void calcParametersAtTime (String t) {
    time = Double.parseDouble(t);
    if (time < totalTime && time > 0) {
      pVX = vx;
      pVY = vy - g*time;
      velocity = Math.sqrt(Math.pow(pVX,2) + Math.pow(pVY,2));
      height = (vy*time)-(0.5*g*Math.pow(time,2));
      distFromLaunch = vx*time;
    }
  }

  public boolean getErrorMessage() {
    return errorMessage;
  }
}
