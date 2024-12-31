import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adviseway", "root", "mahesh");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from test;");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2)); 
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Add it to your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error occurred.");
            e.printStackTrace();
        } 
    }
}
