import java.awt.*;
import java.applet.*;

public class testFrame extends Frame{
    testFrame(){
        Label l1 = new Label("Enter name here");
        TextField f1 = new TextField();
        l1.setBounds(50,150,150,20);
        Label l2 = new Label("Enter Password here");
        TextField f2 = new TextField();
        TextArea f2 = new TextArea();
        l2.setBounds(50,150,150,20);
        Button b1 = new Button("Submit");
        b1.setBounds(50,200,50,50);
        Button b2 = new Button("Cancel");
        b2.setBounds(50,200,50,50);

            add(l1);
            add(f1);
            add(l2);
            add(f2);
            add(b1);
            add(b2);

        setTitle("Frame window");
        setSize(1440,720);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String args[]){
        testFrame obj = new testFrame();
    }
}