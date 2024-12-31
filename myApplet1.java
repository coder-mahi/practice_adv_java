import java.awt.*;
import java.applet.*;
import javax.swing.*;
/*<APPLET code="myApplet1" width=500 height=500>
</APPLET> */
public class myApplet1{
    
    public Frame frame = new Frame();
    
    public Checkbox c1,c2;
    public CheckboxGroup cbg = new CheckboxGroup();
        public void init(){
            c1 = new Checkbox("Male",cbg,true);
            c2 = new Checkbox("FeMale",cbg,false);
        }
        public void paint(Graphics g){
            frame.add(c1);
            frame.add(c2);
            frame.setTitle("Frame window");
            frame.setVisible(true);
            frame.setSize(500,500);
        }
}