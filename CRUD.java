import java.sql.*;
import java.util.*;

public class CRUD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int ch;
        String c;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Select Operation : ");
            System.out.println("1. Read >");
            System.out.println("2. Update >");
            System.out.println("3. Delete >");
            System.out.println("4. Insert >");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    try {
                        readFromTable();
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        updateToTable(sc);
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        deleteFromTable(sc);
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        insertIntoTable(sc);
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Choose valid option -->");
            }
            System.out.println("Do you want to continue ? y/n");
            c = sc.next();
        } while (c.equals("y"));
        sc.close();
    }

    private static void readFromTable() throws SQLException, ClassNotFoundException {
        String readQuery = "SELECT * FROM TEST;";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adviseway", "root", "mahesh");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(readQuery);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t");
        }
        con.close();
        System.out.println("Data Fetched Successfully..!");
    }

    private static void updateToTable(Scanner sc) throws SQLException, ClassNotFoundException {
        System.out.println("Enter column name to update: ");
        String col = sc.next();
        System.out.println("Enter new value: ");
        String value = sc.next();
        System.out.println("Enter ID where you want to update: ");
        int id = sc.nextInt();
        String updateQuery = "UPDATE TEST SET " + col + "=? WHERE ID=?;";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adviseway", "root", "mahesh");
        PreparedStatement stmt = con.prepareStatement(updateQuery);
        stmt.setString(1, value);
        stmt.setInt(2, id);
        int rs = stmt.executeUpdate();
        con.close();
        System.out.println("Data Updated Successfully..!");
    }

    private static void deleteFromTable(Scanner sc) throws SQLException, ClassNotFoundException {
        System.out.println("Enter ID you want to delete record: ");
        int id = sc.nextInt();
        String deleteQuery = "DELETE FROM TEST WHERE ID=?;";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adviseway", "root", "mahesh");
        PreparedStatement stmt = con.prepareStatement(deleteQuery);
        stmt.setInt(1, id);
        int rs = stmt.executeUpdate();
        con.close();
        System.out.println("Data Deleted Successfully..!");
    }

    private static void insertIntoTable(Scanner sc) throws SQLException, ClassNotFoundException {
        System.out.println("Enter ID value >");
        int id = sc.nextInt();
        System.out.println("Enter Name value >");
        String name = sc.next();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adviseway", "root", "mahesh");
        String query = "INSERT INTO test (id, name) VALUES (?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        }
        pstmt.close();
        con.close();
    }
}