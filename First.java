import java.applet.*;
import java.awt.*;
public class First extends Applet {

  /*public void init() {
    setForeground(Color.white);
    setBackground(Color.blue);
  }*/
  public void paint(Graphics g) { g.drawString("welcome to applet", 50, 50); }
}
/*
 <applet code="First" width =300 height=100>
 </applet>*/