import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;

public class myFrame2 extends Frame implements ActionListener {
    Button b1;
    TextField f1, f2;

    myFrame2() {
        setBackground(Color.cyan);
        FlowLayout flow = new FlowLayout();
        Label mainLabel = new Label("***ENTER YOUR DETAILS HERE:***");
        mainLabel.setBackground(Color.orange);
        mainLabel.setBounds(550, 50, 200, 75);

        Label l1 = new Label("Enter Username here");
        l1.setBounds(475, 150, 150, 20);

        f1 = new TextField("username");
        f1.setBounds(675, 150, 150, 20);

        Label l2 = new Label("Enter Password here");
        l2.setBounds(475, 200, 150, 20);

        f2 = new TextField("password");
        f2.setBounds(675, 200, 150, 20);

        b1 = new Button("Sign Up");
        b1.setBounds(475, 370, 100, 50);
        b1.setBackground(Color.green);
        Button b2 = new Button("Cancel");
        b2.setBounds(675, 370, 100, 50);
        b2.setBackground(Color.red);

        add(mainLabel);
        add(l1);
        add(f1);
        add(l2);
        add(f2);
        add(b1);
        add(b2);

        setTitle("Sign Up Form");
        setSize(1300, 720);
        setLayout(null);
        setVisible(true);

        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adviseway", "root", "mahesh");

            String query = "INSERT INTO test (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, f1.getText()); // Set username
            pstmt.setString(2, f2.getText()); // Set password

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            }

            // Close resources
            pstmt.close();
            con.close();
        } catch (ClassNotFoundException e1) {
            System.out.println("MySQL JDBC Driver not found. Add it to your library path.");
            e1.printStackTrace();
        } catch (SQLException e2) {
            System.out.println("SQL error occurred.");
            e2.printStackTrace();
        }
    }

    public static void main(String args[]) {
        myFrame2 obj = new myFrame2();
    }
}
