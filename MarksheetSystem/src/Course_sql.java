import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Course_sql {
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:/MarksheetSystem","root","7307");
            System.out.println("Enter course data: ");

            String q="insert into course(c_id,c_name) values(?,?)";


            PreparedStatement pstmt= con.prepareStatement(q);
            Scanner sc = new Scanner(System.in);

            System.out.println("enter Course ID: ");
            int c_id=sc.nextInt();
            sc.nextLine();                               //its absence causes the compiler to search for int and skip the next line...
            System.out.println("enter Course name: ");
            String c_name=sc.nextLine();

            pstmt.setInt(1,c_id);
            pstmt.setString(2,c_name);

            System.out.println("data entered successfully");
            pstmt.executeUpdate();
            pstmt.close();
            sc.close();
            con.close();

    }catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}
}
