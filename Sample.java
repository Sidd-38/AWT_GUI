import java.awt.*;
import java.applet.*;
public class Sample extends Applet{

    public void init(){
        setBackground(Color.red);
        setForeground(Color.black);
    }

    public void paint(Graphics g){
        Color c= new Color(0,0,255);
        Font f = new Font("Arial",3,50);
        g.setColor(c);
        g.setFont(f);
        g.drawString("Welcome to my APPLET",301,301);
    }
}
/*
<applet code="Sample" width=600 height=600>
</applet>
*/ 