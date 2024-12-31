import java.awt.*;
import java.applet.*;
// Check box group RadioButton
public class myFrame1 extends Frame{
    myFrame1(){
    GridLayout g = new GridLayout();
    Checkbox c1,c2;
    CheckboxGroup cbg = new CheckboxGroup();
            c1 = new Checkbox("Male",cbg,true);
            c2 = new Checkbox("FeMale",cbg,false);

            add(c1);
            add(c2);
            setTitle("Frame window");
            setLayout(g);
            setVisible(true);
            setSize(500,500);
    }

    public static void main(String args[]){
        myFrame1 obj = new myFrame1();
    }
}